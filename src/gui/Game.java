package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Game extends JFrame {

    private final World gameWorld;
    private final InfoPanel infoPanel;
    private final Timer gameTimer;

    public Game() {
        this.gameWorld = new World();
        this.infoPanel = new InfoPanel(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Walk");
        setResizable(false);
        add(this.infoPanel, BorderLayout.NORTH);
        add(this.gameWorld, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        this.gameTimer = new Timer(50, (ActionEvent e) -> {
            this.gameWorld.update();
            this.infoPanel.update();
        });
    }

    public static void initialize() {
        SwingUtilities.invokeLater(() -> {
            final Game game = new Game();
            game.start();
        });
    }

    void setDelay(int delay) {
        this.gameTimer.setDelay(delay);
    }

    void start() {
        this.gameTimer.start();
    }

    void stop() {
        this.gameTimer.stop();
    }

    World getGameWorld() {
        return this.gameWorld;
    }

}
