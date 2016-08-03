package com.song.metric;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

public class GaugeServlet extends HttpServlet {

    private static final long serialVersionUID = -5806114004159979797L;
    
    static final MetricRegistry mReg = MyMetricsServletContextListener.METRIC_REGISTRY;
    static final List<Integer> l = new ArrayList<Integer>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        l.add(1);
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        startReport();
        createMetric();
    }

    private void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(mReg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        reporter.start(5, TimeUnit.SECONDS);
        reporter.report();
    }
    
    private void createMetric() {
        mReg.register("Gauge", new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return l.size();
            }
        });
    }
}
