package com.company.entity;

import com.company.CrawlingStatus;

import java.time.LocalDateTime;
import java.util.Optional;

public class Webinar extends CrawlableEntity {
    private LocalDateTime startDate;
    private String description;
    private String language;

    public Webinar(String link, String name, CrawlingStatus crawlingStatus, Boolean isDeleted, Boolean isBlacklisted,
                   Optional<LocalDateTime> lastCrawled, LocalDateTime startDate, Optional<String> description, String language) {
        super(link, name, crawlingStatus, isDeleted, isBlacklisted, lastCrawled);
        this.startDate = startDate;
        this.description = description.orElse(null);
        this.language = language != null ? language : "en";
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Webinar{" +
                "startDate=" + startDate +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                "} " + super.toString();
    }
}
