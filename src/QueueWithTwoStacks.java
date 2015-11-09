/**
 * Created by joserran on 11/8/2015.
 */
import java.util.*;

public class QueueWithTwoStacks<E>
{
    /**
     *	Implementing a queue with 2 stacks.
     */
    private Stack<E> primary = new Stack<E>();
    private Stack<E> tmp = new Stack<E>();

    public QueueWithTwoStacks()
    {

    }

    public E enqueue(E e)
    {
        primary.push(e);
        return e;
    }

    public E dequeue()
    {
        if(primary.size() == 1)
        {
            return primary.pop();
        }
        else if(primary.size() == 0)//if you do not account for no elements in Queue program will through exception
        {
            return null;
        }
        else //more than 1 element in the queue
        {
            System.out.println(primary.size());
            E returnElement = popToTmp(primary.size());
            pushBackToPrimary(tmp.size());
            System.out.println(primary);
            return returnElement;
        }
    }
    public E popToTmp(int num)
    {
        for(int i = 0; i < num - 1; i++)//move all elements over except for the last element in primary (bottom element)
        {
            tmp.push(primary.pop());
        }
        //System.out.println(tmp);
        return primary.pop();
    }

    public void pushBackToPrimary(int num)
    {
        for(int i = 0; i < num; i++)
        {
            primary.push(tmp.pop());
        }
    }

    public static void main(String[] args)
    {
        //Testing
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        System.out.println(queue.enqueue(1));
        System.out.println(queue.enqueue(2));
        System.out.println(queue.enqueue(3));
        System.out.println(queue.enqueue(4));
        System.out.println(queue.enqueue(5));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}