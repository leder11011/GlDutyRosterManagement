package org.leder11011.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * encapsulates an entry for the office duty management
 */
public class DutyRosterEntry {
    //region Constants
    public static final String DEFAULT_STRING_VALUE = "noValueSet";
    public static final int INDEX_RESOURCE = 1;
    public static final int DEFAULT_NUMBER_VALUE = -INDEX_RESOURCE;
    public static final String DELIMITER = ",";
    public static final int INDEX_DATE = 0;

    public static final int INDEX_VEHICLE = 2;
    public static final int INDEX_EMPLOYEE1_NAME = 3;
    public static final int INDEX_EMPLOYEE1_CHRISTIANNAME = 4;

    public static final int INDEX_EMPLOYEE2_NAME = 5;

    public static final int INDEX_EMPLOYEE2_CHRISTIANNAME = 6;

    public static final String TXT_CSV_CAST_ERROR = "\nConversion of CSV-Line failed!\n";

    //endregion

    //region Attributs
    private LocalDate date;
    private Resource resource;
    private String vehicle;
    private Employee employee1;
    private Employee employee2;
    //endregion

    //region Constructors
    public DutyRosterEntry() {
        date = null;
        resource = null;
        vehicle = DEFAULT_STRING_VALUE;
        employee1 = null;
        employee2 = null;

    }
    public DutyRosterEntry(LocalDate date, Resource resource, String vehicle, Employee employee1, Employee employee2){
        this.date = date;
        this.resource = resource;
        this.vehicle = vehicle;
        this.employee1 = employee1;
        this.employee2 = employee2;
    }

    public DutyRosterEntry(String csvLine) {
        setPropertiesFromCsvLine(csvLine);
    }


    //endregion

    //region Methods
    private void setPropertiesFromCsvLine(String csvLine) {
        String[] properties = csvLine.split(DELIMITER);

        try {
            //set Values with array properties and conversion
            date = LocalDate.parse(properties[INDEX_DATE]);
            resource = Resource.valueOf(properties[INDEX_RESOURCE]);
            vehicle = properties[INDEX_VEHICLE];
            employee1 = new Employee(properties[INDEX_EMPLOYEE1_NAME], properties[INDEX_EMPLOYEE1_CHRISTIANNAME]);

            boolean isempty = (properties[INDEX_EMPLOYEE2_NAME].equals("null") && properties[INDEX_EMPLOYEE2_CHRISTIANNAME].equals("null")
                    || properties[INDEX_EMPLOYEE2_NAME].equals(" ") && properties[INDEX_EMPLOYEE2_CHRISTIANNAME].equals(" "));

            if (isempty) {
                employee2 = new Employee(null, null);

            } else
                employee2 = new Employee(properties[INDEX_EMPLOYEE2_NAME], properties[INDEX_EMPLOYEE2_CHRISTIANNAME]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(TXT_CSV_CAST_ERROR);
        }

    }

    public String getPropertiesAsCsvLine() {

        String csvLine = null;

        if (employee2==null){
            csvLine = date + DELIMITER + resource + DELIMITER + vehicle + DELIMITER + employee1.name + DELIMITER + employee1.christianName + DELIMITER + " " + DELIMITER + " " + "\n";
        } else {
            csvLine = date + DELIMITER + resource + DELIMITER + vehicle + DELIMITER + employee1.name + DELIMITER + employee1.christianName + DELIMITER + employee2.name + DELIMITER + employee2.christianName + "\n";
        }

        return csvLine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    @Override
    public String toString() {
        return "DutyRosterEntry{" +
                "date=" + date +
                ", resource=" + resource +
                ", vehicle='" + vehicle + '\'' +
                ", employee1=" + employee1 +
                ", employee2=" + employee2 +
                "}"; // + super.toString();
    }

    //endregion


}
