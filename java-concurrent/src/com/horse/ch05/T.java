package com.horse.ch05;

/**
 * @Description 分析一下程序运行的结果
 * @Author Mr.Horse
 * @Date 2021/2/25
 */
public class T implements Runnable{

    private int count = 10;

    @Override
    public /*synchronized*/ void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i=0; i<5; i++) {
            new Thread(t, "Thread"+i).start();
        }
    }
}
