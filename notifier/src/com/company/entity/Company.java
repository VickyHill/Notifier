package com.company.entity;

import com.company.CrawlingStatus;

import java.time.LocalDateTime;
import java.util.Optional;

public class Company extends CrawlableEntity {
    private Integer employeesMin;
    private Integer employeesMax;

    public Company(String link, String name, CrawlingStatus crawlingStatus, Boolean isDeleted, Boolean isBlacklisted,
                   Optional<LocalDateTime> lastCrawled, Integer employeesMin, Integer employeesMax) {
        super(link, name, crawlingStatus, isDeleted, isBlacklisted, lastCrawled);
        this.employeesMin = employeesMin;
        this.employeesMax = employeesMax;
    }

    public Integer getEmployeesMin() {
        return employeesMin;
    }

    public Integer getEmployeesMax() {
        return employeesMax;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeesMin=" + employeesMin +
                ", employeesMax=" + employeesMax +
                "} " + super.toString();
    }
}
