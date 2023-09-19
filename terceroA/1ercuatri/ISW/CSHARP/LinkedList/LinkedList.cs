using System;

class LinkedList<T>{
    private Node<T> head;

    public void Add(T n){
        if(this.head == null){
            Node<T> node = new Node<T>();
            node.data = n;
            node.next = null;

            this.head = node;
        }
        else{
            Node<T> node = new Node<T>();

            node.data = n;
            node.next = this.head;
            this.head = node;
        }
    }

    public void printList(){
        Node<T> aux = this.head;

        if(aux == null){Console.WriteLine("{}"); return;}
        
        Console.Write("{");
        while(aux.next != null){
            Console.Write(aux.data+"-> ");
            aux = aux.next;
        }
        Console.WriteLine(aux.data+"}");
    }

    public void Insert(){

    }
}

public class main{
    public static void Main(){
        LinkedList<int> n = new LinkedList<int>();
        n.printList();
    }
}
