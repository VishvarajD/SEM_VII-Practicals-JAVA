//Steps
// 1.input arrays
// 2.create a min priority queue
// 3.add Obj to queue
// 4.then add parent to pq 
// 5.then print Nodes


import java.util.PriorityQueue;


public class HuffmanEncoding {
    static class Node{
        char ch;
        int freq;
        Node left , right;
        Node(char ch , int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    static void printNodes(Node root , String code){
        if(root.left == null && root.right == null) {
            System.out.println(root.ch + " " + code);
            return;
        }
        printNodes(root.left, code + '0');
        printNodes(root.right, code + '1');
    }
    public static void main(String[] args) {
         char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);

        for(int i = 0 ;i < chars.length; i++){
            pq.add(new Node(chars[i],freq[i]));
        }
        while(pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('-',left.freq+right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        printNodes(pq.peek(),"");
    }
   
}
//time Complexity per operation => O(logn)
//Total time Complexity => O(nlogn)
//space Complexity =>  O(n) priority Queue
