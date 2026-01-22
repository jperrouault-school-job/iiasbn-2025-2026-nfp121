public class Point {
    private int x;
    private int y;

    public void increment(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "[x = " + this.x + ", y = " + this.y + "]";
    }
}
