package org.feather.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: design-pattern
 * @package: org.feather.concurrency
 * @className: AccessCounter
 * @author: feather
 * @description: 接口访问统计计数
 * @since: 08-Jan-24 5:38 PM
 * @version: 1.0
 */
public class AccessCounter {

    /*
     * 接口访问的次数
     **/
    AtomicInteger atomicCount=new AtomicInteger(0);

    public  Integer access(){
       return atomicCount.getAndDecrement();

    }
}
