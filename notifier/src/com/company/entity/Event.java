package com.company.entity;

import com.company.CrawlingStatus;

import java.time.LocalDateTime;
import java.util.Optional;

public class Event extends CrawlableEntity {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private String location;

    public Event(String link, String name, CrawlingStatus crawlingStatus, Boolean isDeleted, Boolean isBlacklisted,
                 Optional<LocalDateTime> lastCrawled, LocalDateTime startDate,
                 Optional<LocalDateTime> endDate, Optional<String> description, Optional<String> location) {
        super(link, name, crawlingStatus, isDeleted, isBlacklisted, lastCrawled);
        this.startDate = startDate;
        this.endDate = endDate.orElse(null);
        this.description = description.orElse(null);
        this.location = location.orElse(null);
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                "} " + super.toString();
    }
}
