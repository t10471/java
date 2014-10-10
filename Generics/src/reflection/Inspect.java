package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Stack;

public class Inspect {

	//メソッドの型変数を調べる
	public static Type[] methodArgs(Class<?> clazz, String methodName, Class<?> args[]) throws Exception {
		Method m = clazz.getMethod(methodName, args);
		return m.getGenericParameterTypes();
	}

	/**
	 * 渡された型から継承階層を登って、 指定の親の型の指定の名前のジェネリクス型パラメータが 継承の過程で何型で具現化されているかを走査して返す。
	 *
	 * @param clazz
	 *            走査開始する型
	 * @param targetClass
	 *            走査する対象のジェネリクス型パラメータを持つ型。 走査開始型の親である必要がある。
	 * @param targetTypeName
	 *            何型で具現化されたを確認したい型パラメータのプレースホルダ名
	 * @return 具現化された型
	 */
	public static <T> Class<T> getGenericType(Class<?> clazz,
			Class<?> targetClass, String targetTypeName) {
		if (!targetClass.isAssignableFrom(clazz)) {
			throw new IllegalArgumentException("型" + clazz.getName() + "は、型"
					+ targetClass.getName() + "を継承していません");
		}
		Stack<Class<?>> stack = new Stack<Class<?>>();
		while (!targetClass.equals(clazz.getSuperclass())) {
			stack.push(clazz);
			clazz = clazz.getSuperclass();
		}
		return getGenericTypeImpl(clazz, targetTypeName, stack);
	}

	/**
	 * 型パラメータの具象型取得の実装。再帰処理される。
	 *
	 * @param clazz
	 *            現在の走査対象型
	 * @param targetTypeName
	 *            現在の走査対象のジェネリクス型パラメータ名
	 * @param stack
	 *            現在の走査対象型以下の継承階層が積まれたStack
	 * @return 該当型パラメータの具現化された型
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getGenericTypeImpl(Class<?> clazz,
			String targetTypeName, Stack<Class<?>> stack) {
		TypeVariable<? extends Class<?>>[] superGenTypeAray = clazz
				.getSuperclass().getTypeParameters();

		// 走査対象の型パラメータの名称(Tなど)から宣言のインデックスを取得
		int index = 0;
		boolean existFlag = false;
		for (TypeVariable<? extends Class<?>> type : superGenTypeAray) {
			if (targetTypeName.equals(type.getName())) {
				existFlag = true;
				break;
			}
			index++;
		}
		if (!existFlag) {
			throw new IllegalArgumentException(targetTypeName
					+ "に合致するジェネリクス型パラメータがみつかりません");
		}

		// 走査対象の型パラメータが何型とされているのかを取得
		ParameterizedType type = (ParameterizedType) clazz
				.getGenericSuperclass();
		Type y = type.getActualTypeArguments()[index];

		// 具象型で継承されている場合
		if (y instanceof Class) {
			System.out.println("Class");
			return (Class<T>) y;
		}
		// ジェネリックパラメータの場合
		if (y instanceof TypeVariable) {
			System.out.println("TypeVariable");
			TypeVariable<Class<?>> tv = (TypeVariable<Class<?>>) y;
			// 再帰して同名の型パラメータを継承階層を下りながら解決を試みる
			Class<?> sub = stack.pop();
			return getGenericTypeImpl(sub, tv.getName(), stack);
		}
		// ジェネリック型パラメータを持つ型の場合
		if (y instanceof ParameterizedType) {
			System.out.println("ParameterizedType");
			ParameterizedType pt = (ParameterizedType) y;
			return (Class<T>) pt.getRawType();
		}
		throw new IllegalArgumentException("予期せぬ型 : " + y.toString() + " ("
				+ y.getClass() + ")");
	}
}
