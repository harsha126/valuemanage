package com.valuemanage.repositories;

import com.valuemanage.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
