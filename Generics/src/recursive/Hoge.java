package recursive;

import java.util.List;

public class Hoge<T extends Hoge<T>> {
    public void hoge(T hoge) {
		System.out.println(hoge.toString());
    }

    public void loop(List<T> list) {
        for (T hoge : list) {
            hoge.hoge(hoge);
        }
    }
}