package expr.problem.ex;

import expr.problem.base.BaseNode;
import expr.problem.base.BaseVisitor;

public interface ExVisitor<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends BaseVisitor<V, N> {
    public void visit(MulNode<V, N> aNode);
}
