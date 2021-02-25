package com.horse.ch02;

/**
 * @Description Synchronized关键字,对某个对象加锁
 * @Author Mr.Horse
 * @Date 2021/2/25
 */
public class T {
    private int count = 10;

    public void m() {
        synchronized(this) {//任何线程要执行下面的代码,必须先拿到this锁
            count --;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

}
