package org.lld.practice.snake.ladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class Player {
    @Setter
    private int position;
    private final String name;

    public Player(@NonNull final String name) {
        this.name = name;
        this.position = 0;
    }
}
