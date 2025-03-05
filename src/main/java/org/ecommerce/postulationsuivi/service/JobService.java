package org.ecommerce.postulationsuivi.service;

import org.ecommerce.postulationsuivi.entity.Job;
import org.ecommerce.postulationsuivi.repository.JobRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll(Sort.by(Sort.Order.desc("applicationDate")));
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job addJob(Job job) {
        job.setApplicationDate(LocalDate.now()); // Set current date by default
        job.setStatus("Pending"); // Default status
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job updatedJob) {
        return jobRepository.findById(id).map(job -> {
            job.setTitle(updatedJob.getTitle());
            job.setCompany(updatedJob.getCompany());
            job.setCity(updatedJob.getCity());
            job.setContractType(updatedJob.getContractType());
            job.setSalary(updatedJob.getSalary());
            job.setDescription(updatedJob.getDescription());
            job.setStatus(updatedJob.getStatus());
            return jobRepository.save(job);
        }).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public Job updateJobStatus(Long id, String status) {
        return jobRepository.findById(id).map(job -> {
            job.setStatus(status);
            return jobRepository.save(job);
        }).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> filterJobsByStatus(String status) {
        return jobRepository.findByStatus(status);
    }

    public List<Job> filterJobsByCity(String city) {
        return jobRepository.findByCity(city);
    }

    public List<Job> filterJobsByDate(LocalDate startDate, LocalDate endDate) {
        return jobRepository.findByApplicationDateBetween(startDate, endDate);
    }
}
