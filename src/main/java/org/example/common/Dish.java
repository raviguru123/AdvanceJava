package org.example.common;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
public class Dish {
    private final String name;
    private final Boolean vegetarian;
    private final Integer calories;
    private final Type type;
    public enum  Type {MEAT, FISH, OTHER}

    @Override
    public int hashCode() {
        return name.hashCode() + vegetarian.hashCode() + calories.hashCode() + type.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

       if(!(o instanceof  Dish)) {
            return false;
        }

        Dish o2 = (Dish) o;

        return this.getName().equals(o2.getName())
            && this.getCalories().equals(o2.getCalories())
                && this.getType().equals(o2.getType())
                && this.getVegetarian().equals(o2.getVegetarian());
    }
}

