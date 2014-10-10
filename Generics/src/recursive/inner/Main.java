package recursive.inner;


/**
 * HashMapのvalueの中身をkeyで指定できるようにする
 * @author tn
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	SimpleKeyValue kv = new SimpleKeyValue();
    	kv.put(SimpleKey.KEY_STRING, "test");
    	kv.put(SimpleKey.KEY_INTEGER, 2);
    	System.out.printf("key 1 %s\n", kv.get(SimpleKey.KEY_STRING));
    	System.out.printf("key 2 %d\n", kv.get(SimpleKey.KEY_INTEGER));

    	//Simpleの方はKeyのクラスがKeyValueにハードコーディングされているが
    	//こっちは分離されている
    	GroupKeyValue<Group1> gkv1 = new GroupKeyValue<Group1>();
    	gkv1.put(Group1.GROUP_STRING, "hoge");
    	gkv1.put(Group1.GROUP_INTEGER, 5);
    	System.out.printf("key 1 %s\n", gkv1.get(Group1.GROUP_STRING));
    	System.out.printf("key 2 %d\n", gkv1.get(Group1.GROUP_INTEGER));

    	GroupKeyValue<Group2> gkv2 = new GroupKeyValue<Group2>();
    	gkv2.put(Group2.GROUP_STRING, "hoge");
    	gkv2.put(Group2.GROUP_INTEGER, 5);
    	System.out.printf("key 1 %s\n", gkv2.get(Group2.GROUP_STRING));
    	System.out.printf("key 2 %d\n", gkv2.get(Group2.GROUP_INTEGER));

    }

}

