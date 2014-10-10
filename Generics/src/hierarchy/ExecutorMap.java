package hierarchy;

import java.util.Map;

//型変数を増やす例
public interface ExecutorMap<K, V, O> extends Executor<Map<K, V>, O> {}