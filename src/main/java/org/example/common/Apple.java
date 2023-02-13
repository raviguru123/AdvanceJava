package org.example.common;

import lombok.Builder;
import lombok.Value;
import org.example.enums.Color;
import org.example.enums.Country;

@Builder
@Value

public class Apple {
    Integer weight;
    Color color;
    Country country;
}
