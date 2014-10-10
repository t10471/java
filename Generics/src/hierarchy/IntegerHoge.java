package hierarchy;

import wrapper.IntegerValueType;

public class IntegerHoge<V extends IntegerValue, T extends IntegerValueType>{}

//以下のように全部指定しなくても上の用にかける
//public class Hoge<
//X,
//V extends Value<X, V, T>,
//T extends ValueType<X, V, T>
//>{}