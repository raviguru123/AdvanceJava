package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
public class Trader {
    private final String name;
    private final String city;
}
