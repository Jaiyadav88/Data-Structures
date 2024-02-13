import java.util.*;

//implementation of huffman encoding
/*
 * Author:Jai Yadav
 */
class Node implements Comparable<Node> {
  char ch;
  Node left, right;
  int f;

  public Node(char ch, int f, Node left, Node right) {
    this.ch = ch;
    this.left = left;
    this.right = right;
    this.f = f;
  }

  public int compareTo(Node n) {
    return this.f - n.f;
  }
}

public class huffman_encoding {
  public static void main(String[] args) {
    ArrayList<Character> al = new ArrayList<>();
    al.add('a');
    al.add('d');
    al.add('b');
    al.add('e');
    al.add('f');
    ArrayList<Integer> freq = new ArrayList<>();
    freq.add(10);
    freq.add(50);
    freq.add(20);
    freq.add(40);
    freq.add(80);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < al.size(); i++)
      pq.offer(new Node(al.get(i), freq.get(i), null, null));
    while (pq.size() > 1) {
      Node a = pq.poll();
      Node b = pq.poll();
      Node temp = new Node('$', a.f + b.f, null, null);
      temp.left = a;
      temp.right = b;
      pq.offer(temp);
    }
    printcode(pq.poll(), "");

  }

  public static void printcode(Node root, String s) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      System.err.println(root.ch + " " + s);
      return;
    }
    printcode(root.left, s + "0");
    printcode(root.right, s + "1");
  }
}

