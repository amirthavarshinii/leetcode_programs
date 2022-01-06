package Trees.smallestsubtreewithdeepestnodes;

/**
 * 865. Smallest Subtree with all the Deepest Nodes.
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 *
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 *
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
 */
public class SubtreeWithDeepestNodes {
  public static TreeNode subtreeWithAllDeepest(TreeNode root) {
    return findSmallestSubtreeWithDeepestNodes(root).node;
  }
  /* what we are going to do here is that we want to return the smallest subtree with the deepest nodes
    right ? earlier what we did is we traversed over the entire tree to find out what is the maximum depth
    and stored each node with their respective depth, so when we encountered null, we checked if that level
    is the deepest , if its we got that node and returned it or else we returned just null,
    so there can be only two possibilities either that by itself is the deepest node or that has an
    ancestor that is the deepest node so to find ancestor the left and right has to be not null,
    in that case two nodes are forming the maximum depth, so its ancestor has to be returned.

    the next method here what we are trying is that we are trying to avoid this two traversals
    how can we do that in one traversal ??


   */

  public static Result findSmallestSubtreeWithDeepestNodes(TreeNode root){
    if(root == null){
      return new Result(0,null);
    }
    Result left = findSmallestSubtreeWithDeepestNodes(root.left);
    Result right = findSmallestSubtreeWithDeepestNodes(root.right);
    if(left.dist > right.dist)
      return new Result(left.dist+1, left.node);
    if(right.dist > left.dist)
      return new Result(right.dist+1, right.node);

    return new Result(left.dist +1 , root);
  }

  public static void main(String args[]){
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left  = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    System.out.println(subtreeWithAllDeepest(root).val);
  }
}
