package org.leder11011.test;

import org.leder11011.gui.GuiController;
import org.leder11011.logic.FileHandler;
import org.leder11011.model.DutyRosterEntry;
import org.leder11011.model.Employee;
import org.leder11011.model.Resource;
import org.leder11011.settings.AppTexts;
import org.leder11011.ui.UiController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Test class using models and logic
 */

public class TestMain {
    //region Constants
    //endregion

    //region Attributs
    //endregion

    //region Constructors
    public TestMain() {
    }
    //endregion

    //region Methods
    public static void main(String[] args){

        GuiController guiController = new GuiController();

        guiController.startW();

        //Testen von FileHandler
        //Lesen
//        List<DutyRosterEntry> dutiesList = FileHandler.getInstance().readDutiesFromCsvFile();
//        for (DutyRosterEntry duty : dutiesList) {
//            System.out.println(duty);
//        }

        //Schreiben
//        List<DutyRosterEntry> dutiesList = TestData.generateTestDuties();
//        List<Employee> employeeList = TestData.generateTestEmployees();
//
//        FileHandler.getInstance().writeDutiesToCsvFile(dutiesList);
//
//        FileHandler.getInstance().writeEmployeesToCsvFile(employeeList);



//        DutyRosterEntry firstDutyRosterEntry = new DutyRosterEntry(LocalDate.parse("2024-03-26"), Resource.RTW, "5-83-1", new Employee("Leder", "Gerrit"), new Employee());
//
//        System.out.println(firstDutyRosterEntry);
//        System.out.println(firstDutyRosterEntry.getResource().name());

    }
    //endregion


}
