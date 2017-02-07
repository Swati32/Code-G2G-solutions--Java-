package LinkedList;

public class IdenticalList {
	public static boolean isIdentical(Node list1node,Node list2node){
		if(list1node == null && list2node == null){
			return true;
		}if(list1node == null && list2node!= null){
			return false;
		}else if(list1node != null && list2node == null ){
		    return false;
		}else{
			if(list1node.data != list2node.data){
				return false;
			}else{
				return isIdentical(list1node.next,list2node.next);
			}
		}
	}
     
	
	   public static void main(String[] arg){
				LinkedList llist1 = new LinkedList();
				llist1.insert(23);
				llist1.insert(6);
				llist1.insert(52);
				llist1.insert(5);
				llist1.insert(13);
				llist1.insert(9);
				llist1.insert(2);
				
				
				
				LinkedList llist2 = new LinkedList();
				llist2.insert(23);
				llist2.insert(6);
				llist2.insert(51);
				llist2.insert(5);
				llist2.insert(13);
				llist2.insert(9);
				llist2.insert(2);
				
				
				System.out.println(isIdentical(llist1.head,llist2.head));
				
			
		}
}
