package org.feather.designpattern.creation;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: LazySingleton
 * @author: feather
 * @description: 懒汉式单例实现  线程不安全
 * @since: 06-Jan-24 9:18 PM
 * @version: 1.0
 */
public class LazySingleton {

    // 1:持有一个jvm 全局变量
    private static LazySingleton instance;

    //2：为了避免别人随意创建，我们需要私有化构造器
    private LazySingleton(){};

    //3：暴露一个方法，用来获取实例
    public static LazySingleton getInstance(){
        if (null==instance){
            instance=new LazySingleton();
        }
        return  instance;
    }


}
