/**
 * @name: RenderableFull.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti
 * @date: 06.06.2020
 */
package render;

import app.Bouncable;

import java.awt.*;

/**
 * @brief afficheur de forme pleines
 */
public class RenderableFull extends RenderableObject {
    @Override
    public void display(Graphics2D g2d, Bouncable b) {
        super.display(g2d, b);
        g2d.fill(b.getShape());
    }
}
