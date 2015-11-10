
/**
 * Created by joserran on 11/8/2015.
 */
public class ReverseLinkedList<E>
{
    public static void main(String[] args)
    {
        ReverseLinkedList<String> rll = new ReverseLinkedList<>();
        rll.addFront("5");
        rll.addFront("4");
        rll.addFront("3");
        rll.addFront("2");
        rll.addFront("1");
        System.out.println(rll);
        rll.revListIt();
        System.out.println(rll);
    }

    public Node<E> head;

    public ReverseLinkedList()
    {
        head = null;
    }

    public void revListIt()
    {
        head = reverseList(head);
    }

    public Node<E> reverseList(Node<E> head)
    {
        if(head == null)
        {
            return null;
        }
        else if(head.next == null)
        {
            return head;
        }
        else
        {
            Node<E> left = null;
            Node<E> current = head;
            Node<E> right = head.next;

            while(current != null)
            {
                current.next = left;
                left = current;
                current = right;
                if(current != null)
                {
                    right = right.next;
                }
            }
            return left;
        }
    }

    public void addFront(E e)
    {
        head = new Node<>(head, e);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> tmp = head;
        while(tmp != null)
        {
            sb.append(tmp + " ");
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node<E>
    {
        Node<E> next;
        E data;

        public Node(Node<E> n, E d)
        {
            next = n;
            data = d;
        }

        public String toString()
        {
            return "" + data;
        }

    }
}
