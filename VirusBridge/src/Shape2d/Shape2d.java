package Shape2d;

import java.awt.*;

/**
 * @brief la classe des formes en deux dimensions
 */
public abstract class Shape2d {
    private int _x;
    private int _y;
    private int _speed;
    private final Color _COLOR;
    private int _size;

    protected Shape2d(int x, int y,int size, int speed, Color color) {
        _x = x;
        _y = y;
        _speed = speed;
        _COLOR = color;
        _size = size;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public int get_size() {
        return _size;
    }

    public int get_speed() {
        return _speed;
    }

    public Color get_COLOR() {
        return _COLOR;
    }

    public void set_x(int x) {
        this._x = x;
    }

    public void set_y(int y) {
        this._y = y;
    }

    public void set_size(int size) {
        this._size = size;
    }

    public void set_speed(int speed) {
        this._speed = speed;
    }
}