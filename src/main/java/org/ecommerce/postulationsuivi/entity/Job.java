package org.ecommerce.postulationsuivi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String city;
    private String contractType; // Full-time, Part-time, Internship
    private LocalDate applicationDate;
    private String platform;
    private String linkUrl;
    private String salary;

    @Column(length = 10000)
    private String description;

    private String status; // Pending, Accepted, Rejected

    public Long getId() {
        return id;
    }

    public Job setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Job setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Job setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Job setCity(String city) {
        this.city = city;
        return this;
    }

    public String getContractType() {
        return contractType;
    }

    public Job setContractType(String contractType) {
        this.contractType = contractType;
        return this;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public Job setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Job setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Job setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Job setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public Job setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public Job setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }
}
