package LinkedList; 
import java.util.Scanner;
 
// Linked List node
class NodeString
{
    String data;
    NodeString next;
 
    NodeString(String d)
    {
        data = d;
        next = null;
    }
}
 
class LinkedListStringPalindrome
{
	NodeString head;
 
  
    boolean isPalidromeUtil(String str)
    {
        int length = str.length();
 
        for (int i=0; i<length; i++)
            if (str.charAt(i) != str.charAt(length-i-1))
                return false;
 
        return true;
    }

    boolean isPalindrome()
    {
    	NodeString node = head;
        String str = "";
        while (node != null)
        {
            str = str.concat(node.data);
            node = node.next;
        }
 
        return isPalidromeUtil(str);
    }
 
    /* Driver program to test above function*/
    public static void main(String[] args)
    {
    	LinkedListStringPalindrome list = new LinkedListStringPalindrome();
        list.head = new NodeString("a");
        list.head.next = new NodeString("bc");
        list.head.next.next = new NodeString("d");
        list.head.next.next.next = new NodeString("dcb");
        list.head.next.next.next.next = new NodeString("a");
 
        System.out.println(list.isPalindrome());
 
    }
}