package engine;

import shared.Utils;

public class RandomWalker {

    private final int size;
    private CartesianPoint currentLocation;
    private final boolean leaveSnailTrail;

    RandomWalker(final int size,
                 final boolean leaveSnailTrail) {
        this.currentLocation = CartesianPoint.getPoint(Utils.WIDTH / 2, Utils.HEIGHT / 2);
        this.size = size;
        this.leaveSnailTrail = leaveSnailTrail;
    }

    public int getSize() {
        return this.size;
    }

    public CartesianPoint getCurrentLocation() {
        return this.currentLocation;
    }

    public boolean leaveSnailTrail() {
        return this.leaveSnailTrail;
    }

    void step() {
        CartesianPoint nextStep = this.currentLocation;
        final int choice = Utils.R.nextInt(4);
        switch(choice) {
            case 0:
                if (this.currentLocation.getX() + this.size < Utils.WIDTH) {
                    nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX() + this.size,
                            this.getCurrentLocation().getY());
                }
                break;
            case 1:
                if (this.currentLocation.getX() - this.size > 0) {
                    nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX() - this.size,
                            this.getCurrentLocation().getY());
                }
                break;
            case 2:
                if (this.currentLocation.getY() + this.size < Utils.HEIGHT) {
                    nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX(),
                            this.getCurrentLocation().getY() + this.size);
                }
                break;
            case 3:
                if (this.currentLocation.getY() - this.size > 0) {
                    nextStep = CartesianPoint.getPoint(this.getCurrentLocation().getX(),
                            this.getCurrentLocation().getY() - this.size);
                }
                break;
            default:
                throw new RuntimeException("bad choice!");
        }

        this.currentLocation = nextStep;
    }
}
