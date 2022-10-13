package com.valuemanage.repositories;

import com.valuemanage.domain.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {
}