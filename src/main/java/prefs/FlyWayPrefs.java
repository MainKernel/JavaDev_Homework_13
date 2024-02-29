package prefs;

import utils.AppPropertiesUtil;

public class FlyWayPrefs {
    private static final String LOCATION = "flyway.migration.location";
    private static final AppPropertiesUtil util = AppPropertiesUtil.getInstance();

    private FlyWayPrefs() {
        throw new UnsupportedOperationException();
    }

    public static String getLocation() {
        return util.getPref(LOCATION);
    }
}
