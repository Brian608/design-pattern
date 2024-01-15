package org.feather.creation;

import org.feather.designpattern.creation.DoubleCheckSingleton;
import org.feather.designpattern.creation.EagerSingleton;
import org.feather.designpattern.creation.LazySingleton;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

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
   /**
    * description: 通过反射破坏单例
    * param []
    * return void
    * author: feather
    * since: 07-Jan-24 9:51 AM
    **/
   @Test
   public  void testReflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
      Class<DoubleCheckSingleton> doubleCheckSingletonClass = DoubleCheckSingleton.class;
      Constructor<DoubleCheckSingleton> constructor = doubleCheckSingletonClass.getDeclaredConstructor();
      constructor.setAccessible(true);

      boolean flag=DoubleCheckSingleton.getInstance()==constructor.newInstance();
      System.out.println("flag->{}"+flag);

   }

   @Test
   public  void testRuntime() throws IOException {
      Runtime runtime=Runtime.getRuntime();
      Process exec=runtime.exec("ping 127.0.0.1");
      InputStream inputStream=exec.getInputStream();
      byte [] buffer=new byte[1024];
      int len;
      while ((len=inputStream.read(buffer))>0){
         System.out.println(new String(buffer,0,len, Charset.forName("GBK")));
      }
      long maxMemory=runtime.maxMemory();
      System.out.println("maxMemory----:"+maxMemory);
   }
}
