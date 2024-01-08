package org.feather.designpattern.creation;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: LazySingleton
 * @author: feather
 * @description: 双重检查锁懒汉式单例实现
 * @since: 06-Jan-24 9:18 PM
 * @version: 1.0
 */
public class DoubleCheckSingleton {

    // 1:持有一个jvm 全局变量
    // 创建对象，不是一个原子操作 ，即使使用了双重检查锁，也可能在创建的过程中产生半初始化状态
    // volatile 1 保证内存可见， 2保证有序性
    //事实上，1.9以上不加 volatile 也可以，jvm 内部处理有序性
    private static volatile DoubleCheckSingleton instance;

    //2：为了避免别人随意创建，我们需要私有化构造器
    private DoubleCheckSingleton(){
        //升级版本--->不要让人使用反射创建
        if (instance!=null){
            throw new RuntimeException("该对象是单例的，无法创建多个");
        }
    };

    //3：暴露一个方法，用来获取实例
    //第一次创建 需要双锁，一旦创建好了就不需要锁
    //事实上 获取单例并没有线程安全的问题
    public static DoubleCheckSingleton getInstance(){
        if (null==instance){
            synchronized (DoubleCheckSingleton.class){
                if (null==instance){
                    instance=new DoubleCheckSingleton();
                }
            }
        }
        return  instance;
    }

    public  Object readResolve(){
        return instance;
    }


}
