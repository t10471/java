package expr.problem.ex;

import expr.problem.base.BaseNode;
import expr.problem.base.LeftRightNode;

public abstract class MulNode<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends LeftRightNode<V, N> {
    public MulNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }

    @Override
    public abstract N getThis();

    @Override
    public void accept(V aVisitor) {
        aVisitor.visit(this);
    }
}
