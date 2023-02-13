package org.lld.practice.snake.ladder;

import lombok.NonNull;

public class Dice {
    final int max_number;

    public Dice(@NonNull final int max_number) {
        this.max_number = max_number;
    }

    public int roll() {
        return (int) Math.floor(Math.random() * max_number + 1);
    }
}
