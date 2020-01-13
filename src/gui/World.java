package gui;

import engine.RandomWalker;
import shared.Utils;

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

    World() {
        setPreferredSize(new Dimension(Utils.WIDTH, Utils.HEIGHT));
        setBackground(Color.BLACK);
        this.worldAge = new AtomicInteger(0);
        this.walker = new RandomWalker(this, Utils.WALKER_SIZE, Utils.LEAVE_SNAIL_TRAIL);
    }

    AtomicInteger getWorldAge() {
        return this.worldAge;
    }

    void update() {
        this.walker.step();
        this.worldAge.incrementAndGet();
        if(this.walker.leaveSnailTrail()) {
            repaint(this.walker.getCurrentLocation().getX(),
                    this.walker.getCurrentLocation().getY(),
                    this.walker.getSize(),
                    this.walker.getSize());
        } else {
            repaint();
        }
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setColor(randomColor());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fill3DRect(this.walker.getCurrentLocation().getX(),
                     this.walker.getCurrentLocation().getY(),
                     this.walker.getSize(),
                     this.walker.getSize(),
                true);
    }

    private static Color randomColor() {
        final float r = Utils.R.nextFloat();
        final float g = Utils.R.nextFloat();
        final float b = Utils.R.nextFloat();
        return new Color(r, g, b);
    }

}
