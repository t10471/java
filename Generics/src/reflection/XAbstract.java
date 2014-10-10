package reflection;

public class XAbstract<P, R, T extends XAbstract<P, R, T>> {
    private Class<T> clazzT;
	private Class<P> clazzP;
	private Class<R> clazzR;

	public XAbstract() {
		clazzT = Inspect.getGenericType(
			    getClass(), XAbstract.class, "T");
		clazzP = Inspect.getGenericType(
			    getClass(), XAbstract.class, "P");
		clazzR = Inspect.getGenericType(
			    getClass(), XAbstract.class, "R");
	}

    public Class<T> getT() {
        return clazzT;
    }
    public Class<P> getP() {
        return clazzP;
    }
    public Class<R> getR() {
        return clazzR;
    }

}