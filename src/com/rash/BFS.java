/*
Given an binary Tree Perform Level order traversal

     1
    / \
   0   3
  /\   / \
 4  5  2  7
 /
 8

output :: [[1], [0, 3], [4, 5, 2, 7], [8]]
*/

import java.util.*;

import org.postgresql.core.Query;

import com.mysql.cj.QueryBindings;
class BFS{
  static class TreeNode{
    int val;
    TreeNode left , right;
      TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
      }
  }


    public static List<List<Integer>> levelOrderTraversal(TreeNode root)
    {
      Stack<TreeNode> nodes =new Stack<TreeNode>();
      List<List<Integer>> result = new ArrayList<>();
      nodes.add(root);
      while(!nodes.isEmpty()){
        //List<Integer> list = new ArrayList<Integer>();
        /*TreeNode temp = nodes.poll();
        System.out.println(temp.val);
        if(temp.left!=null){
          nodes.add(temp.left);
        }
        if(temp.right!=null){
          nodes.add(temp.right);
        }*/
        List<Integer> list = new ArrayList<>();
        addToList(list, nodes);
        result.add(list);
      }
      return result;
    }

    public static void addToList(List<Integer> list, Stack<TreeNode> q){
      if(q.isEmpty())
      return;
      TreeNode node = q.pop();
      System.out.println(node.val);
      addToList(list, q);
      list.add(node.val);
      if(node.left!=null){
        q.add(node.left);
      }
      if(node.right!=null){
        q.add(node.right);
      }
    }


    public static void main(String[] args){
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(0);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(2);
      root.right.right = new TreeNode(7);
      root.left.left.left = new TreeNode(8);
      System.out.println(levelOrderTraversal(root));
    }
}


