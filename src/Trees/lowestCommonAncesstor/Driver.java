package Trees.lowestCommonAncesstor;


public class Driver {
 public static void main(String args[]){
  TreeNode root = new TreeNode(3);
  TreeNode p = new TreeNode(5);
  root.left = p; // storing the reference to create the p tree node
   TreeNode q = new TreeNode(1);
   root.right = q;
  root.left.left = new TreeNode(6);
  root.left.right = new TreeNode(2);
  root.left.right.left  = new TreeNode(7);
  root.left.right.right = new TreeNode(4);
  root.right.left = new TreeNode(0);
  root.right.right = new TreeNode(8);
  System.out.println(LCAOfBinaryTree.lowestCommonAncestor(root,p,q).val);

 }
}
