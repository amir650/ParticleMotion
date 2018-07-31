import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartesianPoint {

    private final int x;
    private final int y;

    private static final Map<String, CartesianPoint> POINTS_CACHE = initPointsCache();

    private CartesianPoint(final int x,
                           final int y) {
        this.x = x;
        this.y = y;
    }

    static CartesianPoint getPoint(final int x,
                                   final int y) {
        final String key = x + "_" + y;
        if (!POINTS_CACHE.containsKey(key)) {
            throw new RuntimeException("Specified point doesn't exist in map");
        } else {
            return POINTS_CACHE.get(key);
        }
    }

    private static Map<String, CartesianPoint> initPointsCache() {
        final Map<String, CartesianPoint> pointsCache = new HashMap<>();
        for(int i = 0; i < World.WIDTH; i++) {
            for(int j = 0; j < World.HEIGHT; j++) {
                pointsCache.put(i + "_" +j, new CartesianPoint(i, j));
            }
        }
        System.out.println("Points cache filled up, size = " +pointsCache.size());
        return Collections.unmodifiableMap(pointsCache);
    }


    int getX() {
        return this.x;
    }

    int getY() {
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
