package cn.imeixi.java.reflect.generictype;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DAO <T>{
	
	private Class<T> clazz;
	
	public DAO(){
		
		System.out.println(this.getClass());
		System.out.println(this.getClass().getSuperclass());
		
		Type superType = this.getClass().getGenericSuperclass();
		System.out.println(superType);
		
		if(superType instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) superType; 
			
			Type [] args = parameterizedType.getActualTypeArguments();
			
			if(args != null && args.length > 0){
				Type arg = args[0];
				
				if(arg instanceof Class){
					clazz = (Class<T>) arg;
				}
			}
		}
		
		
	}
	
	public void save(T entity){
		
	}
	
	public T get(Integer id){
		System.out.println(clazz);
		return null;
	}

}
