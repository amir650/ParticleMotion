package gui;

import engine.Walker;
import engine.World;
import shared.Utils;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Collection;

public class WorldPanel extends JPanel {

    private final World world;

    WorldPanel(final World world) {
        this.world = world;
        setPreferredSize(new Dimension(Utils.WIDTH, Utils.HEIGHT));
        setBackground(Color.BLACK);
    }

    World getWorld() {
        return this.world;
    }

    void update() {
        this.world.iterate();
        final Collection<Walker> walkers = this.world.getWalkers();
        for(final Walker walker : walkers) {
            if(walker.leaveSnailTrail()) {
                repaint(walker.getCurrentLocation().getX(),
                        walker.getCurrentLocation().getY(),
                        walker.getSize(),
                        walker.getSize());
            } else {
                repaint();
            }
        }
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        final Collection<Walker> walkers = this.world.getWalkers();
        g.setColor(randomColor());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(final Walker walker : walkers) {
            g.fill3DRect(walker.getCurrentLocation().getX(),
                    walker.getCurrentLocation().getY(),
                    walker.getSize(),
                    walker.getSize(),
                    true);
        }
    }

    private static Color randomColor() {
        final float r = Utils.R.nextFloat();
        final float g = Utils.R.nextFloat();
        final float b = Utils.R.nextFloat();
        return new Color(r, g, b);
    }

}
