/**
 * @name: RenderableEmpty.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package render;

import app.Bouncable;

import java.awt.*;

/**
 * @brief afficheur de forme vide
 */
public class RenderableEmpty extends RenderableObject{
    private static final float STROKE_WIDTH = 2f;

    @Override
    public void display(Graphics2D g2d, Bouncable b) {
        super.display(g2d, b);
        BasicStroke bsck = new BasicStroke(STROKE_WIDTH);

        g2d.setStroke(bsck); // trait plein
        g2d.setPaint(b.getColor());
        g2d.draw(bsck.createStrokedShape(b.getShape()));
    }
}