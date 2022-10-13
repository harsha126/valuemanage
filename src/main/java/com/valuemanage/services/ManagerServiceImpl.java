package com.valuemanage.services;

import com.valuemanage.api.v1.mapper.DistributorListMapper;
import com.valuemanage.api.v1.mapper.RepresentativeListMapper;
import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.domain.Address;
import com.valuemanage.domain.Distributor;
import com.valuemanage.domain.Manager;
import com.valuemanage.domain.NewDistributor;
import com.valuemanage.repositories.ManagerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final DistributorListMapper distributorListMapper;
    private final AttendenceService attendenceService;
    private final AddressService addressService;
    private final DistributorService distributorService;
    private final RepresentativeListMapper representativeListMapper;


    public ManagerServiceImpl(ManagerRepository managerRepository, DistributorListMapper distributorListMapper, AttendenceService attendenceService, AddressService addressService, DistributorService distributorService, RepresentativeListMapper representativeListMapper) {
        this.managerRepository = managerRepository;
        this.distributorListMapper = distributorListMapper;
        this.attendenceService = attendenceService;
        this.addressService = addressService;
        this.distributorService = distributorService;
        this.representativeListMapper = representativeListMapper;
    }

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
        return managerRepository.findAllRepresentatives(man_id,pageable).map(representativeListMapper::RepresentativeToRepresentativeDTO);
    }
}
