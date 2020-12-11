# Vaadin Sparkline

Vaadin Sparkline is a standalone sparkline component for Vaadin Flow. See also Grid Sparkline renderer: https://vaadin.com/directory/component/grid-sparklinerenderer-flow


### Installing
Add Sparkline to your project
```xml
<dependency>
    <groupId>com.vaadin</groupId>
    <artifactId>sparkline-flow</artifactId>
    <version>${project.version}</version>
</dependency>
```

### Using Vaadin Sparkline

#### Basic use
```java
public class SparklineTest extends VerticalLayout {

    public SparklineTest() {
        //...
        Sparkline sparklineSimple = new Sparkline(createSparklineValues(createSong()));
        sparklineSimple.setWidth("120px");
        sparklineSimple.setHeight("20px");
        add(sparklineSimple);
        //...
    }

    private SparklineValues createSparklineValues(Song song) {
        // convert existing time series data to a SparklineValues object
        return new SparklineValues(song.getDailyListeners().getMeasurements().stream().map(measurement -> new SparklineValues.SparklineValue(measurement.getInstant(), measurement.getValue())).collect(Collectors.toList()));
    }
}
```

#### Add PlotBands

```java
public class SparklineTest extends VerticalLayout {
    
    private void plotBandDemo() {
        //... 
        Patient patient = createPatient();
        Sparkline sparklinePlotBands = new Sparkline(createSparklineValuesTemp(patient), createSparklineConfTemp(patient));
        sparklinePlotBands.setWidth("120px");
        sparklinePlotBands.setHeight("20px");
        add(sparklinePlotBands);
    }
    
    private SparklineConfiguration createSparklineConfTemp(Patient patient) {
            return new SparklineConfiguration()
                    // scale y-axis between min and ax value
                    .withAutoScaleYAxis(true)
                    // add a plotband with line color and background color
                    .withPlotBand(new SparkLinePlotBand(36.0, 38.0)
                            .withBackgroundColor(SparklineConfiguration.LIGHT_GREEN).withLineColor(Color.GREEN))
                    // add a plotband with line color
                    .withPlotBand(new SparkLinePlotBand(38.0, 41.0)
                            .withLineColor(Color.RED));
    }

}
```

## Setting up for development

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone https://github.com/vaadin-component-factory/sparkline-flow.git
```

To build and install the project into the local repository run

```mvn install -DskipITs```

in the root directory. `-DskipITs` will skip the integration tests, which require a TestBench license. If you want to run all tests as part of the build, run

```mvn install```


## License & Author

This Add-on is distributed under Apache 2.0

Component Factory Sparkline is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)

