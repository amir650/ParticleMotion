package engine;

import shared.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CartesianPoint {

    private final int x;
    private final int y;

    private static final Map<String, CartesianPoint> POINTS_CACHE = initPointsCache();

    private CartesianPoint(final int x,
                           final int y) {
        this.x = x;
        this.y = y;
    }

    public static CartesianPoint getPoint(final int x,
                                          final int y) {
        return Optional.ofNullable(POINTS_CACHE.get(stringifyCoordinates(x, y)))
                       .orElseThrow(() -> new IllegalArgumentException("Unsupported value: " +stringifyCoordinates(x, y)));
    }

    private static Map<String, CartesianPoint> initPointsCache() {
        final Map<String, CartesianPoint> pointsCache = new HashMap<>();
        for(int i = 0; i < Utils.WIDTH; i++) {
            for(int j = 0; j < Utils.HEIGHT; j++) {
                pointsCache.put(stringifyCoordinates(i, j), new CartesianPoint(i, j));
            }
        }
        return Collections.unmodifiableMap(pointsCache);
    }

    private static String stringifyCoordinates(final int x,
                                               final int y) {
        return x + "." + y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CartesianPoint point = (CartesianPoint) o;
        return this.x == point.x &&
               this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
