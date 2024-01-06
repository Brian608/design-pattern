package org.feather.creation;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: EagerSingleton
 * @author: feather
 * @description: 创建型：饿汉式单例模式
 * 实现一个单例模式
 * 1:构造器私有化
 * 2:暴露一个公共的获取单例对象的接口
 * 3:是否支持懒加载(延迟加载)
 * 4：是否线程安全
 * @since: 06-Jan-24 9:02 PM
 * @version: 1.0
 */
public class EagerSingleton {

    /**
     * 1:创建对象本身复杂度
     * 很多单例对象创建的过程极其复杂
     * 很多单例对象创建完成后会占用很大内存，比如缓存对象
     * 很多单例对象创建完成后可能很小且很简单
     **/

    // 1:持有一个jvm全局唯一的实例
    private  final static  EagerSingleton instance=new EagerSingleton();

    // 2:为了避免别人随意的创建，我们需要私有化构造器
    private  EagerSingleton(){}

    //3：暴露一个方法用来获取实例
    public static EagerSingleton getInstance() {
        return instance;
    }
}
