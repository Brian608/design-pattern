package org.feather.simpleFactory;

/**
 * @projectName: design-pattern
 * @package: org.feather.simpleFactory
 * @className: ResourceFactory
 * @author: feather
 * @description:
 * @since: 2024-05-04 09:20
 * @version: 1.0
 */
public class ResourceFactory {

    public static Resource create(String type,String url){
        //2.根据前缀处理不同的资源
        if ("http".equals(type)){
            // 发起请求加载资源
            return new Resource(url);

        } else if ("file".equals(type)) {
            // 建立流 做异常处理等等
            return new Resource(url);
        }
        else if ("classpath".equals(type)) {
            // ....
            return new Resource(url);
        }else {
            return new Resource("default");
        }

    }
}
