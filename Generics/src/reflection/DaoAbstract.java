
package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DaoAbstract<T> {
	@SuppressWarnings("unchecked")
	public T findById(String id) {
		try {
			// 実行時の型が取れる。ここではHogeDaoなど
			Class<?> clazz = this.getClass();
			// ここではBaseDao<Hoge>がとれる
			Type type = clazz.getGenericSuperclass();
			ParameterizedType pt = (ParameterizedType)type;
			// BaseDaoの型変数に対するバインドされた型がとれる
			Type[] actualTypeArguments = pt.getActualTypeArguments();
			Class<?> entityClass = (Class<?>)actualTypeArguments[0];
			System.out.printf("\n");
			System.out.printf("Class<?> clazz = this.getClass() => %s\n", clazz);
			System.out.printf("Type type = clazz.getGenericSuperclass() => %s\n", type);
			System.out.printf("ParameterizedType pt = (ParameterizedType)type => %s\n", pt);
			System.out.printf("Type[] actualTypeArguments = pt.getActualTypeArguments() => %s\n", actualTypeArguments);
			// リフレクションでインスタンスを生成
			return (T) entityClass.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
}