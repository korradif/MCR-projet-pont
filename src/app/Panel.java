/**
 * @name: Panel.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

import javax.swing.*;
import java.awt.*;

/**
 * @brief panneau d'affichage
 */
public class Panel extends JPanel {
    /**
     * For Serialisation
     */
    private static final long serialVersionUID = 1L;

    private static final Color WHITE = Color.WHITE;
    private final Dimension PREFERRED_SIZE;

    /**
     * @brief constructeur
     * @param width largeur du panneau
     * @param height hauteur du panneau
     */
    public Panel(int width, int height){
        assert width > 0 && height > 0;
        this.PREFERRED_SIZE = new Dimension(width, height);
        setBackground(WHITE);
        setPreferredSize(this.PREFERRED_SIZE);
    }
}
