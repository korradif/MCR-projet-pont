/**
 * @name: Renderable.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package render;

import app.Bouncable;

import java.awt.*;

/**
 * @brief interface de l'affichage
 */
public interface Renderable {
    void display(Graphics2D g, Bouncable b);
}
