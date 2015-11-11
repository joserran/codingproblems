/**
 * Created by joserran on 11/10/2015.
 */
public class LargestValueInArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 4, 3, 7, 6, 4, 99, 3, 2, 99, 101, 1, 0, 5, 3, 2};
        System.out.println(compareToMaxIterativeApproach(arr, arr.length));
        System.out.println(compareToAll(arr, arr.length));

    }

    public static int compareToMaxIterativeApproach(int[] arr, int n)
    {
        if(n <= 0)
        {
            return -1;
        }
        int largestValue = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > largestValue)
            {
                largestValue = arr[i];
            }
        }
        return largestValue;
    }

    public static int compareToAll(int[] arr, int n)
    {
        if(n <= 0)
        {
            return -1;
        }

        int maxValue = arr[0];
        int currentMax = arr[0];
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(maxValue < arr[j])
                {
                    maxValue = arr[j];
                }
            }
            if(currentMax > maxValue)
            {
                maxValue = currentMax;
            }
        }
        return maxValue;
    }
}
