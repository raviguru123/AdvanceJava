package org.lld.practice.snake.ladder;

import lombok.NonNull;

public class Ladder extends SpecialEntity {

    public Ladder(@NonNull final int start, @NonNull final int end) {
        super(start, end);
    }

    public String getId() {
        return "L_" + this.getEnd();
    }
}
