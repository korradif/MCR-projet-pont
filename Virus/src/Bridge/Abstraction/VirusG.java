package Bridge.Abstraction;

import render.Renderable;
import render.RenderableFull;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class VirusG extends Virus {
    private static final Renderable R_FULL = new RenderableFull();
    /**
     * @brief constructeur
     * @param color la couleur de la forme
     */
    public VirusG(Color color) { super(color, R_FULL); }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }


}
