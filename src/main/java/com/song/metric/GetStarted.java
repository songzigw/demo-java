package com.song.metric;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

public class GetStarted {

    static final MetricRegistry reg = new MetricRegistry();

    public static void main(String args[]) {
        startReport();
        // Meter requests = reg.meter("requests");
        // requests.mark(2);
        // wait5Seconds();

        Histogram h = reg.histogram("requests");
        Random rand = new Random();
        while (true) {
            h.update((int) (rand.nextDouble() * 100));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(reg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        reporter.start(3, TimeUnit.SECONDS);
        reporter.report();
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
