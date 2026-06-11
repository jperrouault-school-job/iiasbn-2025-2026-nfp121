@FunctionalInterface
public interface IfaceFncDemo {


    public int maths(int a, int b);

    public default int maths(int a, int b, int c) {
        return 0;
    }

}
