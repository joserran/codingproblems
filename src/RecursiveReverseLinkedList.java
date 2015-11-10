/**
 * Created by joserran on 11/9/2015.
 */
public class RecursiveReverseLinkedList<E>
{
    LinkedList<E> head;

    public RecursiveReverseLinkedList()
    {
        head = null;
    }

    public static void main(String[] args)
    {
        RecursiveReverseLinkedList<String> ll = new RecursiveReverseLinkedList<>();
        ll.addFront("five");
        ll.addFront("four");
        ll.addFront("three");
        ll.addFront("two");
        ll.addFront("one");
        System.out.println(ll);
        ll.rec();
        System.out.println(ll);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedList<E> tmp = head;
        while(tmp != null)
        {
            sb.append(tmp + " ");
            tmp = tmp.next;
        }
        sb.append("]");

        return  sb.toString();
    }

    public void addFront(E e)
    {
        head = new LinkedList<>(head, e);
    }

    public void rec()
    {
        //this.reversed();
        head = head.reversed();
    }

    class LinkedList<E>
    {
        public LinkedList<E> next;
        public E data;

        public LinkedList(LinkedList<E> n, E d)
        {
            next = n;
            data = d;
        }

        public LinkedList<E> reversed()
        {
            return this.reversedRecursive(null);
        }

        private LinkedList<E> reversedRecursive(LinkedList<E> newNext)
        {
            LinkedList<E> oldNext = this.next;

            this.next = newNext;

            if(oldNext == null)
            {
                return this;
            }
           return oldNext.reversedRecursive(this);
        }

        public String toString()
        {
            return "" + data;
        }

    }

}


