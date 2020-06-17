/**
 * @name: BounceApp.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

import Bridge.Abstraction.IVirus;
import BusinessLogic.VirusLogic;
import factory.VirusFactory;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

import java.util.*;

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
