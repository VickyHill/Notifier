package com.company.entity;

public enum EntityType {
    Event("Event"),
    Company("Company"),
    Webinar("Webinar"),
    ContentItem("ContentItem"),
    CompanyForEvent("CompanyForEvent"),
    CompanyForWebinar("CompanyForWebinar"),
    CompanyCompetitor("CompanyCompetitor");

    private String type;

    private EntityType(String type) {
        this.type = type;
    }
}
