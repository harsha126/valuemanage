package com.valuemanage.api.v1.mapper;

import com.valuemanage.api.v1.model.RepresentativeInfoDTO;
import com.valuemanage.domain.Attendence;
import com.valuemanage.domain.Report;
import com.valuemanage.domain.Representative;
import com.valuemanage.domain.Retailer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RepresentativeInfoMapper {
    public RepresentativeInfoMapper() {
    }

    public RepresentativeInfoDTO RepresentativeToRepresentativeInfo(Representative Representative) {
        if (Representative == null) {
            return null;
        } else {
            RepresentativeInfoDTO RepresentativeInfoDTO = new RepresentativeInfoDTO();
            RepresentativeInfoDTO.setId(Representative.getId());
            RepresentativeInfoDTO.setName(Representative.getName());
            RepresentativeInfoDTO.setBusinessName(Representative.getBusinessName());
            RepresentativeInfoDTO.setPhoneNumber(Representative.getPhoneNumber());
            RepresentativeInfoDTO.setOwner(Representative.getOwner());
            Set<Attendence> set = Representative.getAttendances();
            if (set != null) {
                RepresentativeInfoDTO.setAttendances(new HashSet(set));
            }

            Set<Report> set1 = Representative.getReports();
            if (set1 != null) {
                RepresentativeInfoDTO.setReports(new HashSet(set1));
            }

            Set<Retailer> set2 = Representative.getRetailers();
            if (set2 != null) {
                Set<String> set3 = new HashSet<>();
                set2.forEach(Retailer -> {
                    if (Retailer.getBusinessName() != null) set3.add(Retailer.getBusinessName());
                });
                RepresentativeInfoDTO.setRetailers(set3);
            }
            return RepresentativeInfoDTO;
        }
    }

}
