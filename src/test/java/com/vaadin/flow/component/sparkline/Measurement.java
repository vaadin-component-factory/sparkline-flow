package com.vaadin.flow.component.sparkline;

import java.io.Serializable;
import java.time.Instant;

public class Measurement implements Serializable {

    private Instant instant;
    private Double value;

    public Measurement(Instant instant, Double value) {
        this.instant = instant;
        this.value = value;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
