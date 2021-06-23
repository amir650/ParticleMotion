package engine;

import shared.Utils;

public class Walker {

    private final int size;
    private CartesianPoint currentLocation;
    private final boolean leaveSnailTrail;
    private final WalkingStrategy walkingStrategy;

    Walker(final int size,
           final boolean leaveSnailTrail,
           final WalkingStrategy walkingStrategy) {
        this.currentLocation = CartesianPoint.getPoint(Utils.WIDTH / 2, Utils.HEIGHT / 2);
        this.size = size;
        this.leaveSnailTrail = leaveSnailTrail;
        this.walkingStrategy = walkingStrategy;
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
        this.currentLocation = this.walkingStrategy.step(this);
    }
}
