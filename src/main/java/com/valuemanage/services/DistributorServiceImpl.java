package com.valuemanage.services;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.domain.Distributor;
import com.valuemanage.repositories.DistributorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DistributorServiceImpl implements DistributorService {
    private final DistributorRepository distributorRepository;

    public DistributorServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public Page<DistributorDTO> getAllDistributors(Pageable pageable) {
        return null;
    }

    @Override
    public Distributor save(Distributor distributor) {
        return distributorRepository.save(distributor);
    }
}
