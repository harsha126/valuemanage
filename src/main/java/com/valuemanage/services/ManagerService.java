package com.valuemanage.services;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.domain.NewDistributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {
    public Page<DistributorDTO> getAllDistributors(Long man_id,Pageable pageable);
    public DistributorDTO saveNewDistributor(Long man_id, NewDistributor newDistributor);

    public Page<RepresentativeDTO> getAllRepresentatives(Long man_id,Pageable pageable);
}
