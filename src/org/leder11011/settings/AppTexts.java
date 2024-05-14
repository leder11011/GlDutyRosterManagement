package org.leder11011.settings;

/**
 * Constant AppTexts for UiController and UiInputHelper classes.
 */
public class AppTexts {

    //region Constants
    public static final String APP_NAME = "Gl Duty Roster Management";
    public static final String TEMPLATE_APP_HEADER = """
            =============================
            = %s =
            =============================
            """;
    public static final String TEMPLATE_MAIN_MENU = """
            
            ( %s ) Create
            ( %s ) Display from today and later
            ( %s ) Display before today
            ( %s ) Edit
            ( %s ) Delete
            ===================================
            ( %s ) Exit
            """;
    public static final String TXT_INVALID_CHOICE = "\nIllegal choice";
    public static final String TXT_EXIT_APP = "\nProgram exits...";
    public static final String TEMPLATE_DUTY_LIST_HEADER = "\n%-10s %-20s %-20s %20s %20s %20s\n\n";
    public static final String TEMPLATE_DUTY_LIST_ENTRY = "%-10s %-20s %-20s %20s %20s %20s\n";
    public static final String COLUMN_INDEX = "ID";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_RESOURCE = "Duty";
    public static final String COLUMN_VEHICLE = "Position";
    public static final String COLUMN_EMPLOYEE1 = "On-duty #1";

    public static final String COLUMN_EMPLOYEE2 = "On-duty #2";

    public static final String TXT_DUTY_LIST = "\nList of duties:";
    public static final String TXT_DUTY_LIST_TODAY_AND_LATER = "\nList of duties (from today on):";
    public static final String TXT_DUTY_LIST_BEFORE_TODAY = "\nList of duties (before today):";
    public static final String TEMPLATE_SELECTION_INPUT = "[%s] %s\n";
    public static final String TXT_CHOOSE_INDEX_TO_DELETE = "\nChoose an entry to delete:";
    public static final String TXT_CHOOSE_UPDATE_INDEX = "\nChoose an entry to edit:";
    public static final String TXT_INPUT_VEHICLE = "\nPosition:";
    public static final String TXT_INPUT_RESOURCE = "\nDuty:";
    public static final String TXT_DELETE_CONFIRMATION = "\nDo you really want to delete an entry?";
    public static final String TXT_DELETION_CANCELED = "Delete cancelled...";
    public static final String TXT_DELETION_SUCCESS = "\nEntry was deleted!";
    public static final String TXT_INPUT_DATE = "\nDate (yyyy-mm-dd):";
    public static final String TXT_INPUT_EMPLOYEE1 = "\nOn-duty #1:";
    public static final String TXT_INPUT_EMPLOYEE2 = "\nOn-duty #2:";

    public static final String TXT_FILE_NOT_FOUND = "\nFile not found!";
    //region Konstanten
    public static final String TXT_CONFIRMATION_SAVE = "\nDo you want to save?";
    public static final String TXT_WRONG_DATE_FORMAT = "Wrong date format!";
    public static final String EMPTY_STRING = "";
    //region Constants
    public static final String TXT_DUTY_ROSTER_IS_EMPTY = "\nDuty Roster is empty!\n";

    //endregion

    //region Attributs
    //endregion

    //region Constructors
    private AppTexts() {
    }
    //endregion

    //region Methods
    //endregion


}
