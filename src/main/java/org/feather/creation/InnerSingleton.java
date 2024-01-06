package org.feather.creation;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: InnerSingleton
 * @author: feather
 * @description: 静态内部类的方式实现单例
 * @since: 06-Jan-24 9:56 PM
 * @version: 1.0
 */
public class InnerSingleton {

    //1：构造器私有化
    private  InnerSingleton(){};

    //2:提供一个方法获取单例对象
    public  InnerSingleton getInstance(){
        return InnerSingletonHolder.instance;
    }
   //3 定义内部类来持有实例
    // 特性 类加载机制 ---->一个类会在第一次主动使用的时候被加载
    // 实例会在内部类加载(调用getInstance方法的时候创建)
    private  static  class  InnerSingletonHolder{
     private static  final    InnerSingleton instance=new InnerSingleton();

    }

}
