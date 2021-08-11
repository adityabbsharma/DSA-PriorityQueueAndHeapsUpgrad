/*
*Priority Queue ADT
Description
You are given an array containing some integers. Your job is to find the smallest element in the array and then remove the top ‘M’ smallest elements from the array. You are given an incomplete code, which will solve the problem using the inbuilt Priority Queue class in Java.



Input:

           1. The first line contains ‘N’ (the number of elements in the array).

           2.  The second line contains a positive integer ‘M’.

           3.  The following ‘N’ lines contain the elements of the array.



Output:

            1. The first line gives the smallest element of the array.

            2.  The next M lines give the elements that are being removed.

            3.  The remaining lines give the remaining elements in the priority queue.





Sample input-1:

5

3

-31

4

43

0

10



Sample output-1:

-31

-31

0

4

10

43



Explanation:

Initially, the minimum element is ‘-31’; so, ‘-31’ is printed.

Next, poll() is implemented thrice. First, ‘-31’ is printed and removed. Then, 0 is printed and removed, followed by 4, which is printed and removed. Now, the remaining elements in the priority queue are printed in the increasing order; 10 is printed first, and 43 is printed last.





Sample input-2:

6

7

-31

7

-8

14

9

32

Sample output-2:

-31

-31

-8

7

9

14

32

null



Explanation:

Initially, the minimum element is ‘-31’; so, ‘-31’ is printed.

Next, poll() is implemented thrice. First, ‘-31’ is printed and removed; then, -8 is printed and removed, and after that, 7 is printed and removed, and so on until the last element is printed and removed. Here M>N, null is printed, as the last element to be removed as the array is empty.
*  */
import java.util.*;
public class SmallestElementsInArray {
    public static void PQimplement(int[] arr, int M){

        // It creates a priority queue and inserts all array elements
        // into the priority queue.
        PriorityQueue<Integer> priorqueue = new PriorityQueue<>();
        for (int x : arr){
            //Write the code here to add element in priority queue
            priorqueue.add(x);
        }

        //Write the code here to print smallest element
        System.out.println(priorqueue.peek());

        while (M-- > 0){

            //Write the code here to print top M elements which are going to be removed.
            System.out.println(priorqueue.poll());

        }
        //int size= priorqueue.size();
        Iterator itr=priorqueue.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }


    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int arr[] = getArrayInput(N, scanner);
        PQimplement(arr, M);
    }
}
