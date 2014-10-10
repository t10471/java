package recursive;


public class Main {
	public class Foo<X extends Hoge<X>> {}
	//ジェネリクスの型を取得
	public class Foo2<X extends Hoge<?>> {
		private Class<X> type;
	    public Foo2(X... e) {
	        @SuppressWarnings("unchecked")
	        Class<X> type = (Class<X>) e.getClass().getComponentType();
	        this.type = type;
	    }

	    public Class<X> getType() {
	        return type;
	    }

		public String toString() {
			return  super.toString() + " " + getType().toString();
		}
	}
	public class Foo3<X extends Hoge<? super X>> {}

	public static void main(String[] args) {
//		継承関係
//		Hoge
//		├ Piyo - Fuga
//		└ Piyo2 - Fuga2
//

		Hoge<Piyo> hoge = new Hoge<Piyo>();
		Piyo piyo = new Piyo();
		System.out.println(hoge.toString());
		System.out.println(piyo.toString());
		//hoge.hoge(hoge); //NG
		hoge.hoge(piyo);
		piyo.hoge(piyo);


		Main m = new Main();
//		Foo<Hoge<Piyo>> fooPiyo = m.new Foo<Hoge<Piyo>>(); // NG
		Foo<Piyo> fooPiyo = m.new Foo<Piyo>(); // OK
//		Foo<Fuga extends Hoge<Piyo>>になっているのでNG
//		Foo<Fuga> fooFuga; // NG
//		Foo<Piyo2 extends P(extends Piyo2)>になっているのでNG
//		Foo<Piyo2> fooPiyo2; // NG
		Foo<Fuga2> fooFuga2 = m.new Foo<Fuga2>();  // OK

		Foo2<Piyo> foo2Piyo; // OK
		Foo2<Fuga> foo2Fuga; // OK
		@SuppressWarnings("rawtypes")
		Foo2<Piyo2> foo2Piyo2 = m.new Foo2<Piyo2>(); // OK
		System.out.println(foo2Piyo2.toString());
		Foo2<Fuga2> foo2Fuga2; // OK
//		EvilPiyo extends Hoge<Piyo>の再帰になっていないのもOKになってし.まう
		Foo2<EvilPiyo> foo2Evil; //OK

//		Piyo                      extends Hoge<Piyo>   -> Foo3<Piyo                      extends Piyo>
//		Fuga                      extends Piyo         -> Foo3<Fuga                      extends Piyo>
//		Fuga2                     extends Piyo2<Fuga2> -> Foo3<Fuga2                     extends Fuga2>
//		Piyo2<P extends Piyo2<P>> extends Hoge<P>      -> Foo3<Piyo2<P extends Piyo2<P>> extends P>


		Foo3<Piyo> foo3Piyo; // OK
		Foo3<Fuga> foo3Fuga; // OK
//		Foo3<P extends Piyo2<P>> extends Hoge<P>
//		継承しているか分からないからNG
//		Foo3<Piyo2> foo3Piyo2; // NG
		Foo3<Fuga2> foo3Fuga2; // OK
//		Foo3<EvilPiyo> foo3Epiyo; // NG
	}

}
