package engine;

import shared.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {

    private final AtomicInteger worldAge;
    private final Collection<Walker> walkers;

    public World() {
        this.worldAge = new AtomicInteger(0);
        this.walkers = initWalkers(1);
    }

    private Collection<Walker> initWalkers(final int n) {
        return IntStream.range(0, n).mapToObj(i -> new Walker(Utils.WALKER_SIZE, Utils.LEAVE_SNAIL_TRAIL, new RandomWalkStrategy()))
                                    .collect(Collectors.toList());
    }

    public Collection<Walker> getWalkers() {
        return this.walkers;
    }

    public AtomicInteger getWorldAge() {
        return this.worldAge;
    }

    public void iterate() {
        this.walkers.forEach(Walker::step);
        this.worldAge.incrementAndGet();
    }

}
