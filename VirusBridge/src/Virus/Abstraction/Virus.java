package Virus.Abstraction;

import Shape2d.Shape2d;

public class Virus implements  IVirus {
  Shape2d shape2d;

    @Override
    public int get_x() {
        return shape2d.get_x();
    }

    @Override
    public void set_x(int x) {
        shape2d.set_x(x);
    }

    @Override
    public int get_y() {
        return shape2d.get_y();
    }

    @Override
    public void set_y(int y) {
        shape2d.set_y(y);
    }

    @Override
    public int get_speed() {
        return  shape2d.get_speed();
    }

    @Override
    public void set_speed(int speed) {
        shape2d.set_speed(speed);
    }

    @Override
    public int get_size() {
        return shape2d.get_size();
    }

    @Override
    public void set_size(int size) {
        shape2d.set_size(size);
    }
}
