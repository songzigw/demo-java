package com.song.demo.thread;

/**
 *  通过实现Runnable接口创建一个线程
 * @author 张松
 *
 */
public class WorkThreadTwo implements Runnable {

	public void run() {
		System.out.println("Runnable定义某个工作线程在运行");
	}
	
	public static void main(String[] args) {
		WorkThreadTwo wtt = new WorkThreadTwo();
		Thread t = new Thread(wtt);
		t.start();
	}

}
