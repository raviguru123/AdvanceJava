package org.lld.practice.foodkart;

public class IdGenerator {
    private static Integer id = 0;

    public static Integer getId() {
        id += 1;
        return id;
    }
}
