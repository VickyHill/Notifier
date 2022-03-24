package com.company.entitynotifier;

import com.company.CrawlingStatus;
import com.company.entity.Company;
import com.company.entity.EntityType;

import java.util.Optional;

public class CompanyNotifier extends BaseEventNotifier<Company> {

    @Override
    public boolean shouldHandle(EntityType entityType) {
        return EntityType.Company == entityType;
    }

    @Override
    protected boolean entitySpecificConditionsMet(Company entityObj, Company originalEntityObj) {
        return CrawlingStatus.TEXT_ANALYZED == entityObj.getCrawlingStatus()
                || CrawlingStatus.TEXT_UPLOADED == entityObj.getCrawlingStatus();
    }

    @Override
    protected Object getNotifyOn(Company entityObj) {
        return entityObj;
    }

}
