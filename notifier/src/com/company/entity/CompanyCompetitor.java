package com.company.entity;

public class CompanyCompetitor extends Entity {
    private Company company;
    private Company competitor;

    public CompanyCompetitor(Company company, Company competitor, Boolean isDeleted) {
        super(isDeleted);
        this.company = company;
        this.competitor = competitor;
    }

    public Company getCompany() {
        return company;
    }

    public Company getCompetitor() {
        return competitor;
    }

    @Override
    public String toString() {
        return "CompanyCompetitor{" +
                "company=" + company +
                ", competitor=" + competitor +
                "} " + super.toString();
    }
}
