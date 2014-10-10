package reflection;

import java.lang.reflect.Type;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Type[] types = Inspect.methodArgs(Main.class, "hoge", new Class[] { List.class });
		for (Type type : types) {
			System.out.println(type);
		}
		Type[] type2s = Inspect.methodArgs(Main.class, "hoge2", new Class[] { List.class, String.class, List.class });
		for (Type type : type2s) {
			System.out.println(type);
		}

		{
			System.out.println("C A start");
			Class<?> clazz = Inspect.getGenericType(C.class, A.class, "X");
			System.out.println(clazz);
			System.out.println("C B start");
			Class<?> clazz2 = Inspect.getGenericType(C.class, B.class, "Y");
			System.out.println(clazz2);

			System.out.printf("M Type %s\n", (new M<Integer>()).getType());

			System.out.println("XConstruct");
			XConstruct x = new XConstruct();
			System.out.println(x.getT());
			System.out.println(x.getP());
			System.out.println(x.getR());

			System.out.println("YC YA start");
			Class<?> yca = Inspect.getGenericType(YC.class, YA.class, "T");
			System.out.println(yca);

			System.out.println("YC YB start");
			Class<?> ycb = Inspect.getGenericType(YC.class, YB.class, "P");
			System.out.println(ycb);

			DaoConstruct d = new DaoConstruct();
			Construct c = d.findById("aa");
			System.out.println(c);
		}
	}

	public void hoge(List<String> list) {
	}

	public void hoge2(List<String> list, String a, List<Integer> list2) {
	}

}
