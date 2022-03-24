package com.company.entity;



import com.company.CrawlingStatus;
import com.sun.istack.internal.Nullable;

import java.time.LocalDateTime;
import java.util.Optional;

public class CrawlableEntity extends Entity {
    private String link;
    private String name;
    private CrawlingStatus crawlingStatus;
    private Boolean isBlacklisted;
    private LocalDateTime lastCrawled;

    public CrawlableEntity(String link, String name, CrawlingStatus crawlingStatus, Boolean isDeleted,
                           Boolean isBlacklisted, Optional<LocalDateTime> lastCrawled) {
        super(isDeleted);
        this.link = link;
        this.name = name;
        this.crawlingStatus = crawlingStatus != null ? crawlingStatus : CrawlingStatus.NOT_CRAWLED;
        this.isBlacklisted = isBlacklisted != null ? isBlacklisted : false;
        this.lastCrawled = lastCrawled.orElse(null);
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public CrawlingStatus getCrawlingStatus() {
        return crawlingStatus;
    }

    public Boolean getBlacklisted() {
        return isBlacklisted;
    }

    public LocalDateTime getLastCrawled() {
        return lastCrawled;
    }

    @Override
    public String toString() {
        return "CrawlableEntity{" +
                "link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", crawlingStatus=" + crawlingStatus +
                ", isBlacklisted=" + isBlacklisted +
                ", lastCrawled=" + lastCrawled +
                "} " + super.toString();
    }
}
