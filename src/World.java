import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.concurrent.atomic.AtomicInteger;

public class World extends JPanel {

    private final AtomicInteger worldAge;
    private final RandomWalker walker;

    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    World() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        this.worldAge = new AtomicInteger(0);
        this.walker = new RandomWalker(this);
    }

    AtomicInteger getWorldAge() {
        return this.worldAge;
    }

    void update() {
        this.walker.step();
        this.worldAge.incrementAndGet();
        repaint(this.walker.getCurrentLocation().getX(),
                this.walker.getCurrentLocation().getY(),
                this.walker.getSize(),
                this.walker.getSize());
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.CYAN);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = Color.GREEN;
        g.setColor(color);
        g.fill3DRect(this.walker.getCurrentLocation().getX(),
                this.walker.getCurrentLocation().getY(),
                this.walker.getSize(),
                this.walker.getSize(), true);
    }

}
