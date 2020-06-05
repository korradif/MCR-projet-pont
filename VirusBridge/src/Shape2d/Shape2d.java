package Shape2d;

import java.awt.*;

/**
 * @brief la classe des formes en deux dimensions
 */
public abstract class Shape2d {
    private int _x;
    private int _y;
    private int _speed;
    private final Color COLOR;

    protected Shape2d(int x, int y, int speed, Color color) {
        _x = x;
        _y = y;
        _speed = speed;
        COLOR = color;
    }

}