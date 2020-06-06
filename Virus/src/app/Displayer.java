/**
 * @name: Displayer.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * @brief un afficheur de formes
 */
public interface Displayer {
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String s);
    void addKeyListener(KeyAdapter ka);
}
