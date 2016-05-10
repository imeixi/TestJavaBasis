package cn.imeixi.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void TestMethods() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		//创建Class对象的三种方法
		//方法一：类名.class
		Class<Person> clazz = Person.class;
		System.out.println(clazz);
		
		//方法二：this.getClass();返回当前对象的Class类对象
		Class<? extends TestReflection> clazz1 = this.getClass();
		System.out.println(clazz1);
		
		//方法三：通过全类名，创建Class类对象
		String className = "cn.imeixi.java.reflect.Person";
		Class<?> clazz2 = Class.forName(className);
		System.out.println(clazz2);
		
//		获取反射类的方法   getMethods()获取所有方法
		Method[] methods = clazz2.getMethods();
		for(Method method:methods){
			System.out.println(method.getName());
		}
		
		System.out.println();
		
//		获取反射类的方法   getDeclaredMethods()获取当前对象中的所有方法
		methods = clazz2.getDeclaredMethods();
		for(Method method:methods){
			System.out.println(method.getName());
		}
		
		Method method = clazz.getDeclaredMethod("setName", String.class);
		Field field = clazz.getDeclaredField("name");
		
		Object obj = clazz.newInstance();
		method.setAccessible(true);
		method.invoke(obj, "imeixi");
		field.setAccessible(true);
		System.out.println("name:" + field.get(obj));
		
	}
	
	@Test
	public void TestGeneric() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		String className = "cn.imeixi.java.reflect.Student";
		Class clazz = Class.forName(className);

		
		Method method = getMethod(clazz, "setName", "imeixi111");
		Field field = getField(clazz, "name");
		
		Object obj = clazz.newInstance();
		method.setAccessible(true);
		method.invoke(obj, "imeixi1111");
		field.setAccessible(true);
		System.out.println("name:" + field.get(obj));
		
	}
	
	/**
	 * 
	 * @param clazz
	 * @param methodName
	 * @param args
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Method getMethod(Class clazz,String methodName,Object ... args) throws ClassNotFoundException  {
		
		Method method = null;

		Class[] parameterTypes = new Class[args.length];
		for(int i = 0;i < args.length;i++){
			parameterTypes[i] = args[i].getClass();
		}
		
		for(;clazz != Object.class; clazz = clazz.getSuperclass()){
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
			} catch (Exception e) {} 
		}
		
		return method;
	}
	
	public Field getField(Class clazz,String fieldName) throws ClassNotFoundException  {
		
		Field field = null;

		for(;clazz != Object.class; clazz = clazz.getSuperclass()){
			try {
				field = clazz.getDeclaredField(fieldName);
			} catch (Exception e) {} 
		}
		
		return field;
	}
}
