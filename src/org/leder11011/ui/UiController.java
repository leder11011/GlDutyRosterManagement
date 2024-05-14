package org.leder11011.ui;

import de.rhistel.logic.ConsoleReader;
import org.leder11011.logic.FileHandler;
import org.leder11011.model.DateComparator;
import org.leder11011.model.DutyRosterEntry;
import org.leder11011.model.Employee;
import org.leder11011.model.Resource;
import org.leder11011.settings.AppCommands;
import org.leder11011.settings.AppTexts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.leder11011.settings.AppTexts.APP_NAME;
import static org.leder11011.settings.AppTexts.TEMPLATE_APP_HEADER;

/**
 * App input and output via console and programm execution handling
 */
public class UiController {

    public static final String CSV_FILE_PATH_DUTIES = "resources/duties.csv";
    public static final String CSV_FILE_PATH_EMPLOYEES = "resources/employees.csv";

    //endregion

    //region Attributs

    static List<DutyRosterEntry> duties = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    //endregion

    //region Constructors
    public UiController() {
    }
    //endregion

    //region Methods
    public static void startApp() {

        initializeDuties();
        initializeEmployees();
        printAppHeader();

        handleMainMenuUserInteraction();
    }

    private static void initializeEmployees() {
//        employees = TestData.generateTestEmployees();

        employees = FileHandler.getInstance().readEmployeesFromCsvFile();
    }


    private static void handleMainMenuUserInteraction() {
        boolean continueApp = true;

        do {
            printMainMenu();

            switch (ConsoleReader.in.readPositivInt()) {
                case AppCommands.CREATE -> createDuty();
                case AppCommands.SHOW_TODAY_AND_LATER -> showDutiesTodayAndLater();
                case AppCommands.SHOW_BEFORE_TODAY -> showDutiesBeforeToday();
                case AppCommands.UPDATE -> updateDuty();
                case AppCommands.DELETE -> deleteDuty();
                case AppCommands.EXIT -> continueApp = false;
                default -> System.out.println(AppTexts.TXT_INVALID_CHOICE);
            }

        } while (continueApp);

        System.out.println(AppTexts.TXT_CONFIRMATION_SAVE);
        if (ConsoleReader.in.readMandatoryAnswerToBinaryQuestion()) {
            saveDutiesAndEmployees();
        }

        System.out.println(AppTexts.TXT_EXIT_APP);
    }

    private static void showDutiesBeforeToday() {
        System.out.println(AppTexts.TXT_DUTY_LIST_BEFORE_TODAY);

        System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_HEADER,
                AppTexts.COLUMN_INDEX, AppTexts.COLUMN_DATE, AppTexts.COLUMN_RESOURCE,
                AppTexts.COLUMN_VEHICLE, AppTexts.COLUMN_EMPLOYEE1, AppTexts.COLUMN_EMPLOYEE2);

//        Employee employee2 = null;

        for (int i = 0; i < duties.size(); i++) {

            LocalDate today = LocalDate.now();

            LocalDate dutyDate = duties.get(i).getDate();

            if (today.isBefore(dutyDate) || today.isEqual(dutyDate)) continue;

            Employee employee2 = duties.get(i).getEmployee2();

            if (employee2 == null || employee2.getName() == null) {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        "n/a");
//                        duties.get(i).toString());
            } else {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        employee2);
//                        duties.get(i).toString());

            }


        }
    }

    private static void createDuty() {
        LocalDate date = UiInputHelper.getValidDate();
        Resource resource = UiInputHelper.getValidResource();
        String vehicle = UiInputHelper.getValidVehicle(resource);
        Employee employee1 = UiInputHelper.getValidEmployee(AppTexts.TXT_INPUT_EMPLOYEE1);
        Employee employee2 = null;
        if (!resource.equals(Resource.CONTROLCENTER)) {
            employee2 = UiInputHelper.getValidEmployee(AppTexts.TXT_INPUT_EMPLOYEE2);
        }

        //Objekt mit den vorherigen Eingaben anlegen
        DutyRosterEntry duty  = new DutyRosterEntry(date, resource, vehicle, employee1, employee2);

        //Objekt der Liste hinzufügen
        duties.add(duty);

        duties.sort(new DateComparator());

        System.out.println("Duty created.");
        //Änderungen in die Datei übertragen
        saveDutiesAndEmployees();
    }

    private static void showDutiesTodayAndLater() {
        System.out.println(AppTexts.TXT_DUTY_LIST_TODAY_AND_LATER);

        System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_HEADER,
                AppTexts.COLUMN_INDEX, AppTexts.COLUMN_DATE, AppTexts.COLUMN_RESOURCE,
                AppTexts.COLUMN_VEHICLE, AppTexts.COLUMN_EMPLOYEE1, AppTexts.COLUMN_EMPLOYEE2);

        for (int i = 0; i < duties.size(); i++) {

            LocalDate today = LocalDate.now();

            LocalDate dutyDate = duties.get(i).getDate();

            if (today.isAfter(dutyDate)) continue;

            Employee employee2 = duties.get(i).getEmployee2();

            if (employee2 == null || employee2.getName() == null) {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        "n/a");
//                        duties.get(i).toString());
            } else {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        employee2);
