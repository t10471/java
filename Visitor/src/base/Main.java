package base;

/**
 * 基本的なVisitorパターン
 * Visitorパターンはダブルディスパッチで
 * 2つのswitchを解消することができる
 * ただし、拡張性は乏しい
 * @author tn
 *
 */
public class Main {
	static public void main(String[] args) {
		Car car = new Car();
		Visitor printVisitor = new PrintVisitor();
		Visitor doVisitor = new DoVisitor();
		car.accept(printVisitor);
		car.accept(doVisitor);
	}
}