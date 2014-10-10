package recursive;

public class Piyo2<P extends Piyo2<P>> extends Hoge<P> {
    public void hoge(P hoge) {
    	hoge.piyo2();
    }
    public void piyo2() {}
}