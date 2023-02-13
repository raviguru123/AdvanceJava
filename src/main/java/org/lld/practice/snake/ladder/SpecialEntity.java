package org.lld.practice.snake.ladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class SpecialEntity {
    private final int start;
    private final int end;

    public abstract String getId();
}
