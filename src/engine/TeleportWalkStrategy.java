package engine;

import shared.Utils;

public class TeleportWalkStrategy implements WalkingStrategy {
    @Override
    public CartesianPoint step(Walker walker) {
        return CartesianPoint.getPoint(Utils.R.nextInt(Utils.WIDTH), Utils.R.nextInt(Utils.HEIGHT));
    }
}
