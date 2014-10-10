package datastructures2;

import java.util.ArrayList;

import functions.Function1;
import functions.Function1Void;
import functions.Function2;
import generics.A;
import generics.B;

public class ListModule {
	public static interface List<T> {

		public abstract T head();

		public abstract List<T> tail();

		public abstract boolean isEmpty();

		public List<T> filter(Function1<T, Boolean> f);

		public <T2> List<T2> map(Function1<T, T2> f);

		public <T2> T2 foldLeft(T2 seed, Function2<T2, T, T2> f);

		public <T2> T2 foldRight(T2 seed, Function2<T, T2, T2> f);

		public void foreach(Function1Void<T> f);
	}

	public static final class NonEmptyList<T> implements List<T> {

		public T head() {
			return _head;
		}

		public List<T> tail() {
			return _tail;
		}

		public boolean isEmpty() {
			return false;
		}

		protected NonEmptyList(T head, List<T> tail) {
			this._head = head;
			this._tail = tail;
		}

		private final T _head;
		private final List<T> _tail;

		public List<T> filter(Function1<T, Boolean> f) {
			if (f.apply(head())) {
				return list(head(), tail().filter(f));
			} else {
				return tail().filter(f);
			}
		}

		public <T2> List<T2> map(Function1<T, T2> f) {
			return list(f.apply(head()), tail().map(f));
		}

		public <T2> T2 foldLeft(T2 seed, Function2<T2, T, T2> f) {
			return tail().foldLeft(f.apply(seed, head()), f);
		}

		public <T2> T2 foldRight(T2 seed, Function2<T, T2, T2> f) {
			return f.apply(head(), tail().foldRight(seed, f));
		}

		public void foreach(Function1Void<T> f) {
			f.apply(head());
			tail().foreach(f);
		}

		@Override
		public boolean equals(Object other) {
			if (other == null || getClass() != other.getClass())
				return false;
			List<?> that = (List<?>) other;
			return head().equals(that.head()) && tail().equals(that.tail());
		}

		@Override
		public int hashCode() {
			return 37 * (head().hashCode() + tail().hashCode());
		}

		@Override
		public String toString() {
			return "(" + head() + ", " + tail() + ")";
		}
	}

	public static class EmptyListHasNoHead extends RuntimeException {
	}

	public static class EmptyListHasNoTail extends RuntimeException {
	}

	/**
	 * empty listは常に同じものだから、singletonで実装している
	 */
	public static final List<? extends Object> EMPTY = new List<Object>() {

		public Object head() {
			throw new EmptyListHasNoHead();
		}

		public List<Object> tail() {
			throw new EmptyListHasNoTail();
		}

		public boolean isEmpty() {
			return true;
		}

		public List<Object> filter(Function1<Object, Boolean> f) {
			return this;
		}

		public <T2> List<T2> map(Function1<Object, T2> f) {
			return emptyList();
		}

		public <T2> T2 foldLeft(T2 seed, Function2<T2, Object, T2> f) {
			return seed;
		}

		public <T2> T2 foldRight(T2 seed, Function2<Object, T2, T2> f) {
			return seed;
		}

		public void foreach(Function1Void<Object> f) {
		}

		@Override
		public String toString() {
			return "()";
		}
	};

	/**
	 * staticの後の<T>は型引数というメソッド内での共通の型 実際はコンパイル時objectに変換されて、実行時にキャストされる
	 * 宣言時はTにObjectを指定していたが、使用時はTにキャストしている javaではジェネリクスに共変はつかえない 普通の戻り値には使える
	 * 戻り値がSuperのものをorverrideしてSubとしてもOK
	 *
	 * @return List<T>
	 */
	@SuppressWarnings(value = "unchecked")
	public static <T> List<T> emptyList() {
		return (List<T>) EMPTY; // 危険!?
	}

	public static <T> List<T> list(T head, List<T> tail) {
		return new NonEmptyList<T>(head, tail);
	}

	void a() {
		ArrayList<? extends A> aExList = new ArrayList<B>();
	}
}
