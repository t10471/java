package generics;

import java.util.ArrayList;

public class Main {
	private ArrayList<B> list = new ArrayList<B>();

	public static void main(String[] args) {
		ArrayList<? extends A> aExList = new ArrayList<B>();
		//エラー
		//aExList.add(new B());
		//null以外は代入不可
		aExList.add(null);
		A a = aExList.get(0);

		ArrayList<? super B> aSuList = new ArrayList<A>();
		aSuList.add(new B());
		aSuList.add(new C());
		aSuList.add(new C2());
		//なにかわからないから
		//Objectしか指定できない
		Object object = aSuList.get(0);

		Main m = new Main();
		m.add(new B());
		m.add(new B());
		m.add(new B());

		ArrayList<? extends A> list3 = m.getList();
		for(A  t : list3){
			System.out.println(t.toString());
		}

		//自分でキャストすることもできる
		@SuppressWarnings("unchecked")
		ArrayList<A> list = (ArrayList<A>) m.getList();
		for(A  t : list){
			System.out.println(t.toString());
		}

		@SuppressWarnings("unchecked")
		ArrayList<B> list2 = (ArrayList<B>) m.getList();
		for(B  t : list2){
			System.out.println(t.toString());
		}

	}

	public void add(B b){
		list.add(b);
	}

	/**
	 * listはB型だけどA型として返せる
	 * @return
	 */
	public ArrayList<? extends A> getList(){
		return list;

	}

}
