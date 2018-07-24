public class Location {

    private int x;
    private int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(final int x) {
        this.x = x;
    }

    void setY(final int y) {
        this.y = y;
    }
}
