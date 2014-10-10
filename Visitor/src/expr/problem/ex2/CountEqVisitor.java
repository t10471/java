/**
 *
 */
package expr.problem.ex2;

import expr.problem.base.AddNode;
import expr.problem.base.NumberNode;
import expr.problem.base.SubNode;
import expr.problem.ex.ExVisitor;
import expr.problem.ex.MulNode;

/**
 *
 */
public abstract class CountEqVisitor<V extends ExVisitor<V, N>, N extends ExNode<V, N>> implements ExVisitor<V, N> {
    public CountEqVisitor(N aNode){
        mNode = aNode;
    }

    private int mCount = 0;
    private N mNode;

    private void count(N aCurrentNode){
        if(mNode.eq(aCurrentNode))
            mCount++;
    }

    @Override
    public void visit(AddNode<V, N> aNode) {
       count(aNode.getThis());
       aNode.getLeft().accept(getThis());
       aNode.getRight().accept(getThis());
    }

    @Override
    public void visit(SubNode<V, N> aNode) {
        count(aNode.getThis());
        aNode.getLeft().accept(getThis());
        aNode.getRight().accept(getThis());
    }

    @Override
    public void visit(NumberNode<V, N> aNode) {
        count(aNode.getThis());
    }

    @Override
    public void visit(MulNode<V, N> aNode) {
        count(aNode.getThis());
        aNode.getLeft().accept(getThis());
        aNode.getRight().accept(getThis());
    }

    public int calc(N aNode){
        mCount = 0;
        aNode.accept(getThis());

        return mCount;
    }
}
