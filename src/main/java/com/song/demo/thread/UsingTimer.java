package com.song.demo.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UsingTimer {

    static class MyTask extends TimerTask {
        private int taskId = 0;
        
        public MyTask(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Run MyTask-" + taskId + "; Thread-" + new Date());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask myTask1 = new MyTask(1);
        timer.schedule(myTask1, 1000, 100);
        
        TimerTask myTask2 = new MyTask(2);
        timer.schedule(myTask2, 1000, 100);
    }
}
