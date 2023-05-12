package JavaPong;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import SpendingDraft.Game.Game;

public class Main implements Game {

    private MyPongPanel panel;
    private int highScore = 0;

    public Main() {
        panel = new MyPongPanel();
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.play();
    }

    @Override
    public String getGameName() {
        return "JavaPong";
    }

    @Override
    public void play() {
        JFrame frame = new JFrame("JAVA PONG");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(panel);

        frame.setSize(500, 500);
        frame.setVisible(true);

        try {
            panel.play(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getScore() {
        return Integer.toString(panel.score);
    }

    @Override
    public void writeHighScore(File f) {
        try (FileWriter writer = new FileWriter(f, true)) {
            writer.write(getGameName() + ": " + highScore + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
        }
    }
}
