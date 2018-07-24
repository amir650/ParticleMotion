import java.util.Random;

class RandomWalker {

    private final int size;
    private final Location currentLocation;
    private final boolean showTracks;
    private final World gameWorld;

    private static final Random R = new Random(1000);

    RandomWalker(final World gameWorld,
                 final boolean showTracks) {
        this.currentLocation = new Location(World.WIDTH /2, World.HEIGHT /2);
        this.size = 10;
        this.showTracks = showTracks;
        this.gameWorld = gameWorld;
    }

    int getSize() {
        return this.size;
    }

    Location getCurrentLocation() {
        return this.currentLocation;
    }

    boolean showTracks() {
        return this.showTracks;
    }

    void step() {
        final Location lastStep = this.currentLocation;
        final Location nextStep = new Location(lastStep.getX(), lastStep.getY());
        final int choice = R.nextInt(4);
        switch (choice) {
            case 0:
                if(nextStep.getX() + 1 < this.gameWorld.getWidth()) {
                    nextStep.setX(nextStep.getX() + 1);
                }
                break;
            case 1:
                if(nextStep.getX() - 1 > 0) {
                    nextStep.setX(nextStep.getX() - 1);
                }
                break;
            case 2:
                if(nextStep.getY() + 1 < this.gameWorld.getHeight()) {
                    nextStep.setY(nextStep.getY() + 1);
                }
                break;
            case 3:
                if(nextStep.getY() - 1 > 0) {
                    nextStep.setY(nextStep.getY() - 1);
                }
                break;
            default:
                throw new RuntimeException("what!?");
        }
        this.currentLocation.setX(nextStep.getX());
        this.currentLocation.setY(nextStep.getY());
    }
}
