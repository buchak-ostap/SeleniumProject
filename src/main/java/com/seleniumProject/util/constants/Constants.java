package com.seleniumProject.util.constants;

public class Constants {

    //TimeOut constants
    private static final long timeoutMultiplier = 3;
    public static final long TIMEOUT_S = 500 * timeoutMultiplier;
    public static final long TIMEOUT_M = 1000 * timeoutMultiplier;
    public static final long TIMEOUT_L = 2000 * timeoutMultiplier;

    //Contacts page constants
    public static final int TEN_USERS = 10;
    public static final int TWENTY_FIVE_USERS = 25;
    public static final int FIFTY_USERS = 50;
    public static final String SEARCH_USER = "Viktor Chekh";

    //Calendar page constants
    public static final String TIME_LOG_DESCRIPTION = "Work on PHN projects, test finished tickets, create automation tests";
    public static final String REQUEST_LOG_DESCRIPTION = "Going to vacation";

    //Page titles
    public static final String HOME_PAGE_TITLE = "Home";
    public static final String CONTACTS_PAGE_TITLE = "Contacts";
    public static final String CONTACT_PAGE_TITLE = "Contact";

    //Invalid Login data
    public static final String INVALID_EMAIL = "test@sombrainc.com";
    public static final String INVALID_PASSWORD = "password";
}
