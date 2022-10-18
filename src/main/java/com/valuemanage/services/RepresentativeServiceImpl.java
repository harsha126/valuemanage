package com.valuemanage.services;

import com.valuemanage.api.v1.mapper.RetailerInfoMapper;
import com.valuemanage.api.v1.mapper.RetailerListMapper;
import com.valuemanage.api.v1.model.RetailerDTO;
import com.valuemanage.api.v1.model.RetailerInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.repositories.AddressRepository;
import com.valuemanage.repositories.ReportRepository;
import com.valuemanage.repositories.RepresentativeRepository;
import com.valuemanage.repositories.RetailerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@AllArgsConstructor
public class RepresentativeServiceImpl implements RepresentativeService {
    private final RepresentativeRepository representativeRepository;
    private final RetailerRepository retailerRepository;
    private final AddressRepository addressRepository;
    private final RetailerInfoMapper retailerInfoMapper;
    private final RetailerListMapper retailerListMapper;
    private final ReportRepository reportRepository;
    private final ReportService reportService;
    private final AttendenceService attendenceService;


    @Override
    public Page<RetailerDTO> getAllRetailers(Pageable pageable, Long rep_id) {
        return representativeRepository.findAllRetailer(rep_id, pageable).map(retailer -> {
            RetailerDTO retailerDTO = retailerListMapper.RetailerToRetailerDTO(retailer);
            retailerDTO.setRetailerUrl("/api/v1/retailers/" + retailer.getId());
            return retailerDTO;
        });
    }

    @Override
    public Page<RetailerInfoDTO> getRetailerById(Long rep_id, Long ret_id, Pageable pageable) {
        return representativeRepository.findRetailerById(rep_id, ret_id, pageable).map(retailerInfoMapper::RetailerToRetailerInfo);
    }

    @Override
    public RetailerDTO saveRetailer(Long rep_id, NewRetailer newRetailer) {

        System.out.println(newRetailer.toString());
        Address address = Address.builder().houseNo(newRetailer.getHouseNo()).street(newRetailer.getStreet()).city(newRetailer.getCity()).state(newRetailer.getState()).pinCode(newRetailer.getPinCode()).country(newRetailer.getCountry()).build();
        Retailer retailer = Retailer.builder().name(newRetailer.getName()).businessName(newRetailer.getBusinessName()).phoneNumber(newRetailer.getPhoneNumber()).owner(newRetailer.getOwner()).build();
        Address savedAddress = addressRepository.save(address);
        retailer.setAddress(savedAddress);
        Retailer savedRetailer = retailerRepository.save(retailer);
        Representative representative = representativeRepository.findById(rep_id).get();
        representative.getRetailers().add(savedRetailer);
        representativeRepository.save(representative);
        return retailerListMapper.RetailerToRetailerDTO(savedRetailer);
    }

    @Override
    public Report saveReport(Long rep_id, NewReport newReport) throws ParseException {
        Report savedReport = reportService.save(newReport);
        Representative representative = representativeRepository.findById(rep_id).get();
        representative.getReports().add(savedReport);
        representativeRepository.save(representative);
        return savedReport;
    }

    @Override
    public List<Report> checkReport(Long rep_id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return representativeRepository.findReportByDate(rep_id, format.parse(format.format(new Date())));
    }

    @Override
    public Attendence addAttendance(Long rep_id, Attendence attendence) throws ParseException {
        Attendence attendence1 = Attendence.builder().date(new Date()).build();
        Attendence saved = attendenceService.save(attendence1);
        Representative representative = representativeRepository.findById(rep_id).get();
        representative.getAttendances().add(saved);
        representativeRepository.save(representative);
        return saved;
    }

    public Attendence getAttendance(Long rep_id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(format.format(new Date()));
        Attendence attendence = representativeRepository.getAttendance(rep_id, date);
        if (attendence == null) return new Attendence();
        return attendence;
    }

    @Override
    public List<Attendence> getAllAttendence(Long rep_id) {
        return representativeRepository.getAllAttendence(rep_id);
    }

    @Override
    public boolean checkForRetailers(Long rep_id, Long ret_id) {
        return representativeRepository.checkForRetailers(rep_id, ret_id);
    }

    private static Calendar getCalendarForNow(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static void setTimeToBeginningOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setTimeToEndofDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }
    @Override
    public Pair<Date, Date> getDateRange(Date date) {
        Date begin ,end;
        {
            Calendar calendar = getCalendarForNow(date);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            setTimeToBeginningOfDay(calendar);
            begin = calendar.getTime();
        }

        {
            Calendar calendar = getCalendarForNow(date);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            setTimeToEndofDay(calendar);
            end = calendar.getTime();
        }

        return Pair.of(begin,end);

    }


}
