package org.ecommerce.postulationsuivi.controller;

import org.ecommerce.postulationsuivi.entity.Job;
import org.ecommerce.postulationsuivi.service.JobService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        return ResponseEntity.ok(jobService.updateJob(id, job));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Job> updateJobStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(jobService.updateJobStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter-by-status")
    public List<Job> filterJobsByStatus(@RequestParam String status) {
        return jobService.filterJobsByStatus(status);
    }

    @GetMapping("/filter-by-city")
    public List<Job> filterJobsByCity(@RequestParam String city) {
        return jobService.filterJobsByCity(city);
    }

    @GetMapping("/filter-by-date")
    public ResponseEntity<List<Job>> filterJobsByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<Job> jobs = jobService.filterJobsByDate(startDate, endDate);
        return ResponseEntity.ok(jobs);
    }
}
