package com.company.entity;

import com.company.CrawlingStatus;

import java.time.LocalDateTime;
import java.util.Optional;

public class ContentItem extends CrawlableEntity {
    private String snippet;
    private Company company;

    public ContentItem(String link, String name, CrawlingStatus crawlingStatus, Boolean isDeleted,
                       Boolean isBlacklisted, Optional<LocalDateTime> lastCrawled, Optional<String> snippet,
                       Company company) {
        super(link, name, crawlingStatus, isDeleted, isBlacklisted, lastCrawled);
        this.snippet = snippet.orElse(null);
        this.company = company;
    }

    public String getSnippet() {
        return snippet;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "ContentItem{" +
                "snippet='" + snippet + '\'' +
                ", company=" + company +
                "} " + super.toString();
    }
}
