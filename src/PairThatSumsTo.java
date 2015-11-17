/**
 * Created by joserran on 11/16/2015.
 */
public class PairThatSumsTo
{
    public static void main(String[] args)
    {
        System.out.print(hasPairThatSumsToN2(new int[]{5, 4, 3, 2, 0,1}, 0));
        System.out.print(hasPairThatSumsToNlogN(new int[]{5, 4, 3, 0, 2, 1}, 0));
        System.out.print(hasPairThatSumsToN2(new int[]{}, 0));
        System.out.print(hasPairThatSumsToNlogN(new int[]{2, 5}, 5));
    }

    /*
    Brute-force n^2 solution

     */
    static boolean hasPairThatSumsToN2(int[] numbers, int target)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                if(numbers[i] + numbers[j] == target)
                    return true;
            }
        }
        return false;
    }

    static boolean hasPairThatSumsToNlogN(int[] numbers, int target)
    {
        if(numbers.length < 2)
            return false;
        java.util.Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;

        while(left != right)
        {
            if (target == (numbers[left] + numbers[right]))
            {
                return true;
            }
            else if(target > (numbers[left] + numbers[right]))
            {
                left++;
            }
            else
                right--;
        }
        return false;
    }
}
