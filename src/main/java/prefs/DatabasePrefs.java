package prefs;

import utils.AppPropertiesUtil;

public class DatabasePrefs {
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";

    private static final AppPropertiesUtil propertiesUtil = AppPropertiesUtil.getInstance();

    private DatabasePrefs() {
        throw new UnsupportedOperationException();
    }

    public static String getUrl() {
        return propertiesUtil.getPref(URL);
    }

    public static String getUser() {
        return propertiesUtil.getPref(USER);
    }

    public static String getPassword() {
        return propertiesUtil.getPref(PASSWORD);
    }
}
