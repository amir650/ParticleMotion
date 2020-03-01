package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class InfoPanel extends JPanel {

    private final GameFrame game;

    InfoPanel(final GameFrame game) {
        this.game = game;
        final String[] petStrings = {"Slow", "Normal", "Fast", "Ultra"};
        final JComboBox<String> speedPickList = new JComboBox<>(petStrings);
        speedPickList.setSelectedIndex(0);
        speedPickList.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String selectedSpeed = (String)cb.getSelectedItem();
            int delay;
            switch(Objects.requireNonNull(selectedSpeed)) {
                case "Slow" :
                    delay = 50;
                    break;
                case "Normal" :
                    delay = 25;
                    break;
                case "Fast" :
                    delay = 10;
                    break;
                case "Ultra" :
                    delay = 0;
                    break;
                default :
                    throw new RuntimeException("no!");

            }
            this.game.setDelay(delay);
        });
        this.add(BorderLayout.WEST, speedPickList);

        final JToggleButton toggleButton = new JToggleButton("Stop", new ImageIcon("pause.png"));
        ItemListener itemListener = itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                game.stop();
                toggleButton.setText("Start");
                toggleButton.setIcon(new ImageIcon("play.png"));
            } else {
                game.start();
                toggleButton.setIcon(new ImageIcon("pause.png"));
                toggleButton.setText("Stop");
            }
        };
        toggleButton.addItemListener(itemListener);
        this.add(BorderLayout.EAST, toggleButton);
        this.setPreferredSize(new Dimension(game.getWidth(), 45));
        setBackground(Color.WHITE);
    }

    void update() {
        repaint();
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.BLUE);
        g.drawString("gen : " + this.game.getGameWorld().getWorldAge(), 550, 25);
    }
}
