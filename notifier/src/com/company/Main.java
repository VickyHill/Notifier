package com.company;

import com.company.entity.Company;
import com.company.entity.EntityType;
import com.company.entitynotifier.BaseEventNotifier;
import com.company.entitynotifier.CompanyForEventNotifier;
import com.company.entitynotifier.CompanyNotifier;
import com.company.entitynotifier.EventNotifier;

import java.util.HashSet;
import java.util.Optional;

public class Main {
    private static INotifier notifier;

    public static void main(String[] args) {
        notifier = new Notifier(new HashSet<BaseEventNotifier>(){{
            add(new CompanyNotifier());
            add(new EventNotifier());
            add(new CompanyForEventNotifier());
            //others notifiers when implemented
        }});

        test(Main::testCompanyDoesntMeetCondition, "testCompanyDoesntMeetCondition");
        test(Main::testNewCompanyEvent, "testNewCompanyEvent");
        test(Main::testPhysicallyDeletedCompanyEvent, "testPhysicallyDeletedCompanyEvent");
        test(Main::testCompanyChangedToDeleted, "testCompanyBecomeDeleted");
        test(Main::testCompanyBecomeUnDeleted, "testCompanyBecomeUnDeleted");
        test(Main::testCompanyCrawlingStatusSetToTextAnalyzed, "testCompanyCrawlingStatusSetToTextAnalyzed");
    }

    private static void test(Runnable runnable, String message) {
        System.out.println("\nStarting to test " + message);
        runnable.run();
        System.out.println("Finished testing " + message);
    }

    private static void testCompanyDoesntMeetCondition() {
        Company currCompany = new Company("link2", "name", null, null, null,
                Optional.empty(), 100, 201);
        Company origCompany = new Company("link", "name4", CrawlingStatus.CRAWLING, null, null,
                Optional.empty(), 100, 200);

        notifier.doNotify(currCompany, origCompany, EntityType.Company);
    }

    private static void testNewCompanyEvent() {
        Company currCompany = new Company("link", "name", null, null, null,
                Optional.empty(), 100, 200);
        notifier.doNotify(currCompany, null, EntityType.Company);
    }

    private static void testPhysicallyDeletedCompanyEvent() {
        Company origCompany = new Company("link", "name", null, null, null,
                Optional.empty(), 100, 200);
        notifier.doNotify(null, origCompany, EntityType.Company);
    }

    private static void testCompanyChangedToDeleted() {
        Company currCompany = new Company("link", "name", null, true, null,
                Optional.empty(), 100, 200);
        Company origCompany = new Company("link", "name", null, false, null,
                Optional.empty(), 100, 200);

        notifier.doNotify(currCompany, origCompany, EntityType.Company);
    }

    private static void testCompanyBecomeUnDeleted() {
        Company currCompany = new Company("link", "name", null, false, null,
                Optional.empty(), 100, 200);
        Company origCompany = new Company("link", "name", null, true, null,
                Optional.empty(), 100, 200);

        notifier.doNotify(currCompany, origCompany, EntityType.Company);
    }

    private static void testCompanyCrawlingStatusSetToTextAnalyzed() {
        Company currCompany = new Company("link", "name", CrawlingStatus.TEXT_ANALYZED, null, null,
                Optional.empty(), 100, 200);
        Company origCompany = new Company("link", "name", null, null, null,
                Optional.empty(), 100, 200);

        notifier.doNotify(currCompany, origCompany, EntityType.Company);
    }
}
