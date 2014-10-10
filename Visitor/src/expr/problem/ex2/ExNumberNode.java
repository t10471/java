/**
 *
 */
package expr.problem.ex2;

import expr.problem.base.NumberNode;
import expr.problem.ex.ExVisitor;

/**
 *
 */
public abstract class ExNumberNode<V extends ExVisitor<V, N>, N extends ExNode<V, N>> extends NumberNode<V, N> implements ExNode<V, N> {
    public ExNumberNode(int aValue) {
        super(aValue);
    }

    @Override
    public boolean eq(N aNode) {
        if(!aNode.getClass().equals(this.getClass()))
            return false;

        return this.getValue() == ((ExNumberNode<V, N>)aNode).getValue();
    }
}
