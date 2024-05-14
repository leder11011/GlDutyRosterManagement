package org.leder11011.model;

/**
 * encapsulates the data structure for the office employees
 */
public class Employee {
    //region Constants
    public static final String DEFAULT_STRING_VALUE = "noValueSet";
    public static final int INDEX_RESOURCE = 1;
    public static final int DEFAULT_NUMBER_VALUE = -INDEX_RESOURCE;
    public static final String DELIMITER = ",";
    public static final String TXT_CSV_CAST_ERROR = "\nConversion of CSV-Line failed!\n";

    public static final int INDEX_EMPLOYEE_NAME = 0;

    public static final int INDEX_EMPLOYEE_CHRISTIANNAME = 1;


    //endregion

    //region Attributs
    String name;
    String christianName;
    //endregion

    //region Constructors
    public Employee() {
    }

    public Employee(String name, String christianName) {
        this.name = name;
        this.christianName = christianName;
    }

    public Employee(String csvLine){
        setPropertiesFromCsvLine(csvLine);
    }
    //endregion

    //region Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChristianName() {
        return christianName;
    }

    public void setChristianName(String christianName) {
        this.christianName = christianName;
    }

    private void setPropertiesFromCsvLine(String csvLine) {
        String[] properties = csvLine.split(DELIMITER);

//        Employee employee = null;


        try {
            //set Values with array properties and conversion
            name = properties[INDEX_EMPLOYEE_NAME];
            christianName = properties[INDEX_EMPLOYEE_CHRISTIANNAME];
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(TXT_CSV_CAST_ERROR);
        }

    }

    public String getPropertiesAsCsvLine() {
        return  name + DELIMITER + christianName + "\n";
    }

    @Override
    public String toString() {
        return (christianName + " " + name);
        //"Employee{" +
//                "name='" + name + '\'' +
//                ", christianName='" + christianName + '\'' +
//                "}";// + super.toString();
    }

    @Override
    public boolean equals(Object obj) {

        return (((Employee)obj).getName().equals(this.name) && ((Employee)obj).getChristianName().equals(this.christianName));

//        return super.equals(obj);
    }
//endregion


}
