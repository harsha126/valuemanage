package com.valuemanage.repositories;

import com.valuemanage.domain.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
    Page<Retailer> findById(Long Id, Pageable pageable);
}
