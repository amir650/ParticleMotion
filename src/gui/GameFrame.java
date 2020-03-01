package gui;

import engine.World;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    private final WorldPanel worldPanel;
    private final InfoPanel infoPanel;
    private final Timer gameTimer;

    private GameFrame() {
        this.worldPanel = new WorldPanel(new World());
        this.infoPanel = new InfoPanel(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Walk");
        setResizable(false);
        add(this.infoPanel, BorderLayout.NORTH);
        add(this.worldPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        this.gameTimer = new Timer(50, (ActionEvent e) -> {
            this.worldPanel.update();
            this.infoPanel.update();
        });
    }

    public static void initialize() {
        SwingUtilities.invokeLater(() -> {
            final GameFrame game = new GameFrame();
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
        return this.worldPanel.getWorld();
    }

}
