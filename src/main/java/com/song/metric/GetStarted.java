package com.song.metric;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class GetStarted {

    static final MetricRegistry reg = new MetricRegistry();

    public static void main(String args[]) {
        startReport();
        Meter requests = reg.meter("requests");
        requests.mark(2);
        wait5Seconds();
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(reg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        // CsvReporter reporter = CsvReporter.forRegistry(reg)
        // .formatFor(Locale.US)
        // .convertRatesTo(TimeUnit.SECONDS)
        // .convertDurationsTo(TimeUnit.MILLISECONDS)
        // .build(new File(".\\data\\"));

        reporter.start(1, TimeUnit.SECONDS);
        reporter.report();
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
