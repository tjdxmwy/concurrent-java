package com.horse.ch06;

/**
 * @Description 25.48
 * @Author Mr.Horse
 * @Date 2021/2/25
 */
public class T {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2");
    }

    public static void main(String[] args) {
        T t = new T();
//        new Thread(() -> t.m1()).start();
//        new Thread(() -> t.m2()).start();

        /**Result:
         *  Thread-0 m1 start...
         *  Thread-1 m2
         *  Thread-0 m1 end...
         * 说明:Synchronized在运行时其他未被Synchronized修饰的方法也是可以运行的
         */

        new Thread(t::m1).start();
        new Thread(t::m2).start();
    }
}
