package engine;

import shared.Utils;
import java.util.concurrent.atomic.AtomicInteger;

public class World {

    private final AtomicInteger worldAge;
    private final RandomWalker walker;

    public World() {
        this.worldAge = new AtomicInteger(0);
        this.walker = new RandomWalker(Utils.WALKER_SIZE, Utils.LEAVE_SNAIL_TRAIL);
    }

    public RandomWalker getWalker() {
        return this.walker;
    }

    public AtomicInteger getWorldAge() {
        return this.worldAge;
    }

    public void iterate() {
        this.walker.step();
        this.worldAge.incrementAndGet();
    }

}
