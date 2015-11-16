import sun.awt.image.ImageWatched;

/**
 * Created by joserran on 11/10/2015.
 *
 * Write a function to detect a cycle in a linked list.
 *
 */
public class LinkedListCycle<E>
{
    LinkedListCycle<E> next;
    E data;

    public LinkedListCycle(LinkedListCycle<E> n, E d)
    {
        next = n;
        data = d;
    }

    public static void main(String[] args)
    {
        LinkedListCycle<String> estonia = new LinkedListCycle<>(null, "Estonia");
        LinkedListCycle<String> denmark = new LinkedListCycle<>(estonia, "Denmark");
        LinkedListCycle<String> cambodia = new LinkedListCycle<>(denmark, "Cambodia");
        //estonia.next = cambodia;
        LinkedListCycle<String> belarus = new LinkedListCycle<>(cambodia, "Belarus");
        LinkedListCycle<String> argentina = new LinkedListCycle<>(belarus, "Argentina");
        //argentina.printListSyso();

        LinkedListCycle<String> b = new LinkedListCycle<>(null, "b");
        LinkedListCycle<String> a = new LinkedListCycle<>(b, "a");

        LinkedListCycle<String> cycle1 = new LinkedListCycle<>(null, "cycle");
        cycle1.next = cycle1;


        System.out.println(a.containsCycle());

    }

    public String toString()
    {
        return "" + data;
    }

    public String printList()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        LinkedListCycle<E> tmp = this;
        while(tmp != null)
        {
            sb.append(tmp + ", ");
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void printListSyso()
    {
        LinkedListCycle<E> tmp = this;
        while(tmp != null)
        {
            System.out.print(tmp + " ");
            tmp = tmp.next;
        }
    }

    public boolean containsCycle()
    {
        LinkedListCycle<E> slow = this;
        LinkedListCycle<E> fast = this;


        while(slow != null || fast != null)
        {
            if( fast.next == null|| slow.next == null || fast.next.next == null)//using short circuit operator fast.next == null will be verified before fast.next.next hence, if fast.next.next == null is out of bounds it will never know because fas.next == null will catch it first.
            {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }
}
