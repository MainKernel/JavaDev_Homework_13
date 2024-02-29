package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppPropertiesUtil {

    private static final AppPropertiesUtil INSTANCE;

    private static Map<String, Object> preferences = new HashMap<>();

    static {
        INSTANCE = new AppPropertiesUtil();
        AppPropertiesUtil.readPrefsFromFile();
    }

    private AppPropertiesUtil() {
    }

    private static void readPrefsFromFile() {
        Gson gson = new Gson();
        TypeToken<Map<String, Object>> mapTypeToken = new TypeToken<>() {
        };
        // resources/pref.json doesn't work on linux so need provide absolute path
        try (FileReader reader = new FileReader("/home/mightyloot/IdeaProjects/JavaDev_homework_12/src/main/resources/prefs.json")) {
            preferences = gson.fromJson(reader, mapTypeToken);
        } catch (IOException e) {
            throw new RuntimeException("File not found critical error");
        }
    }

    public static AppPropertiesUtil getInstance() {
        return INSTANCE;
    }

    public String getPref(String pref) throws NullPointerException {
        return preferences.get(pref).toString();
    }
}
