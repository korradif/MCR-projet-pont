/**
 * @name: RenderableObject.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package render;

import app.Bouncable;

import java.awt.*;

/**
 * @brief affichage de formes
 */
public abstract class RenderableObject implements Renderable {
    @Override
    public  void display(Graphics2D g2d, Bouncable b){
        g2d.setPaint(b.getColor());
    }
}
