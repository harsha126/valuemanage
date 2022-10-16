package com.valuemanage.services;

import com.valuemanage.api.v1.mapper.DistributorListMapper;
import com.valuemanage.api.v1.mapper.RepresentativeInfoMapper;
import com.valuemanage.api.v1.mapper.RepresentativeListMapper;
import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.*;
import com.valuemanage.repositories.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final DistributorListMapper distributorListMapper;
    private final AttendenceService attendenceService;
    private final AddressService addressService;
    private final DistributorService distributorService;
    private final RepresentativeListMapper representativeListMapper;
    private final ReportService reportService;
    private final RepresentativeInfoMapper representativeInfoMapper;

    @Override
    public Page<DistributorDTO> getAllDistributors(Long man_id, Pageable pageable) {
        return managerRepository.findAllDistributors(man_id, pageable).map(distributorListMapper::DistributorToDistributorDTO);
    }

    @Override
    public DistributorDTO saveNewDistributor(Long man_id, NewDistributor newDistributor) {
        Address address = Address.builder().houseNo(newDistributor.getHouseNo()).street(newDistributor.getStreet()).city(newDistributor.getCity()).state(newDistributor.getState()).pinCode(newDistributor.getPinCode()).country(newDistributor.getCountry()).build();
        Address savedAddress = addressService.save(address);
        Distributor distributor = Distributor.builder().name(newDistributor.getName()).businessName(newDistributor.getBusinessName()).phoneNumber(newDistributor.getPhoneNumber()).owner(newDistributor.getOwner()).erp(newDistributor.getErp()).address(savedAddress).build();
        Distributor savedDistributor = distributorService.save(distributor);
        Manager manager = managerRepository.findById(man_id).get();
        manager.getDistributors().add(savedDistributor);
        managerRepository.save(manager);
        return distributorListMapper.DistributorToDistributorDTO(savedDistributor);
    }

    @Override
    public Page<RepresentativeDTO> getAllRepresentatives(Long man_id, Pageable pageable) {
        return managerRepository.findAllRepresentatives(man_id, pageable).map(representativeListMapper::RepresentativeToRepresentativeDTO);
    }

    @Override
    public Attendence addAttendance(Long man_id, Attendence attendence) throws ParseException {
        Attendence attendence1 = Attendence.builder().date(new Date()).build();
        Attendence saved = attendenceService.save(attendence1);
        Manager manager = managerRepository.findById(man_id).get();
        manager.getAttendances().add(saved);
        managerRepository.save(manager);
        return saved;
    }

    @Override
    public Attendence getAttendance(Long man_id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(format.format(new Date()));
        Attendence attendence = managerRepository.getAttendance(man_id, date);
        if (attendence == null) return new Attendence();
        return attendence;
    }

    @Override
    public List<Attendence> getAllAttendence(Long man_id) {
        return managerRepository.getAllAttendence(man_id);
    }

    @Override
    public Report saveReport(Long man_id, NewReport newReport) throws ParseException {
        Report savedReport = reportService.save(newReport);
        Manager manager = managerRepository.findById(man_id).get();
        manager.getReports().add(savedReport);
        managerRepository.save(manager);
        return savedReport;
    }

    @Override
    public Report checkReport(Long man_id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return managerRepository.findReportByDate(man_id, format.parse(format.format(new Date())));
    }

    @Override
    public RepresentativeInfoDTO getRepresentativeById(Long man_id, Long rep_id) {
        return (representativeInfoMapper.RepresentativeToRepresentativeInfo(managerRepository.findAllReps(man_id, rep_id)));
    }

    @Override
    public boolean checkForRepresentative(Long man_id, Long rep_id) {
        return managerRepository.checkForRepresentative(man_id, rep_id);
    }


//    @Override
//    public Page<Representative> getAllReps(Long man_id,Pageable pageable) {
//        return managerRepository.findAllReps(man_id,pageable);
//    }
}
