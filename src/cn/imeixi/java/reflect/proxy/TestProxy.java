package cn.imeixi.java.reflect.proxy;

import org.junit.Test;

public class TestProxy {

	@Test
	public void TestProxy() {

		Service target = new ServiceImpl();

		System.out.println(ServiceImpl.getpeoples());
		
		Service proxy = new PeopleServiceProxy(target).getPeopleServiceProxy();

		proxy.addNew(new People(1003, "CCC"));

		System.out.println(ServiceImpl.getpeoples());
		
		proxy.update(new People(1003, "DDE"));

		System.out.println(ServiceImpl.getpeoples());
		
		proxy.delete(1002);

		System.out.println(ServiceImpl.getpeoples());

	}

}
