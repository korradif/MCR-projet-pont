/**
 * @name: DisplayManager.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package app;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Bridge.Abstraction.IVirus;
import BusinessLogic.VirusLogic;
import factory.VirusFactory;

/**
 * @brief classe donnant acces au singleton de l'affichage
 */
public class DisplayerManager implements Displayer {
    private static final int INIT_WIDTH = 600;
    private static final int INIT_HEIGHT = 600;
    private static final int FRAME_RATE = 1000 / 60;
    private static final int INITIAL_DELAY = 0;
    private static final int MINIMAL_VIRUS = 0;

    private static Displayer instance; // le singleton
    private final VirusFactory VIRUS_FACTORY;
    private final VirusLogic virusLogic;
    private Collection<IVirus> viruses;
    private Timer timer;

    private final JFrame FRAME;
    private final Panel launcher;

    private BufferedImage bufferedImage;
    private Graphics2D g2d;
    private boolean isGameRunning;

    /**
     * @brief le singleton
     * @return l'instance du singleton
     */
    public static Displayer getInstance() {
        if (Objects.isNull(instance)) { // == null
            instance = new DisplayerManager();
        }

        return instance;
    }

    /**
     * @brief constructeur prive du singleton
     */
    private DisplayerManager() {
        launcher = new Panel(INIT_WIDTH, INIT_HEIGHT);
        FRAME = new JFrame();
        FRAME.setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));

        VIRUS_FACTORY = new VirusFactory();
        viruses = Collections.synchronizedList(new LinkedList<>());
        virusLogic = new VirusLogic();

    }

    public void startGame(int nbInitialViruses) {
        isGameRunning = true;
        for (int i = 0; i < nbInitialViruses; ++i) {
            addVirusG();
            addVirusT();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // nombre minimale de virus maintenu
                if (viruses.size() < MINIMAL_VIRUS) {
                    viruses = Collections.synchronizedList(new LinkedList<>());
                    addVirusT();
                }

                // animation
                getGraphics();

                synchronized (viruses) {
                    viruses.removeIf(e -> e.isDead());
                    if (isGameRunning && viruses.isEmpty()) {
                        timer.cancel();
                        isGameRunning = false;
                        displayLauncher();
                    }

                }

                synchronized (viruses) {
                    for (Bouncable b : viruses) {
                        {
                            b.move();
                            b.draw();
                        }
                    }
                }
                repaint();
            }
        }, INITIAL_DELAY, FRAME_RATE);
    }

    public void launchLauncher() {
        displayLauncher();
        FRAME.getContentPane().add(launcher);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setSize(INIT_WIDTH, INIT_HEIGHT);
        FRAME.setVisible(true);
        bufferedImage = (BufferedImage) this.launcher.createImage(getWidth(), getHeight());
        g2d = (Graphics2D) bufferedImage.getGraphics();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'e': // effacer l'affichage
                        viruses = Collections.synchronizedList(new LinkedList<>());
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                for (IVirus v : viruses) {
                    virusLogic.reactToMouseEvent(e.getPoint().getX(), e.getPoint().getY(), v);
                }
            }
        });
    }

    private void displayLauncher() {
        ButtonGroup g = new ButtonGroup();
        JRadioButton radioButtonEasy = new JRadioButton("Easy");
        JRadioButton radioButtonMedium = new JRadioButton("Medium");
        JRadioButton radioButtonHard = new JRadioButton("Hard");
        g.add(radioButtonEasy);
        g.add(radioButtonMedium);
        g.add(radioButtonHard);
        radioButtonEasy.setSelected(true);
        launcher.add(radioButtonEasy);
        launcher.add(radioButtonMedium);
        launcher.add(radioButtonHard);
        JButton buttonStart = new JButton("Start");

        var howTo = new JLabel(
                "<html>WELCOME<br>In order to win the game, you must click on the viruses until their all disappear.<br>Have Fun ! </html>");
        launcher.add(howTo);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.remove(radioButtonEasy);
                launcher.remove(radioButtonMedium);
                launcher.remove(radioButtonHard);
                launcher.remove(buttonStart);
                launcher.remove(howTo);

                if (radioButtonEasy.isSelected()) {
                    startGame(1);
                } else if (radioButtonMedium.isSelected()) {
                    startGame(20);
                } else if (radioButtonHard.isSelected()) {
                    startGame(30);
                }
            }
        });
        launcher.add(buttonStart);

        launcher.setVisible(true);
        launcher.revalidate();
        launcher.repaint();
    }

    @Override
    public int getWidth() {
        return FRAME.getContentPane().getWidth();
    }

    @Override
    public int getHeight() {
        return FRAME.getContentPane().getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return g2d;
    }

    @Override
    public void repaint() {
        // Image img = Toolkit.getDefaultToolkit().getImage("..\\res\\virus.jpg");
        FRAME.getContentPane().getGraphics().drawImage(bufferedImage, 0, 0, null);
        bufferedImage = (BufferedImage) FRAME.getContentPane().createImage(getWidth(), getHeight());
        g2d = (Graphics2D) bufferedImage.getGraphics();
    }

    @Override
    public void setTitle(String title) {
        this.FRAME.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        this.FRAME.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                ka.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyPressed(e);
                ka.keyReleased(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyPressed(e);
                ka.keyReleased(e);
            }
        });
    }

    @Override
    public void addMouseListener(MouseAdapter ma) {
        this.FRAME.addMouseListener(ma);
    }

    /**
     * @brief ajoutes des formes a l'application
     */
    private void addVirus(IVirus virus) {
        viruses.add(virus);

    }

    /**
     * @brief ajoutes des formes vides a l'application
     */
    private void addVirusG() {
        synchronized (viruses) {
            addVirus(VIRUS_FACTORY.createVirusG());
        }
    }

    /**
     * @brief ajoutes des formes pleines a l'application
     */
    private void addVirusT() {
        synchronized (viruses) {
            addVirus(VIRUS_FACTORY.createVirusT());
        }
    }
}
