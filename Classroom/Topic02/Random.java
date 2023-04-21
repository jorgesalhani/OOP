package Classroom.Topic02;

public class Random {
    private long m = 843314861;
    private long a = 453816693;
    private long p = 2147483648L;
    // public long xi = 1025;  // Not ideal! Better: hide attributes
    private long xi = 1023;

    public Random(int k) {
        xi = k;
    }

    public Random() {}          // Can have more than 1 constructor
                                // no param and a default xi value = 1023

    public double getRand() {
        return (double) ((m * xi + a) % p);
    }

    public int getIntRand(int max) {
        double d = getRand() * max;
        return (int) d;
    }

    public void setSeed(long seed) {
        xi = seed;
    }
}
