package reflection;

//newした時の型変数を調べる
public class M<E> {
    private Class<E> type;

    public M(E... e) {
        @SuppressWarnings("unchecked")
        Class<E> type = (Class<E>) e.getClass().getComponentType();
        this.type = type;
    }

    public Class<E> getType() {
        return type;
    }
}