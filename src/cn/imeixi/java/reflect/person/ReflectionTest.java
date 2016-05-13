package cn.imeixi.java.reflect.person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {
	
	
	
	
	
	/**
	 * getMethods,getDeclaredMethods
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@Test
	public void testMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class clazz = Class.forName("cn.imeixi.java.reflect.person.Person");
		
		//1、得到clazz 对应类中的所有方法 getMethods ，不能获得private 方法
		Method[] methods = clazz.getMethods();
		for(Method method:methods){
			System.out.println("^" + method.getName());
		}
		
		//2、获取所有方法，包括private 方法，且只获取当前类声明的方法
		Method[] methods2 = clazz.getDeclaredMethods();
		for(Method method:methods2){
			System.out.println("～" + method.getName());
		}
		
		//3、获取指定的方法
		Method method = clazz.getDeclaredMethod("getInfo");
		System.out.println(method);
		
		method = clazz.getDeclaredMethod("setName", String.class);
		System.out.println(method);
		
		method = clazz.getDeclaredMethod("setName", String.class,int.class);
		System.out.println(method);
		
		
		//4、执行方法
		Object obj = clazz.newInstance();
		method.invoke(obj, "toon",12);
		
		
	}
	
	
	/**
	 * 类加载器启动顺序  1、Bootrap 启动类加载器  2、Extra 扩展类加载器  3、系统加载器
	 * 默认当前类的加载器为：3、系统加载器
	 * getResourceAsStream 与 FileInputStream 的文件路径要特别注意
	 * getResourceAsStream 可获取 src 目录下，或包路径下的文件
	 * FileInputStream 只能获得当前工程下的 文件
	 * 
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testClassLoader() throws ClassNotFoundException, FileNotFoundException{
//		1、获取一个系统的类加载器
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);
		
//		2、获取系统类加载器的父类加载器
		classLoader = classLoader.getParent();
		System.out.println(classLoader);
		
//		3、获取扩展类加载器的父类加载器
		classLoader = classLoader.getParent();
		System.out.println(classLoader);
		
//		4、测试当前类由那个类加载器进行加载
		classLoader = Class.forName("cn.imeixi.java.reflect.person.ReflectionTest").getClassLoader();
		System.out.println(classLoader);
		
//		5、测试JDK提供的Object类由那个类加载器负责加载
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println(classLoader);
		
//		
//		6、关于类加载器的一个主要方法
//		  调用getResourceAsStream 获取类路径下的文件对应的输入流
		
		InputStream in = null;
		in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
		System.out.println(in);
		
		in = this.getClass().getClassLoader().getResourceAsStream("cn/imeixi/java/reflect/person/reflect.properties");
		System.out.println(in);
		
		in = new FileInputStream("file.properties");
		System.out.println(in);
		
		in = new FileInputStream("cn/imeixi/java/reflect/person/reflect.properties");
		System.out.println(in);
	}
	
	/**
	 * Class类的 newInstance 方法可创建反射类对象
	 * 注意：反射创建的类对象，默认使用空参的构造器
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void testNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String className = "cn.imeixi.java.reflect.person.Student";
		Class<?> clazz = Class.forName(className);
		
		Object obj = clazz.newInstance();  // 注意：反射创建的类对象，默认使用空参的构造器
		System.out.println(obj);

	}
	
	@Test
	public void testClass() throws ClassNotFoundException {
		// 创建Class对象的三种方法
		// 方法一：类名.class
		Class<Person> clazz = Person.class;
		System.out.println(clazz);

		// 方法二：this.getClass();返回当前对象的Class类对象
		Class<? extends ReflectionTest> clazz1 = this.getClass();
		System.out.println(clazz1);

		// 方法三：通过全类名，创建Class类对象
		String className = "cn.imeixi.java.reflect.person.Student";
		Class<?> clazz2 = Class.forName(className);
		System.out.println(clazz2);
	}

}
