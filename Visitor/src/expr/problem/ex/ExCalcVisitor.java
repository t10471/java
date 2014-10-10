/**
 *
 */
package expr.problem.ex;

import expr.problem.base.BaseNode;
import expr.problem.base.CalcVisitor;

/**
 *
 */
public abstract class ExCalcVisitor<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends CalcVisitor<V, N> implements ExVisitor<V, N> {
    @Override
    public void visit(MulNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        mCalcStack.push(mCalcStack.pop() * mCalcStack.pop());
    }
}
