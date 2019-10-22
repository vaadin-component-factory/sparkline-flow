package com.vaadin.flow.component.sparkline;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.sparklinerenderer.SparkLinePlotBand;
import com.vaadin.flow.component.sparklinerenderer.SparklineConfiguration;
import com.vaadin.flow.component.sparklinerenderer.SparklineValues;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        Patient patient = new Patient();
        add(new Sparkline(createSparklineValues(patient), createConfiguration(patient)));
    }

    private SparklineConfiguration createConfiguration(Patient patient) {
        return new SparklineConfiguration().withPlotBand(new SparkLinePlotBand(36.0, 37.0).withBackgroundColor(Color.GREEN));
    }

    private SparklineValues createSparklineValues(Patient patient) {
        return new SparklineValues(patient.temperatureMeasurements.stream().map(measurement -> new SparklineValues.SparklineValue(measurement.getInstant(), measurement.getValue())).collect(Collectors.toList()));
    }

    static class Patient {
        List<Measurement> temperatureMeasurements = Arrays.asList(new Measurement(Instant.now().minusSeconds(10800), 36.8), new Measurement(Instant.now().minusSeconds(7200), 37.0), new Measurement(Instant.now().minusSeconds(3600), 37.2));
    }

}
