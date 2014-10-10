package recursive.inner;

import java.util.HashMap;
import java.util.Map;

public class GroupKeyValue<KG extends GroupKey<KG>> {
	Map<GroupKey<?>.Key<?>, Object> map = new HashMap<GroupKey<?>.Key<?>, Object>();

	public <T> void put(GroupKey<KG>.Key<T> key, T value){
		map.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(GroupKey<KG>.Key<T> key){
		return (T)map.get(key);
	}

}

