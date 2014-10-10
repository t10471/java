package hierarchy;

import java.util.List;

//単なるExecutorを実装した例
public class ExecutorImpl implements Executor<List<Integer>, Integer>{
	public Integer exec(List<Integer> in) {
		int ret = 0;
		for (int value : in) {
			ret += value;
		}
		return ret;
	}
}