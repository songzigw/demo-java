package com.song.demo.thread;

/**
 * 不建议使用此方式定义线程，
 * 因为采用继承Thread的方式
 * 定义线程后，你不能在继承
 * 其他的类了，导致程序的可
 * 扩展性大大降低。
 * @author 张松
 *
 */
public class WorkThread extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Thread定义某个工作线程在运行");
	}

	public static void main(String[] args) {
		WorkThread wt = new WorkThread();
		wt.start();
	}
}
