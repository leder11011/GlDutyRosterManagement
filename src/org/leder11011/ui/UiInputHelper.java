package org.leder11011.ui;

import de.rhistel.logic.ConsoleReader;
import org.leder11011.model.Employee;
import org.leder11011.model.Resource;
import org.leder11011.settings.AppTexts;

import java.time.LocalDate;

/**
 * User Inputs via ConsoleReader for class UiController.
 */
public class UiInputHelper {
    private static final int INDEX_CHRISTIAN_NAME = 1;
    private static final int INDEX_NAME = 0;


    //region Konstanten
    //endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden
    static LocalDate getValidDate() {
        //Preis einlesen
        System.out.println(AppTexts.TXT_INPUT_DATE);

        boolean continueLoop = true;

        LocalDate date = null;

        String inputDate = AppTexts.EMPTY_STRING;

        do {
            inputDate = ConsoleReader.in.readMandatoryString();

            try {
                date = LocalDate.parse(inputDate);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(AppTexts.TXT_WRONG_DATE_FORMAT);

                continue;
            }

            continueLoop = false;

        } while (continueLoop);


        return date;
    }

    static Employee getValidEmployee(String employeeNumber) {
        //Employee
        Employee employee=null;



        boolean continueLoop=true;

        do {
            System.out.println(employeeNumber);
            System.out.println("Employees: " + UiController.employees);
            System.out.println("Christian Name: ");
            String inputEmployeeChristianName = ConsoleReader.in.readMandatoryString();


            System.out.println("Name: ");
            String inputEmployeeName = ConsoleReader.in.readMandatoryString();


            employee = new Employee(inputEmployeeName, inputEmployeeChristianName);

            //DEBUG:
            System.out.println("Employee: " + employee);



            if (!UiController.employees.contains(employee)){
                System.out.println("...is not a valid employee!");
                continue;
            } else continueLoop = false;
        } while (continueLoop);


        return employee;
    }

    static Employee getEmployee(String employeeNumber) {
        //Employee
        Employee employee=null;
        System.out.println(employeeNumber);
        System.out.println("Employees: " + UiController.employees);


        boolean continueLoop=true;

        do {
            System.out.println("Christian Name (possibly empty): ");
            String inputEmployeeChristianName = ConsoleReader.in.readString();


            System.out.println("Name (possibly empty): ");
            String inputEmployeeName = ConsoleReader.in.readString();


            if (!(inputEmployeeName.equals("") && inputEmployeeChristianName.equals("")))
                employee = new Employee(inputEmployeeName, inputEmployeeChristianName);

            //DEBUG:
            System.out.println("Employee: " + employee);



            if (!(UiController.employees.contains(employee) || employee==null)){
                continue;
            } else continueLoop = false;
        } while (continueLoop);


        return employee;
    }


    static String getValidVehicle(Resource resource) {
        //Vehicle
        System.out.println(AppTexts.TXT_INPUT_VEHICLE);
        for (int i = 0; i < resource.getVehicles().length; i++) {
            System.out.printf(AppTexts.TEMPLATE_SELECTION_INPUT, i, resource.getVehicles()[i]);
        }

        int modelIndex;
        do {
            modelIndex = ConsoleReader.in.readPositivInt();
        } while (modelIndex >= resource.getVehicles().length);

        return resource.getVehicles()[modelIndex];
    }


    static int getValidDutiesListIndex(String message) {
        int indexToDelete;
        do {
            System.out.println(message);
            indexToDelete = ConsoleReader.in.readPositivInt();
        } while (indexToDelete >= UiController.duties.size());
        return indexToDelete;
    }

    public static Resource getValidResource() {

        System.out.println(AppTexts.TXT_INPUT_RESOURCE);
        for (int i = 0; i < Resource.values().length; i++) {
            System.out.printf(AppTexts.TEMPLATE_SELECTION_INPUT, i, Resource.values()[i]);
        }

        int resourceIndex;
        do {
            resourceIndex = ConsoleReader.in.readPositivInt();
        } while (resourceIndex >= Resource.values().length);

        Resource resource = Resource.values()[resourceIndex];
        return resource;
    }
    //endregion
}
