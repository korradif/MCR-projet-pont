package Bridge.Abstraction;

import Bridge.Implementation.Behaviour.*;
import jdk.jshell.spi.ExecutionControl;
import render.Renderable;
import render.RenderableFull;

import java.awt.*;
import java.awt.geom.Rectangle2D;
public class VirusT extends Virus {
    private static final Renderable R_FULL = new RenderableFull();
    /**
     * @brief constructeur
     * @param color la couleur
     */
    public VirusT(Color color) { super(color, R_FULL); }

    @Override
    public Shape getShape() {
        return new Rectangle.Double(getX(), getY(), getSize(), getSize());
    }
}