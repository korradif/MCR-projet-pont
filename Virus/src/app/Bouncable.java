/**
 * @name: Bouncable.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package app;

import render.Renderable;

import java.awt.*;

/**
 * @brief un objet pouvant rebondir
 */
public interface Bouncable {
    void draw();
    void move();
    Renderable getRenderer();
    Color getColor();
    Shape getShape();
}
