/**
 * @name: BounceApp.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

/**
 * @brief l'application
 */
public class Main {
    private static final String APP_NAME = "VirusGame";

    /**
     * @brief point d'entree du programme
     * @param args
     */
    public static void main(String... args) {
        DisplayerManager.getInstance().launchLauncher();
    }
}
