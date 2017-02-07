package Trees;


public class ExpressionTree {

	static class Node {
		char data;
		Node left,right;
		public Node(char data){
			this.data = data;
			left = right = null;
		}
	}
	public static int calculate(int operand1 , int operand2, char operator){
		switch(operator){
			case '+' : return operand1 + operand2;
			case '-' : return operand1 - operand2;
			case '*' : return operand1 * operand2;
			case '/' : return operand1 / operand2;
		}	
		return 0;
	}
	public static int Evaluate(Node root){
		if(root == null){
			return 0;
		}else if(root.left == null && root.right == null){
			return Character.getNumericValue(root.data);
		}else{
			int leftCal = Evaluate(root.left);
			int rightCal = 	Evaluate(root.right);	
			
			return calculate(leftCal,rightCal,root.data);
		}
	}
	public static void main(String[] arg){
		 Node root1 = new Node('+');
		 root1.left = new Node('3');
		 root1.right = new Node('*');
		 root1.right.left = new Node('+');
		 root1.right.right = new Node('2');
		 root1.right.left.left = new Node('5');
		 root1.right.left.right = new Node('9');
		 
		 System.out.println(Evaluate(root1));
	}
	
}
