import java.util.Random;

class RandomWalker {

    private final int size;
    private final World gameWorld;

    private CartesianPoint currentLocation;

    private static final Random R = new Random();

    RandomWalker(final World gameWorld) {
        this.currentLocation = CartesianPoint.getPoint(World.WIDTH / 2, World.HEIGHT / 2);
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
        CartesianPoint nextStep = null;
        final int choice = R.nextInt(4);

        if(choice == 0) {
            if (this.currentLocation.getX() + 1 < this.gameWorld.getWidth()) {
                nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX() + 1,
                        this.getCurrentLocation().getY());
            }
        } else if(choice == 1) {
            if (this.currentLocation.getX() - 1 > 0) {
                nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX() - 1,
                        this.getCurrentLocation().getY());
            }
        } else if(choice == 2) {
            if (this.currentLocation.getY() + 1 < this.gameWorld.getHeight()) {
                nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX(),
                        this.getCurrentLocation().getY() + 1);
            }
        } else if(choice == 3){
            if (this.currentLocation.getY() - 1 > 0) {
                nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX(),
                        this.getCurrentLocation().getY() - 1);
            }
        }

        if(nextStep != null) {
            this.currentLocation = nextStep;
        }
    }
}
