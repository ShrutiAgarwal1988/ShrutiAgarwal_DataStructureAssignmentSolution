
import java.io.*;
class Node
{
    int value;
    Node left, right;
    
    
    Node(int item)
    {
        value = item;
        left = null;
        right = null;
    }
}
class RightSkewedTree
{
    public static Node node;
    static Node prNode = null;
    static Node hdNode = null;
   
    static void Skewed(Node root,int od)
    {
       
        
        if(root == null)
        {
            return;
        }
       
        
        if(od > 0)
        {
            Skewed(root.right, od);
        }
        else
        {
            Skewed(root.left, od);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        
        if(hdNode == null)
        {
            hdNode = root;
            root.left = null;
            prNode = root;
        }
        else
        {
            prNode.right = root;
            root.left = null;
            prNode = root;
        }
       
        
        if (od > 0)
        {
           Skewed(leftNode, od);
        }
        else
        {
            Skewed(rightNode, od);
        }
    }
   
    
    static void traversetoRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.value + " ");
        traversetoRightSkewed(root.right);       
    }
   
    
    public static void main (String[] args)
    {
       
        RightSkewedTree tree = new RightSkewedTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);
        int od = 0;
        Skewed(node, od);
        traversetoRightSkewed(hdNode);
    }
}