package org.leder11011.logic;

import org.leder11011.model.DutyRosterEntry;
import org.leder11011.model.Employee;
import org.leder11011.settings.AppTexts;
import org.leder11011.ui.UiController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for file input and output.
 */
public class FileHandler {

    //region Konstanten
    //endregion

    //region Attribute
    private static FileHandler instance;
    //endregion

    //region Konstruktoren
    private FileHandler() {
    }
    //endregion

    //region Methoden
    public static synchronized FileHandler getInstance() {
        if (instance == null) instance = new FileHandler();
        return instance;
    }

    public synchronized void writeDutiesToCsvFile(List<DutyRosterEntry> dutiesList) {
        //Dateiobjekt erzeugen
        File csvFile = new File(UiController.CSV_FILE_PATH_DUTIES);


        //Schreiben
        try (
//                FileOutputStream fos = new FileOutputStream(csvFile); //Brücke zur Datei, schreibt Bytes
//                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8); //Schreibt String mit Zeichensatz
//                BufferedWriter out = new BufferedWriter(osw); // Schreibt performant mit einem Zwischenspeicher
                FileWriter out = new FileWriter(csvFile, StandardCharsets.UTF_8); //Einfache Möglichkeit ohne die 3 oberen Objekte
        ) {

            for (DutyRosterEntry duty : dutiesList) {
                out.write(duty.getPropertiesAsCsvLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        } finally {
            //Code der abschließend ausgeführt werden soll
        }
    }

    public synchronized List<DutyRosterEntry> readDutiesFromCsvFile() {

        //Leere Liste erzeugen
        List<DutyRosterEntry> dutiesList = new ArrayList<>();

        //Datei-Objekt erzeugen
        File csvFile = new File(UiController.CSV_FILE_PATH_DUTIES);

        //Lesen
        try (
//                FileInputStream fis = new FileInputStream(csvFile);
//                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//                BufferedReader in = new BufferedReader(isr);
                FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8); //Einfache Möglichkeit zum Lesen
                BufferedReader in = new BufferedReader(reader); //Erweitern, sodass Strings gelesen werden können
        ) {

            boolean eof = false;
            while (!eof) {

                String csvLine = in.readLine();

                if (csvLine != null) {
                    DutyRosterEntry duty = new DutyRosterEntry(csvLine);
                    dutiesList.add(duty);
                    continue; //Rest überspringen und nächsten Schleifendurchlauf beginnen
                }

                eof = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        }

        //Liste zurückgeben
        return dutiesList;
    }

    public synchronized void writeEmployeesToCsvFile(List<Employee> employeeList) {
        //Dateiobjekt erzeugen
        File csvFile = new File(UiController.CSV_FILE_PATH_EMPLOYEES);


        //Schreiben
        try (
//                FileOutputStream fos = new FileOutputStream(csvFile); //Brücke zur Datei, schreibt Bytes
//                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8); //Schreibt String mit Zeichensatz
//                BufferedWriter out = new BufferedWriter(osw); // Schreibt performant mit einem Zwischenspeicher
                FileWriter out = new FileWriter(csvFile, StandardCharsets.UTF_8); //Einfache Möglichkeit ohne die 3 oberen Objekte
        ) {

            for (Employee employee : employeeList) {
                out.write(employee.getPropertiesAsCsvLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        } finally {
            //Code der abschließend ausgeführt werden soll
        }
    }

    public synchronized List<Employee> readEmployeesFromCsvFile() {

        //Leere Liste erzeugen
        List<Employee> employeesList = new ArrayList<>();

        //Datei-Objekt erzeugen
        File csvFile = new File(UiController.CSV_FILE_PATH_EMPLOYEES);

        //Lesen
        try (
//                FileInputStream fis = new FileInputStream(csvFile);
//                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//                BufferedReader in = new BufferedReader(isr);
                FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8); //Einfache Möglichkeit zum Lesen
                BufferedReader in = new BufferedReader(reader); //Erweitern, sodass Strings gelesen werden können
        ) {

            boolean eof = false;
            while (!eof) {

                String csvLine = in.readLine();

                if (csvLine != null) {
                    Employee employee = new Employee(csvLine);
                    employeesList.add(employee);
                    continue; //Rest überspringen und nächsten Schleifendurchlauf beginnen
                }

                eof = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        }

        //Liste zurückgeben
        return employeesList;
    }


    //endregion
}
