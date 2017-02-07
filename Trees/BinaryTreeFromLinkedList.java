package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.areIdentical.Node;

public class BinaryTreeFromLinkedList {
	static class Lnode{
		int data;
		Lnode next;
		public Lnode(int data){
			this.data = data;
			next = null;
		}
	}
	static class LinkedList{
		Lnode head;
		public void add(int data){
			if(head == null){
				head = new Lnode(data);
			}else{
				Lnode curr = head;
				while(curr.next != null){
					curr = curr.next;
				}
				curr.next = new Lnode(data);
			}
		}
	}
	public static Node getTree(Lnode head){
		if(head == null){
			return null;
		}else{
			Node curr_tree_elem ,root;
			Lnode curr_ll_elem = head;
			curr_tree_elem = root= new Node(head.data);
			
			Queue<Node> q = new java.util.LinkedList<Node>();
			q.add(root);
			while(curr_ll_elem != null && !q.isEmpty()){
				curr_tree_elem = q.remove();
				if(curr_ll_elem.next != null){
					curr_tree_elem.left =  new Node(curr_ll_elem.next.data);
					q.add(curr_tree_elem.left);
					if(curr_ll_elem.next.next != null){
						curr_tree_elem.right = new Node(curr_ll_elem.next.next.data);
						q.add(curr_tree_elem.right);
					}
					curr_ll_elem = curr_ll_elem.next.next;
				}else{
					curr_ll_elem = curr_ll_elem.next;
				}
			}
			return root;
		}
	}
	public static void inOrder(Node root){
		if(root == null){
			return; 
		}else{
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	public static void main(String[] arg){
		LinkedList nodes = new LinkedList();
	    nodes.add(10);
	    nodes.add(12);
	    nodes.add(15);
	    nodes.add(25);
	    nodes.add(30);
	    nodes.add(36);
	    Node root = getTree(nodes.head);
	    inOrder(root);
	}
}
