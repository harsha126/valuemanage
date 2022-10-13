package com.valuemanage.repositories;

import com.valuemanage.domain.Distributor;
import com.valuemanage.domain.Manager;
import com.valuemanage.domain.Representative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    @Query("select d from Manager m join m.distributors d where m.id = ?1 ")
    Page<Distributor> findAllDistributors(Long man_id, Pageable pageable);
    @Query("select rep from Manager m join m.representatives rep where m.id = ?1 ")
    Page<Representative> findAllRepresentatives(Long man_id,Pageable pageable);
}
