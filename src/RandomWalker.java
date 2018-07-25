import java.util.Random;

class RandomWalker {

    private final int size;
    private final CartesianPoint currentLocation;
    private final World gameWorld;

    private static final Random R = new Random(1000);

    RandomWalker(final World gameWorld) {
        this.currentLocation = new CartesianPoint(World.WIDTH /2, World.HEIGHT /2);
        this.size = 1;
        this.gameWorld = gameWorld;
    }

    int getSize() {
        return this.size;
    }

    CartesianPoint getCurrentLocation() {
        return this.currentLocation;
    }

    void step() {
        final CartesianPoint lastStep = this.currentLocation;
        final CartesianPoint nextStep = new CartesianPoint(lastStep.getX(), lastStep.getY());
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
