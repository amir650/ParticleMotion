package engine;

import shared.Utils;

public class RandomWalkStrategy implements WalkingStrategy {
    @Override
    public CartesianPoint step(Walker walker) {
        CartesianPoint nextStep = walker.getCurrentLocation();
        final int choice = Utils.R.nextInt(4);
        switch(choice) {
            case 0:
                if (walker.getCurrentLocation().getX() + walker.getSize() < Utils.WIDTH) {
                    nextStep = CartesianPoint.getPoint(walker.getCurrentLocation().getX() + walker.getSize(),
                            walker.getCurrentLocation().getY());
                }
                break;
            case 1:
                if (walker.getCurrentLocation().getX() - walker.getSize() > 0) {
                    nextStep = CartesianPoint.getPoint(walker.getCurrentLocation().getX() - walker.getSize(),
                            walker.getCurrentLocation().getY());
                }
                break;
            case 2:
                if (walker.getCurrentLocation().getY() + walker.getSize() < Utils.HEIGHT) {
                    nextStep = CartesianPoint.getPoint(walker.getCurrentLocation().getX(),
                            walker.getCurrentLocation().getY() + walker.getSize());
                }
                break;
            case 3:
                if (walker.getCurrentLocation().getY() - walker.getSize() > 0) {
                    nextStep = CartesianPoint.getPoint(walker.getCurrentLocation().getX(),
                            walker.getCurrentLocation().getY() - walker.getSize());
                }
                break;
            default:
                throw new RuntimeException("bad choice!");
        }

        return nextStep;
    }
}
