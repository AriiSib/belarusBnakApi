package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor
@Getter
public class Filial {
    private Map<String, CurrencyRate> currencyRates = new HashMap<>();

    public void addCurrencyRate(String operation, BigDecimal value) {
        currencyRates.put(operation, new CurrencyRate());
        CurrencyRate currencyRate = currencyRates.get(operation);
        currencyRate.setRate(operation, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("currencyRates", currencyRates.get("in") != null ?
                        currencyRates.get("in").getIn() : currencyRates.get("out").getOut())
                .toString();
    }
}
