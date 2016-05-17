package cn.imeixi.java.reflect.generictype;

import org.junit.Test;

public class TestReflectGeneric {
	
	@Test
	public void testGenericAndReflect(){
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = new Customer();
		
		customerDAO.save(customer);
		
		customerDAO.get(1);
	}

}
