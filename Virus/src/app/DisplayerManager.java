/**
 * @name: DisplayManager.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * @brief classe donnant acces au singleton de l'affichage
 */
public class DisplayerManager implements Displayer {
    private static final int INIT_WIDTH = 600;
    private static final int INIT_HEIGHT = 600;

    private static Displayer instance; // le singleton

    private final JFrame FRAME;
    private final Panel PANEL;

    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    /**
     * @brief le singleton
     * @return l'instance du singleton
     */
    public static Displayer getInstance()
    {
        if (Objects.isNull(instance)){ // == null
            instance = new DisplayerManager();
        }

        return instance;
    }

    /**
     * @brief constructeur prive du singleton
     */
    private DisplayerManager() {
        this.PANEL = new Panel(INIT_WIDTH, INIT_HEIGHT);
        this.FRAME = new JFrame();
        this.FRAME.setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
        this.FRAME.getContentPane().add(this.PANEL);
        this.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.FRAME.setSize(INIT_WIDTH, INIT_HEIGHT);
        this.FRAME.setVisible(true);

        this.bufferedImage = (BufferedImage) this.PANEL.createImage(getWidth(), getHeight());
        this.g2d = (Graphics2D) bufferedImage.getGraphics();
    }

    @Override
    public int getWidth() {
        return this.PANEL.getWidth();
    }

    @Override
    public int getHeight() {
        return this.PANEL.getHeight();
    }

    @Override
    public Graphics2D getGraphics() { return this.g2d; }

    @Override
    public void repaint() {
        this.PANEL.getGraphics().drawImage(bufferedImage, 0, 0, null);
        this.bufferedImage = (BufferedImage) this.PANEL.createImage(getWidth(), getHeight());
        this.g2d = (Graphics2D) bufferedImage.getGraphics();
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
}
