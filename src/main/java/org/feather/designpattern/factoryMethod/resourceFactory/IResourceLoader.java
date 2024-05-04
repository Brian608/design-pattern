package org.feather.designpattern.factoryMethod.resourceFactory;

import org.feather.designpattern.simpleFactory.Resource;

/**
 * @projectName: design-pattern
 * @package: org.feather.designpattern.factoryMethod.resourceFactory
 * @className: IResourceFactory
 * @author: feather
 * @description:
 * @since: 2024-05-04 09:40
 * @version: 1.0
 */
public interface IResourceLoader {

    Resource load(String url);
}