//                        duties.get(i).toString());

            }


        }
    }



    private static void deleteDuty() {

        showAllDuties();

        if (!duties.isEmpty()) {
            int indexToDelete = UiInputHelper.getValidDutiesListIndex(AppTexts.TXT_CHOOSE_INDEX_TO_DELETE);

            System.out.println(AppTexts.TXT_DELETE_CONFIRMATION);

            boolean delete = ConsoleReader.in.readMandatoryAnswerToBinaryQuestion();

            if (delete) {
                duties.remove(indexToDelete);

                System.out.println(AppTexts.TXT_DELETION_SUCCESS);
            } else {
                System.out.println(AppTexts.TXT_DELETION_CANCELED);
            }

        } else System.out.println(AppTexts.TXT_DUTY_ROSTER_IS_EMPTY);


        saveDutiesAndEmployees();


    }

    private static void showAllDuties() {
        System.out.println(AppTexts.TXT_DUTY_LIST);

        System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_HEADER,
                AppTexts.COLUMN_INDEX, AppTexts.COLUMN_DATE, AppTexts.COLUMN_RESOURCE,
                AppTexts.COLUMN_VEHICLE, AppTexts.COLUMN_EMPLOYEE1, AppTexts.COLUMN_EMPLOYEE2);

        for (int i = 0; i < duties.size(); i++) {

//            LocalDate today = LocalDate.now();

            LocalDate dutyDate = duties.get(i).getDate();

//            if (today.isAfter(dutyDate)) continue;

            Employee employee2 = duties.get(i).getEmployee2();

            if (employee2 == null || employee2.getName() == null) {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        "n/a");
//                        duties.get(i).toString());
            } else {
                System.out.printf(AppTexts.TEMPLATE_DUTY_LIST_ENTRY,
                        i,
                        dutyDate, duties.get(i).getResource(),
                        duties.get(i).getVehicle(), duties.get(i).getEmployee1(),
                        employee2);
//                        duties.get(i).toString());

            }


        }
    }

    private static void updateDuty() {

        showAllDuties();

        if (!duties.isEmpty()) {
            int indexToUpdate = UiInputHelper.getValidDutiesListIndex(AppTexts.TXT_CHOOSE_UPDATE_INDEX);

            LocalDate date = UiInputHelper.getValidDate();
            Resource resource = UiInputHelper.getValidResource();
            String vehicle = UiInputHelper.getValidVehicle(resource);
            Employee employee1 = UiInputHelper.getValidEmployee(AppTexts.TXT_INPUT_EMPLOYEE1);
            Employee employee2 = null;
            if (!resource.equals(Resource.CONTROLCENTER)) {
                employee2 = UiInputHelper.getValidEmployee(AppTexts.TXT_INPUT_EMPLOYEE2);
            }

            //b81eda8

            //Bearbeiten durch Ersetzen
//        Smartphone smartphone = new Smartphone(brand, model, memorySize, price);
//        smartphoneList.set(indexToUpdate, smartphone);

            //Bearbeiten über die Referenz
            DutyRosterEntry dutyToUpdate = duties.get(indexToUpdate);
            dutyToUpdate.setDate(date);
            dutyToUpdate.setResource(resource);
            dutyToUpdate.setVehicle(vehicle);
            dutyToUpdate.setEmployee1(employee1);
            dutyToUpdate.setEmployee2(employee2);


            duties.sort(new DateComparator());

        } else System.out.println(AppTexts.TXT_DUTY_ROSTER_IS_EMPTY);

        System.out.println("Duty updated.");

        saveDutiesAndEmployees();
    }

    private static void saveDutiesAndEmployees() {

        FileHandler.getInstance().writeDutiesToCsvFile(duties);

        FileHandler.getInstance().writeEmployeesToCsvFile(employees);

    }

    private static void printMainMenu() {
        System.out.printf(AppTexts.TEMPLATE_MAIN_MENU,
                AppCommands.CREATE, AppCommands.SHOW_TODAY_AND_LATER, AppCommands.SHOW_BEFORE_TODAY, AppCommands.UPDATE, AppCommands.DELETE, AppCommands.EXIT);
    }

    private static void printAppHeader() {
        System.out.printf(TEMPLATE_APP_HEADER, APP_NAME);
    }

    private static void initializeDuties() {

//        duties = TestData.generateTestDuties();

        duties = FileHandler.getInstance().readDutiesFromCsvFile();

        duties.sort(new DateComparator());

    }
    //endregion


}
