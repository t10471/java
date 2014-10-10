package recursive.inner;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapでvalueの中身をkeyで指定する
 * @author tn
 *
 */
public class SimpleKeyValue {
	Map<SimpleKey<?>, Object> map = new HashMap<SimpleKey<?>, Object>();
	public <T> void put(SimpleKey<T> key, T value){
		map.put(key, value);
	}
	@SuppressWarnings("unchecked")
	public <T> T get(SimpleKey<T> key){
		return (T)map.get(key);
	}

}

