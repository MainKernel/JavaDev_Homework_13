import entity.ClientEntity;
import prefs.DatabasePrefs;
import prefs.FlyWayPrefs;
import service.ClientCrudService;
import service.PlanetCrudService;
import utils.FlywayUtils;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, String> envVariables = System.getenv();
        System.out.println(envVariables.get("LANG"));
    }
}
