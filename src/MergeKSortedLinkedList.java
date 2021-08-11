/*
*Merge K sorted linked list
Description
You will be given a K sorted linked lists, and you have to merge these linked lists into one linked list
* such that the resultant linked list is also sorted. Note that all the k linked lists are of the same size.

Input: The input will be in the following format:

The first line will be an integer ‘n’, which represents the number of lists.
The next line will be an integer ‘k’, which represents the size of the list.
The next line will be the ‘nk’ number of integers, which represents the data of the nodes of the linked lists.

Output: The output should be in the following format:

A single line containing all the nodes of the merged linked list, separated by a single space.

Sample Test case:

Input:

3
4
4 5 7 8 1 2 10 11 0 3 6 9

Output:

0 1 2 3 4 5 6 7 8 9 10 11
*  */
import java.util.*;
public class MergeKSortedLinkedList {
    //creates a new node with the given 'data' and returns that node
    Node newNode (int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;

        return newNode;
    }

    // Driver program to test above
    public static void main(String args[]) {

        //array list whose each element is the head of each linked list
        ArrayList<Node> arr = new ArrayList<>();
        MergeKSortedLinkedList obj = new MergeKSortedLinkedList();

        Scanner in = new Scanner(System.in);

        // Number of linked lists
        int k = in.nextInt();

        // Number of elements in each linked list
        int n = in.nextInt();

        Node tmp = null;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {

                //head node of the linked list
                if (j == 0) {
                    int dt = in.nextInt();
                    arr.add(obj.newNode (dt));
                } else {
                    int dt = in.nextInt();
                    tmp = arr.get(i);
                    for (int m = 1; m < j; m++) {
                        tmp = tmp.next;
                    }
                    tmp.next = obj.newNode (dt);
                }
            }
        }
        //write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>(k,new NodeComparator());
        for(int i=0;i<k;i++){
            pq.add(arr.get(i));
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        for(int i=0;i<n*k;i++){
            Node temp = pq.peek();
            System.out.print(temp.data+" ");
            linkedList.add(pq.poll());
            if(temp.next!=null)
                pq.add(temp.next);
        }
    }
}
class Node{
    int data;
    Node next;
}
class NodeComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.data - y.data;
    }
}
