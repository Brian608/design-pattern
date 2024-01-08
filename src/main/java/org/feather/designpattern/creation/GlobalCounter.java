package org.feather.designpattern.creation;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: GlobalCounter
 * @author: feather
 * @description: 全局计数器
 * @since: 06-Jan-24 10:05 PM
 * @version: 1.0
 */
public enum GlobalCounter {

    INSTANCE;
    private AtomicLong atomicLong=new AtomicLong(0);
    public  Long getNumber(){
        return atomicLong.getAndDecrement();
    }
}
