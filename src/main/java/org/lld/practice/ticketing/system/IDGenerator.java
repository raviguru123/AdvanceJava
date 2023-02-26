package org.lld.practice.ticketing.system;

public final class IDGenerator {
    private static int id = 0;

    private IDGenerator() {

    }

    public static int getID() {
        id += 1;
        return id;
    }
}
