package com.agenda.controller;

import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class ThemeManager {
    private static final Preferences prefs = Preferences.userNodeForPackage(ThemeManager.class);
    private static final String THEME_KEY = "user_theme";
    private static List<Scene> sceneManager = new ArrayList<Scene>();

    public static String getSavedTheme() {
        return prefs.get(THEME_KEY, "Light");
    }

    public static void saveTheme(String theme) {
        prefs.put(THEME_KEY, theme);
    }

    public static String getThemePath() {
        String theme = getSavedTheme();
        return theme.equals("Dark") ? "/com/agenda/css/dark-theme.css" : "/com/agenda/css/light-theme.css";
    }

    public static void addSceneToManager(Scene scene) {
        sceneManager.add(scene);
    }

    public static void applyThemeInAllScenes() {
        for(int i = 0; i < sceneManager.toArray().length; i++) {
            applyTheme(sceneManager.get(i));
        }
    }

    public static void applyTheme(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(ThemeManager.class.getResource(ThemeManager.getThemePath()).toExternalForm());
    }
}
