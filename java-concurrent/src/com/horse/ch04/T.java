package com.horse.ch04;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/25
 */
public class T {
    public static int count = 10;

    public synchronized static void m() {   //等同于synchronized(com.horse.ch04.T.class)
        count --;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void mm() {
        synchronized (T.class) {//这里用synchronized(this)可以吗?不可以
            count --;
        }
    }
}
