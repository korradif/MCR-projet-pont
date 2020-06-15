package Bridge.Abstraction;

import Bridge.Implementation.Behaviour.*;
import app.Bouncable;
import app.Displayer;
import app.DisplayerManager;
import render.Renderable;

import java.awt.*;
import java.util.Random;

public abstract class Virus implements IVirus {
    private static final int MIN_SIZE = 60;
    private static final int MAX_SIZE = 200;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 4;
    private static final Random RAND = new Random();

    private final Color COLOR;
    private final Renderable RENDERABLE;

    private IBehaviour behaviourImplementation;
    boolean isDead;
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int size;

    public Virus(Color color, Renderable renderable) {
        Displayer displayer = DisplayerManager.getInstance();
        this.size = MIN_SIZE + RAND.nextInt(MAX_SIZE - MIN_SIZE);
        this.vx = initSpeed();
        this.vy = initSpeed();
        this.behaviourImplementation = new BehaviourLvlOne(this);
        assert size > 0; // la taille est positive
        this.x = MAX_SIZE + RAND.nextInt(displayer.getWidth() - MAX_SIZE);
        this.y = MAX_SIZE + RAND.nextInt(displayer.getHeight() - MAX_SIZE);
        this.COLOR = color;
        this.isDead = false;
        this.RENDERABLE = renderable;
    }

    /**
     * @brief factorisation
     * @return une vitesse entre MIN_SPEED et MAX_SPEED - 1
     */
    private static int initSpeed() {
        return MIN_SPEED + new Random().nextInt(Math.abs(MAX_SPEED - MIN_SPEED));
    }

    @Override
    public void setBehaviour(IBehaviour behaviour) {
        behaviourImplementation = behaviour;
    }

    @Override
    public IBehaviour getBehaviour() {
        return behaviourImplementation;
    }

    @Override
    public eBehaviourType getBehaviourType() {
        return eBehaviourType.getBehaviourTypeFormInstance(this);
    }

    @Override
    public void launchBehaviour() {
        this.behaviourImplementation.move();
        this.behaviourImplementation.LaunchCapacities();
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getVX() {
        return this.vx;
    }

    @Override
    public void setVX(int vx) {
        this.vx = vx;
    }

    @Override
    public int getVY() {
        return this.vy;
    }

    @Override
    public void setVY(int vy) {
        this.vy = vy;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Renderable getRenderer() {
        return this.RENDERABLE;
    }

    @Override
    public Color getColor() {
        return this.COLOR;
    }

    @Override
    public void kill() {
        this.isDead = true;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void draw() {
        getRenderer().display(DisplayerManager.getInstance().getGraphics(), this);
    }

    @Override
    public void move() {
        launchBehaviour();
    }

    @Override
    public void reactToMouseEvent(double x, double y) {
        // TODO Ici on peut appeler ce qu'on veut en fonction de la position.
        if (getShape().contains(x, y)) {
            System.out.println("Touché !");
        } else {
            System.out.println("Coup dans l'eau !");
        }

    }
}
