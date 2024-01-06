package org.feather.creation;

import org.junit.Test;

/**
 * @projectName: design-pattern
 * @package: org.feather.creation
 * @className: SingletonTest
 * @author: feather
 * @description:
 * @since: 06-Jan-24 9:45 PM
 * @version: 1.0
 */
public class SingletonTest {

   @Test
    public  void testSingleton(){

       System.out.println("EagerSingleton.getInstance() == EagerSingleton.getInstance()->"+(EagerSingleton.getInstance() == EagerSingleton.getInstance()));

       System.out.println("LazySingleton.getInstance()==LazySingleton.getInstance() -> " + (LazySingleton.getInstance() == LazySingleton.getInstance()));

       System.out.println("DoubleCheckSingleton.getInstance()==DoubleCheckSingleton.getInstance() -> " +( DoubleCheckSingleton.getInstance() == DoubleCheckSingleton.getInstance()));
   }
}
