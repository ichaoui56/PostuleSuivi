package org.ecommerce.postulationsuivi.repository;

import org.ecommerce.postulationsuivi.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByStatus(String status);
    List<Job> findByCity(String city);
    List<Job> findByApplicationDateBetween(LocalDate startDate, LocalDate endDate);

}
