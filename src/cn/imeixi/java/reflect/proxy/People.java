package cn.imeixi.java.reflect.proxy;

public class People {
	
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public People(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public People(){
		
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + "]";
	}
	
	

}
