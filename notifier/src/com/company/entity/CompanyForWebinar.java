package com.company.entity;

public class CompanyForWebinar extends Entity {
    private Webinar webinar;
    private Company company;
    private Boolean isBlacklisted;

    public CompanyForWebinar(Webinar webinar, Company company, Boolean isDeleted, Boolean isBlacklisted) {
        super(isDeleted);
        this.webinar = webinar;
        this.company = company;
        this.isBlacklisted = isBlacklisted != null ? isBlacklisted : false;
    }

    public Webinar getWebinar() {
        return webinar;
    }

    public Company getCompany() {
        return company;
    }

    public Boolean getBlacklisted() {
        return isBlacklisted;
    }

    @Override
    public String toString() {
        return "CompanyForWebinar{" +
                "webinar=" + webinar +
                ", company=" + company +
                ", isBlacklisted=" + isBlacklisted +
                "} " + super.toString();
    }
}
