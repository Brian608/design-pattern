package org.feather.designpattern.factoryMethod.resourceFactory;

import org.feather.designpattern.factoryMethod.resourceFactory.impl.ClasspathResourceLoader;
import org.feather.designpattern.factoryMethod.resourceFactory.impl.DefaultResourceLoader;
import org.feather.designpattern.factoryMethod.resourceFactory.impl.FileResourceLoader;
import org.feather.designpattern.factoryMethod.resourceFactory.impl.HttpResourceLoader;
import org.feather.designpattern.simpleFactory.Resource;
import org.feather.designpattern.simpleFactory.ResourceLoadException;

import java.awt.color.ICC_ColorSpace;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

//    private IResourceLoader resourceLoader;

    private static Map<String,IResourceLoader> resourceLoaderCache=new HashMap<>();
    //版本二
//    static {
//        resourceLoaderCache.put("http",new HttpResourceLoader());
//        resourceLoaderCache.put("file",new FileResourceLoader());
//        resourceLoaderCache.put("classpath",new ClasspathResourceLoader());
//        resourceLoaderCache.put("default",new DefaultResourceLoader());
//    }
    //版本三
    static {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("resourceLoader.properties");
        Properties properties=new Properties();
        try {
            properties.load(resourceAsStream);
            for (Map.Entry<Object, Object> entry:properties.entrySet()){
                String key = entry.getKey().toString();
                Class<?> clazz = Class.forName(entry.getValue().toString());
                IResourceLoader loader =(IResourceLoader) clazz.getConstructor().newInstance();
                resourceLoaderCache.put(key,loader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

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
//        //根据前缀选择不同的工厂，产生独自的产品
//        if ("http".equals(prefix)){
//            resourceLoader=new HttpResourceLoader();
//
//        } else if ("file".equals(prefix)) {
//           resourceLoader= new FileResourceLoader();
//        }
//        else if ("classpath".equals(prefix)) {
//            // ....
//            resourceLoader =new ClasspathResourceLoader();
//        }else {
//           resourceLoader =new DefaultResourceLoader();
//        }
//        return  resourceLoader.load(url);
        //版本二
        return resourceLoaderCache.get(prefix).load(url);

    }

    private String getPrefix(String url){
        if (url == null || !url.contains(":")){
            throw  new ResourceLoadException("传入的资源url 不合法");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
