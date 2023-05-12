package JavaPong;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class MyPongPanel extends JPanel implements KeyListener {
    Paddle one;
    Paddle two;
    Ball b;
    int paddleSpeed = 29;
    int score;
    int highScore;
    boolean play = true;

    MyPongPanel() {
        one = new Paddle(40, 250);
        two = new Paddle(450, 250);
        b = new Ball(45);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            two.y -= paddleSpeed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            two.y += paddleSpeed;
        } else if (keyCode == KeyEvent.VK_W) {
            one.y -= paddleSpeed;
        } else if (keyCode == KeyEvent.VK_S) {
            one.y += paddleSpeed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void displayScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("High Score: " + highScore, getWidth() - 120, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        one.draw(g);
        two.draw(g);
        b.draw(g);

        displayScore(g);
    }

    public void play(Main m) throws InterruptedException {
        while (play) {
            b.x += b.dx;
            b.y += b.dy;

            if (b.x + b.diameter >= getWidth() || b.x < 0) {
                b.dx = -1 * b.dx;
            }

            if (b.y + b.diameter >= getHeight() || b.y < 0) {
                b.dy = -1 * b.dy;
            }
            boolean hitOne = (b.x <= one.x + one.length && b.y + b.diameter >= one.y && b.y <= one.y + one.width);
            boolean hitTwo = (b.x + b.diameter >= two.x && b.y + b.diameter >= two.y && b.y <= two.y + two.width);
            if (hitOne || hitTwo) {
                b.dx = -1 * b.dx;
                score++;
                m.updateHighScore(score);

            } else if (b.x + b.diameter >= getWidth() || b.x < 0){
                int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    score = 0;
                    b.x = 50;
                    b.y = 100;
                    b.dx = 3;
                    b.dy = 3;
                }
                    else {
                    System.out.println("High Score: " + score);
                    play = false; 
                }
            }
        
    

            repaint();

            Thread.sleep(10);
        }
    }
    
        } 

