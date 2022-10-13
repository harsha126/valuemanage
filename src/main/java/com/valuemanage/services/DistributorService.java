package com.valuemanage.services;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.domain.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DistributorService {
    Page<DistributorDTO> getAllDistributors(Pageable pageable);

    Distributor save(Distributor distributor);
}
