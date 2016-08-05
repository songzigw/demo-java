package com.song.metric;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * 
 * 系统需要度量的，所有数据指标
 * 变量的定义，全部封装在这个类中。
 * <p>
 * 
 * 将定义好的变量，埋点的目标程序
 * 执行代码中，就可以用来度量目标
 * 程序运行状况。
 * 
 * @author zhangsong
 *
 */
public class MetricsDefine {

    /** 指标注册管理器，所有待度量的指标对象都要被注册进来 */
    public static final MetricRegistry mReg = new MetricRegistry();
    
    // 下面定义了3个报告者对象，可以根据需要开启不同的报告者，获取全部开启
    
    /** 每5分钟输出一次的报告 */
    public static ConsoleReporter reporter5;
    /** 每60分钟输出一次的报告 */
    public static ConsoleReporter reporter60;
    /** 每1440分钟输出一次的报告 */
    public static ConsoleReporter reporter1440;
    
    // 下面定义需要度量的指标对象
    
    /** 度量List对象中元素的个数（瞬时值） */
    Gauge<Integer> gauge;
    /** 度量某段代码的累计执行次数 */
    Counter counter;
    /** 
     * 度量某段代码在一段时间内平均每秒执行次数，
     * 最近1、5、15分钟内的代码平均每秒执行次数
     */
    Meter meter;
    
    /**
     * 开启一个每5分钟输出一次的报告
     */
    public static void startReport3() {
        reporter5 = ConsoleReporter.forRegistry(mReg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        reporter5.start(5, TimeUnit.MINUTES);
    }
    
    /**
     * 开启一个每60分钟输出一次的报告
     */
    public static void startReport60() {
        reporter60 = ConsoleReporter.forRegistry(mReg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        reporter60.start(60, TimeUnit.MINUTES);
    }
    
    /**
     * 开启一个每1440分钟输出一次的报告
     */
    public static void startReport1440() {
        reporter1440 = ConsoleReporter.forRegistry(mReg)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS).build();

        reporter1440.start(1440, TimeUnit.MINUTES);
    }
}
