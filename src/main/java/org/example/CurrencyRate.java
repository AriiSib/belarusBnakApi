package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class CurrencyRate {
    private BigDecimal in;
    private BigDecimal out;

    public void setRate(String operation, BigDecimal value) {
        if ("in".equalsIgnoreCase(operation)) {
            this.in = value;
        } else if ("out".equalsIgnoreCase(operation)) {
            this.out = value;
        }
    }
}
