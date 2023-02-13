package org.lld.practice.snake.ladder;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Board {
    private final int dimensions;
    private final int totalCells;
    final Map<Integer, SpecialEntity> specialEntityMap;

    public Board(@NonNull final int dimensions) {
        this.dimensions = dimensions;
        this.totalCells = dimensions * dimensions;
        this.specialEntityMap = new HashMap<>();
    }

    public void printBoard() {
        int totalCells = dimensions * dimensions;

        for (int i = 0; i < totalCells; i++) {
            System.out.println("|" + i + " ");
            if (hasSpecialEntity(i)) {
                System.out.print(getSpecialEntity(i).getId());
            }
            System.out.print("|");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void addSpecialEntity(SpecialEntity specialEntity) {
        this.specialEntityMap.put(specialEntity.getStart(), specialEntity);
    }

    public boolean hasSpecialEntity(int position) {
        return this.specialEntityMap.containsKey(position);
    }

    public SpecialEntity getSpecialEntity(int position) {
        if (this.specialEntityMap.containsKey(position)) {
            return this.specialEntityMap.get(position);
        }
        return null;
    }
}
