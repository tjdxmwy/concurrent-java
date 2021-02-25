package com.horse.ch03;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/25
 */
public class T {
    private int count = 10;

    //synchronized锁定的不是代码块,而是当前对象
    public synchronized void m() {//等同于在方法的代码执行要synchronized(this)
        count --;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }
}
