package Trees.lowestCommonAncesstor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Similar to finding lca of binary search tree.
 * but this is finding lca of binary tree.
 * in which the lca of binary search tree can be done in O(log n) complexity because
 * once p and q are both lesser than a node value, we will be not going to the entire
 * left subtree at all. But in the case of finding lca for binary tree we cant do such
 * optimizations.
 *https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LCAOfBinaryTree {

  private  Map<TreeNode, TreeNode> parentMap;
  private Deque<TreeNode> stack ;
  private Set<TreeNode> ancestors ;

  /**
   * Recursive approach of finding lca
   * @param root root of the node.
   * @param p p node.
   * @param q q node.
   * @return the lca of p and q.
   */

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(root == null){
      return null;
    }

    if(root == p || root == q){
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);
    if(left != null && right != null){
      return root;
    }else if(left == null){
      return right;
    }else{
      return left;
    }
  }


  public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q){
    parentMap = new HashMap<>();
    stack = new ArrayDeque<>();
    ancestors = new HashSet<>();

    parentMap.put(root,null);
    stack.add(root);
    // until we haven't found one of the parents continue the operation of the while loop.
    while(!parentMap.containsKey(p) ||! parentMap.containsKey(q)){
      TreeNode current = stack.pop();
      // in iterative methods you can't return when the node is null or something so what you have to do is
      // before even proceeding you have to check if its null or not and then proceed.
      if(current.left != null){
        parentMap.put(current.left,current);
        stack.add(current.left);
      }
      if(current.right != null){
        parentMap.put(current.right,current);
        stack.add(current.right);
      }
    }
    // putting all the ancestors of p node in the set.
    TreeNode parent = p;
     while( parent!= null){
       ancestors.add(parent);
       parent =  parentMap.get(parent);
     }
     parent = q;
     while(!ancestors.contains(parent)){
       parent = parentMap.get(parent);
     }
     return parent;
  }
}
