package examples.topic1;
import libraries.dataStructures.linear.*;
import libraries.dataStructures.models.*;
public class TestEDAQueue {
  public static void main(String[] args) {      
      Queue<Integer> q = new ArrayQueue<Integer>();
      int sizeQ = 0;
      q.enqueue(10);
      sizeQ++;
      q.enqueue(20);
      sizeQ++;
      q.enqueue(30);
      sizeQ++;
      System.out.println("Created a Queue with " + sizeQ + " Integer, q = " + q.toString());

      System.out.println("The current Integer Queue is q = " + q.toString());
      System.out.println("Using other methods to show its data the result is ...");
      String qData = "";
      while (!q.isEmpty()) {
          Integer first = q.first();
          if (first.equals(q.dequeue())) qData += first + " ";
          else qData += "ERROR ";
          sizeQ--;
      }
      System.out.println(" the same, " + qData
          + ", BUT q is emptied, q = " + q.toString());
  }
}