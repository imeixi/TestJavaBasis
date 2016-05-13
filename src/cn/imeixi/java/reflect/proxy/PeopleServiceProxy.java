package cn.imeixi.java.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy 代理类只针对接口，接口类的实现类通过代理对象进行代理。
 * 
 * @author perfermance
 *
 */
public class PeopleServiceProxy {

	private Service target = null;

	public PeopleServiceProxy(Service target) {
		this.target = target;
	}

	public Service getPeopleServiceProxy(){
		
		Service proxy = (Service) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("开始事务");
				
				try {
					Object result = method.invoke(target, args);
					System.out.println("提交事务");
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("回滚事务");
				}
				return null;
			}
		});
		
		return proxy;
	}
}
