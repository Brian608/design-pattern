package org.feather.designpattern.factoryMethod.resourceFactory.impl;

import org.feather.designpattern.factoryMethod.resourceFactory.IResourceLoader;
import org.feather.designpattern.simpleFactory.Resource;

/**
 * @projectName: design-pattern
 * @package: org.feather.designpattern.factoryMethod.resourceFactory.impl
 * @className: HttpResourceLoader
 * @author: feather
 * @description:
 * @since: 2024-05-04 09:42
 * @version: 1.0
 */
public class FileResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
        //中间省略复杂的创建过程
        return new Resource(url);
    }
}
