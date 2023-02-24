package examples.topic1;

public class TestEDAQueue {
  public static void main(String[] args) {      
      Queue q = new ArrayQueue();
      System.out.println("Created a Queue with " + q.size
          + " Integer, q = " + q.toString());
      q.enqueue(10);
      q.enqueue(20);
      q.enqueue(30);
      System.out.println("The current Integer Queue is q = " + q.toString());
      System.out.println("Using other methods to show its data the result is ...");
      String qData = "";
      while (!q.isEmpty()) {
          Integer first = q.first();
          if (first.equals(q.dequeue())) qData += first + " ";
          else qData += "ERROR ";
      }
      System.out.println(" the same, " + qData
          + ", BUT q is emptied, q = " + q.toString());
  }
}