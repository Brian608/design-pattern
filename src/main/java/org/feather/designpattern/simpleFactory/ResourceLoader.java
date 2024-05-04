package org.feather.designpattern.simpleFactory;

/**
 * @projectName: design-pattern
 * @package: org.feather.simpleFactory
 * @className: ResourceLoader
 * @author: feather
 * @description:
 * @since: 2024-05-04 09:08
 * @version: 1.0
 */
public class ResourceLoader {

    /**
     * description:
     * @param url file:// http://  classpath://
     * @return {@link Resource}
     * @author: feather
     * @since: 2024-05-04 09:08
     **/
    public  Resource load(String url){
        // 1 根据url 获取前缀
        String prefix= getPrefix(url);
        return ResourceFactory.create(prefix,url);
    }

    private String getPrefix(String url){
        if (url == null || !url.contains(":")){
            throw  new ResourceLoadException("传入的资源url 不合法");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
