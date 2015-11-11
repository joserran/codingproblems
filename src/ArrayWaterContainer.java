/**
 * Created by joserran on 11/10/2015.
 *
 *  One of the more interesting questions went as follows   .
 *  Given an array of nonnegative integers which represents a histogram (bar chart in particular)
 *  how much water would it hold in between the vertical bars if you poured water over it?
 *
 *  In answering this question it was really important that I first clarified exactly what I was computing before starting to code.
 *  I walked through an O(n) solution that makes a single pass over the elements, but might have had some issues with boundary some conditions.
 *  The interviewer described a cleaner solution which involves determining the maximum height to the left and right of each element.
 *  would normally be O(n^2) except it can be done in linear time with some memoization. Though I didn't come up with that solution the
 *  interviewer still seemed satisfied with my answer and was complimentary overall.
 *
 *
 */
public class ArrayWaterContainer
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 3, 7, 2, 9};
        int[] arr2 = {1, 3, 0, 0, 2, 9};
        int[] arr3 = {1, 3, 0, 7, 2, 9};
        int[] arr4 = {9, 0, 0, 0, 0, 9};
        int waterAmount = countTotalWaterLevelNoZero(arr4);
        System.out.print(waterAmount + ", ");
        int waterAmountWithZero = countTotalWaterLevelNoZerowithZero(arr4);
        System.out.print(waterAmountWithZero);
    }

    public static int countTotalWaterLevelNoZerowithZero(int[] arr)
    {
        int sum = 0;
        int nextNonZeroIndex = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            //System.out.println("inside for loop index: " + i);

            if(arr[i +1] == 0 && i != arr.length)
            {
                nextNonZeroIndex = findNextNonZeroElementMethod(arr, i + 1);
                if(nextNonZeroIndex - i == 2)//only 1 middle element value is 0.
                {
                    sum += findLowestElementValue(arr, nextNonZeroIndex, i) * 3;
                }
                else//more than 1 middle element value is 0.
                {
                    int smallestValue = findLowestElementValue(arr, i, nextNonZeroIndex);
                    sum += smallestValue * 2 * (nextNonZeroIndex - (i + 1)) + smallestValue;
                }
                i = nextNonZeroIndex - 1;
            }
            else
            {
                sum += findLowestElementValue(arr, i, i + 1);
            }
        }
        return sum;
    }

    public static int findNextNonZeroElementMethod(int[] arr, int index)
    {
        int counter = 0;
        while(arr[index] == 0)
        {
            counter++;
            index++;
        }
        return index;
    }

    public static int findLowestElementValue(int[] arr, int a, int b)
    {
        if(arr[a] != arr[b])
        {
            return Math.min(arr[a], arr[b]);
        }
        else
        {
            return arr[a];
        }
    }

    public static int countTotalWaterLevelNoZero(int[] arr)
    {
        int sum = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            sum += findLowestElementValue(arr, i, i + 1);
        }
        return sum;
    }
}
