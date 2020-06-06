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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * @brief l'application
 */
public class BounceApp {
    private static final String APP_NAME = "VirusGame";
    private static final int FRAME_RATE = 1000/60;
    private static final int INITIAL_DELAY = 0;
    private static final int MINIMAL_VIRUS = 1;

    private final VirusFactory VIRUS_FACTORY;

    private final VirusLogic virusLogic;

    private Collection<Bouncable> bouncers; // non final
    private Timer timer;

    /**
     * @brief constructeur
     */
    public BounceApp() {
        Displayer displayer = DisplayerManager.getInstance();
        displayer.setTitle(APP_NAME);
        this.VIRUS_FACTORY = new VirusFactory();
        this.bouncers =  Collections.synchronizedList(new LinkedList<>());
        this.virusLogic = new VirusLogic();
        // notre application possede les interactions
        displayer.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()){
                    case 'e': // effacer l'affichage
                        bouncers = Collections.synchronizedList(new LinkedList<>());
                        break;
                    case 't': // generer 10 cercles et 10 carres possedant une bordure
                        timer.cancel();
                        addVirusT();
                        loop();
                        break;
                    case 'g': // generer 10 cercles et 10 pleins
                        timer.cancel();
                        addVirusG();
                        loop();
                        break;
                    case ' ': // generer 10 cercles et 10 carres possedant une bordure
                        System.out.println("space pressed");
                        timer.cancel();
                        for(Bouncable v : bouncers){
                            virusLogic.mutateVirus((IVirus)v);
                        }
                        loop();
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * @brief point d'entree du programme
     * @param args
     */
    public static void main(String ... args) {
        new BounceApp().loop();
    }

    /**
     * @brief gestion de l'animation des formes
     */
    public void loop() {
        Displayer displayer = DisplayerManager.getInstance();
        this.timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // nombre minimale de virus maintenu
                if(bouncers.size() < MINIMAL_VIRUS){
                    bouncers =  Collections.synchronizedList(new LinkedList<>());
                    addVirusT();
                }

                // animation
                displayer.getGraphics();
                synchronized (bouncers) {
                    for (Bouncable b : bouncers) {
                        b.move();
                        b.draw();
                    }
                }
                displayer.repaint();
            }
        }, INITIAL_DELAY, FRAME_RATE);
    }

    /**
     * @brief ajoutes des formes a l'application
     */
    private void addVirus(IVirus virus){
        bouncers.add(virus);

    }

    /**
     * @brief ajoutes des formes vides a l'application
     */
    private void addVirusG() {
        synchronized (bouncers) {
            addVirus(VIRUS_FACTORY.createVirusG());
        }
    }

    /**
     * @brief ajoutes des formes pleines a l'application
     */
    private void addVirusT() {
        synchronized (bouncers) {
        addVirus(VIRUS_FACTORY.createVirusT());
        }
    }
}
