package Virus.Abstraction;

import java.awt.*;

public interface IVirus {
    int get_x();
    void set_x(int x) ;

    int get_y();
    void set_y(int y);

    int get_speed();
    void set_speed(int speed);

    int get_size();
    void set_size(int size);


}
