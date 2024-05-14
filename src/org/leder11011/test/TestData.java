package org.leder11011.test;

import org.leder11011.model.DutyRosterEntry;
import org.leder11011.model.Employee;
import org.leder11011.model.Resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Generiert Testdaten
 */
public class TestData {
    //region Konstanten
    public static final int TEST_DATA_AMOUNT = 5;
    //endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    private TestData() {

    }
    //endregion

    //region Methoden
    public static List<DutyRosterEntry> generateTestDuties() {
        List<DutyRosterEntry> testDuties = new ArrayList<>();

//        for (int i = 0; i < TEST_DATA_AMOUNT; i++) {
//            testSmartphones.add(new Smartphone(Brand.Apple, "Modell " + (i+1), (i+1)*128, (i+1)*100));
//        }

        testDuties.add(new DutyRosterEntry(LocalDate.parse("2024-03-26"), Resource.RTW, "5-83-1", new Employee("Leder", "Gerrit"), new Employee("Mack", "Carsten")));
        testDuties.add(new DutyRosterEntry(LocalDate.now(), Resource.KTW, "5-85-2", new Employee("Leder", "Gerrit"), new Employee("Mack", "Carsten")));
        testDuties.add(new DutyRosterEntry(LocalDate.now(), Resource.CONTROLCENTER, "5-00", new Employee("Rose", "Stefan"), null));

        //        testSmartphones.add(new Smartphone(Brand.Samsung, "S21", 512, 600));
//        testSmartphones.add(new Smartphone(Brand.Xiaomi, "10T Pro", 256, 400));
//        testSmartphones.add(new Smartphone(Brand.Xiaomi, "11T", 1024, 700));
//        testSmartphones.add(new Smartphone(Brand.Apple, "iPhone 15 Pro Max", 1024, 1400));

        return testDuties;
    }

    public static List<Employee> generateTestEmployees() {
        List<Employee> testEmployees = new ArrayList<Employee>();

        testEmployees.add(new Employee("Leder", "Gerrit"));

        testEmployees.add(new Employee("Mack", "Carsten"));

        testEmployees.add(new Employee("Rose", "Stefan"));


        return testEmployees;

    }
    //endregion
}
