package com.agenda.view;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class ThemeManager {
    private static String theme = "Light";
    private static List<Scene> sceneManager = new ArrayList<Scene>();

    public static void setTheme(String newTheme) {
        theme = newTheme;
    }

    public static String getThemePath() {
        return theme.equals("Dark") ? "/com/agenda/css/dark-theme.css" : "/com/agenda/css/light-theme.css";
    }

    public static void addSceneToManager(Scene scene) {
        sceneManager.add(scene);
    }

    public static void removeSceneToManager(Scene scene) {
        sceneManager.remove(scene);
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
