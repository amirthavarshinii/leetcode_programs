package Trees.lowestCommonAncesstor;

/**
 *https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 */
public class LCAbinarytree2 {
  boolean pFound = false;
  boolean qFound = false;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode result =   findLCA(root,p,q);
    if(pFound && qFound)
      return result;
    else
      return null;

  }

  public TreeNode findLCA(TreeNode root, TreeNode p , TreeNode q){

    if(root == null){
      return null;
    }

    if(root.val == p.val){
      pFound = true;
    }

    if(root.val == q.val){
      qFound = true;
    }

    TreeNode left = findLCA(root.left,p,q);
    TreeNode right = findLCA(root.right,p,q);
    if((left!= null && right != null)|| ( root.val == p.val|| root.val == q.val)){
      return root;
    }
    if(left == null){
      return right;
    }


    return left;


  }

}
