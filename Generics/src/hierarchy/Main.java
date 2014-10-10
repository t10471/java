package hierarchy;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ExecutorImpl si = new ExecutorImpl();
		Executor<List<Integer>, Integer> ex = new ExecutorImpl();
		//Executorが継承による型変数の増減サンプル
		//Hogeが継承による型変数の境界の変更
		//Valueが継承時にきれいに書くサンプル

		System.out.println("public class CastB extends CastA<CastB> {}");
		CastB b = new CastB();
		try {
			CastB bb = b.getThis();
			System.out.printf("OK %s\n", bb.toString());
		} catch (ClassCastException e) {
			System.out.printf("NG CastB\n");
		}


		System.out.println("public class CastB2 extends CastA<CastB> {}");
		CastB2 b2 = new CastB2();
		try {
			CastB b2b = b2.getThis();
			System.out.printf("%s\n", b2b.toString());
		} catch (ClassCastException e) {
			System.out.printf("NG CastB2\n");
		}
		System.out.println("CastA<CastB>");
		CastA<CastB> ab = new CastA<CastB>();
		try {
			CastB abb = ab.getThis();
			System.out.printf("%s\n", abb.toString());
		} catch (ClassCastException e) {
			System.out.printf("NG CastA<CastB>\n");
		}

		System.out.println("public class CastB3 extends CastB {}");
		CastB3 b3 = new CastB3();
		try {
			CastB b3b = b3.getThis();
			//CastBを継承しているのでOK
			System.out.printf("OK %s\n", b3.toString());
		} catch (ClassCastException e) {
			System.out.printf("NG CastB3\n");
		}

		System.out.println("public class CastB4<T2 extends CastA<T2>> extends CastA<T2> {}");
		CastB4<CastB> b4b = new CastB4<CastB>();
		try {
			CastB b4bb = b4b.getThis();
			System.out.printf("%s\n", b4bb.toString());
		} catch (ClassCastException e) {
			System.out.printf("NG CastB4<CastB>\n");
		}

	}
}
