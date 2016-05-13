package cn.imeixi.java.reflect.proxy;

import java.util.HashMap;
import java.util.Map;

public class ServiceImpl implements Service {

	private static Map<Integer, People> peoples = new HashMap<Integer, People>();

	public static Map<Integer, People> getpeoples() {
		return peoples;
	}

	public ServiceImpl() {
		peoples.put(1001, new People(1001, "AAA"));
		peoples.put(1002, new People(1002, "BBB"));
	}

	@Override
	public void addNew(People people) {
		peoples.put(people.getId(), people);
	}

	@Override
	public void delete(Integer id) {
		peoples.remove(id);
	}

	@Override
	public void update(People people) {
		peoples.put(people.getId(), people);
	}

}
