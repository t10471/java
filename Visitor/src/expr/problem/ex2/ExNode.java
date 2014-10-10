package expr.problem.ex2;

import expr.problem.base.BaseNode;
import expr.problem.ex.ExVisitor;

public interface ExNode<V extends ExVisitor<V, N>, N extends ExNode<V, N>> extends BaseNode<V, N> {
    public boolean eq(N aNode);
}
