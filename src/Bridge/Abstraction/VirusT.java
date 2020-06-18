package Bridge.Abstraction;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

import render.Renderable;
import render.RenderableFull;
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