// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Tree {
    static class Node{
        String data;
        Node left;
        Node right;
        Node(String data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Node root = new Node("+");
        Node left = new Node("a");
        Node right = new Node("b");
        root.left= left;
        root.right= right;
        preOrder(root);System.out.println();
        postOrder(root);System.out.println();
        inOrder(root);
    }
    
    public static void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public static void postOrder(Node node){
        if(node==null) return;
        
        preOrder(node.left);
        System.out.print(node.data);
        preOrder(node.right);
    }
    
    public static void inOrder(Node node){
        if(node==null) return;
        
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data);
    }
}
