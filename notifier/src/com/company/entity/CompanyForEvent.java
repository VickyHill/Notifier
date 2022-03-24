package com.company.entity;

public class CompanyForEvent extends Entity {
    private Event event;
    private Company company;
    private Boolean isBlacklisted;

    public CompanyForEvent(Event event, Company company, Boolean isDeleted, Boolean isBlacklisted) {
        super(isDeleted);
        this.event = event;
        this.company = company;
        this.isBlacklisted = isBlacklisted != null ? isBlacklisted :false;
    }

    public Event getEvent() {
        return event;
    }

    public Company getCompany() {
        return company;
    }

    public Boolean getBlacklisted() {
        return isBlacklisted;
    }

    @Override
    public String toString() {
        return "CompanyForEvent{" +
                "event=" + event +
                ", company=" + company +
                ", isBlacklisted=" + isBlacklisted +
                "} " + super.toString();
    }
}
