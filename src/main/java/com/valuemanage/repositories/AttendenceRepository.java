package com.valuemanage.repositories;

import com.valuemanage.domain.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepository extends JpaRepository<Attendence, Long> {
}
