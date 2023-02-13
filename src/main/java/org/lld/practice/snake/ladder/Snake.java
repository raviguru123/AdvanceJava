package org.lld.practice.snake.ladder;

import lombok.NonNull;

public class Snake extends SpecialEntity {
    public Snake(@NonNull final int start, @NonNull final int end) {
        super(start, end);
    }

    public String getId() {
        return "S_" + this.getEnd();
    }
}
