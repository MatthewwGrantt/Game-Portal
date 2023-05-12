package JavaPong;

import java.awt.Color;
import java.awt.*;

public class Paddle {

    int x; // Class Scope
    int y;
    int length = 10;
    int width = 100;

    public Paddle(int x, int y) { // Local Scope
        // 1
        this.x = x;
        //2
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
       g.fillRect(this.x,this.y,this.length,this.width);

    }

}
