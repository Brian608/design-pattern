package org.feather.simpleFactory;

/**
 * @projectName: design-pattern
 * @package: org.feather.simpleFactory
 * @className: ResourceLoadException
 * @author: feather
 * @description:
 * @since: 2024-05-04 09:12
 * @version: 1.0
 */
public class ResourceLoadException  extends  RuntimeException{

    public ResourceLoadException() {
        super("加载资源时发生异常");
    }

    public ResourceLoadException(String message) {
        super(message);
    }
}
