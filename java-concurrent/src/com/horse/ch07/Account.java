package com.horse.ch07;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/25
 */

import java.util.concurrent.TimeUnit;

/**
 * 对业务读方法加锁
 * 对业务写方法不加锁
 * 容易产生脏读问题(dirtyRead)
 */
public class Account {
    String name;
    double balance;

    public synchronized void set(String name, Double balance) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        /**
         * 运行结果:
         *    0.0
         *    100.0
         * 此时产生脏读问题,如果解决需要在读的方法上添加synchronized关键字
         */
    }
}
