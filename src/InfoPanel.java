import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class InfoPanel extends JPanel {

    private final World gameWorld;

    InfoPanel(final World gameWorld) {
        this.gameWorld = gameWorld;
        this.setPreferredSize(new Dimension(gameWorld.getWidth(), 20));
        setBackground(Color.GRAY);
    }

    void update() {
        repaint();
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.drawString("gen : " + this.gameWorld.getWorldAge(), 350, 15);
    }
}
