import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Game extends JFrame {

    private final World gameWorld;
    private final InfoPanel infoPanel;
    private final Timer gameTimer;

    private Game(final World gameWorld) {
        this.gameWorld = gameWorld;
        this.infoPanel = new InfoPanel(gameWorld);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Walk");
        setResizable(false);
        add(this.infoPanel, BorderLayout.NORTH);
        add(this.gameWorld, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        this.gameTimer = new Timer(5, (ActionEvent e) -> {
            this.gameWorld.update();
            this.infoPanel.update();
        });

    }

    private void start() {
        this.gameTimer.start();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final Game game = new Game(new World());
            game.start();
        });
    }

}
