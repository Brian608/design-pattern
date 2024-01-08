package org.feather.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: design-pattern
 * @package: org.feather.concurrency
 * @className: Counter
 * @author: feather
 * @description:
 * @since: 08-Jan-24 5:54 PM
 * @version: 1.0
 */
public class Counter {
    private  int i=0;

    private final  ReentrantLock lock=new ReentrantLock();

    private  void add(){
        i++;
    }
    /**
     * description:  ReentrantLock 加锁
     * @author: feather
     * @since: 08-Jan-24 5:57 PM
     **/
    public void lock1(){
        lock.lock();
        try {
            add();
        }finally {
            lock.unlock();
        }
    }
    /**
     * description: synchronized 加锁
     * @author: feather
     * @since: 08-Jan-24 5:58 PM
     **/
    public  synchronized  void  lock2(){
        add();
    }

}
