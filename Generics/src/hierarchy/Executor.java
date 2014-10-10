package hierarchy;

//基本
public interface Executor<I, O> {
	O exec(I in);
}