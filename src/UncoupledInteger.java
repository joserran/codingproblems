import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by joserran on 11/12/2015.
 */
public class UncoupledInteger<E>
{
    public static void main(String[] args)
    {
        int[] array = {2, 7, 2, 8, 5, 1, 1, 7, 8};
        System.out.println(findUncoupled(array));
        System.out.println(findCoupledXOR(array));

    }

    static int findUncoupled(int[] arr)
    {
        Set<Integer> set = new LinkedHashSet<Integer>();

        for(int i = 0; i < arr.length; i++)
        {
            if(!set.contains(arr[i]))
                set.add(arr[i]);
            else
                set.remove(arr[i]);
        }

        Iterator<Integer> it = set.iterator();

        return it.next();
    }

    static int findCoupledXOR(int[] arr)
    {
        int xorValue = 0;

        for(int i: arr)
        {
            xorValue ^= i;
        }
        return xorValue;
    }
}
