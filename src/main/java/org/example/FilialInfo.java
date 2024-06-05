package org.example;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
public class FilialInfo {
    private final UnknownPropertyHandler propertyHandler = new UnknownPropertyHandler();

    @JsonProperty("filial_id")
    private String filialId;
    @JsonProperty("sap_id")
    private String sapId;
    @JsonProperty("info_worktime")
    private String workTime;
    @JsonProperty("street_type")
    private String streetType;
    @JsonProperty("street")
    private String street;
    @JsonProperty("home_number")
    private String homeNumber;
    @JsonProperty("filials_text")
    private String filialText;
    private City city = new City();

    private Map<String, Filial> filials = new HashMap<>();


    @JsonAnySetter
    public void handleUnknown(String key, String value) {
        if (key.equals("name") || key.equals("name_type")) {
            propertyHandler.handleUnknownProperty(this, key, value);
            return;
        }

        String[] parts = key.split("_");
        Filial filial = new Filial();
        filial.addCurrencyRate(parts[parts.length - 1], new BigDecimal(value));
        filials.put(key, filial);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("Filials", formatFilials(filials))
                .append("Filial ID", filialId)
                .append("SAP ID", sapId)
                .append("Work Time", workTime)
                .append("Address", streetType + " " + street + " " + homeNumber)
                .append("Filial Text", filialText)
                .append("City", city.getName() + " (" + city.getNameType() + ")")
                .toString();
    }

    private String formatFilials(Map<String, Filial> filials) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Filial> entry : filials.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}