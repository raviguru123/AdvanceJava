package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
