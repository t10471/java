package expr.problem.ex;

import expr.problem.base.AddNode;
import expr.problem.base.NumberNode;
import expr.problem.base.SubNode;

/**
 * 継承で全体を拡張
 * @author tn
 *
 */
public class ExMain {

    private static interface Node extends expr.problem.base.BaseNode<Visitor, Node> {
    }

    private static interface Visitor extends ExVisitor<Visitor, Node> {
    }

    private static class Add extends AddNode<Visitor, Node> implements Node {
        public Add(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Sub extends SubNode<Visitor, Node> implements Node {
        public Sub(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Mul extends MulNode<Visitor, Node> implements Node {
        public Mul(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Number extends NumberNode<Visitor, Node> implements Node {
        public Number(int aValue) {
            super(aValue);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Calculator extends ExCalcVisitor<Visitor, Node> implements Visitor {
        @Override
        public Visitor getThis() {
            return this;
        }
    }

    private static class MakeString extends ExMakeStringVisitor<Visitor, Node> implements Visitor {
        @Override
        public Visitor getThis() {
            return this;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node tNode = new Sub(new Number(10), new Add(new Number(3), new Number(2)));
        tNode = new Mul(tNode, new Number(3));

        System.out.println(new MakeString().calc(tNode) + " = " + new Calculator().calc(tNode));
    }
}
