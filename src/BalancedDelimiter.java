import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by joserran on 11/15/2015.
 */
public class BalancedDelimiter
{
    public static void main(String[] args)
    {
        System.out.println(isBalanced("{([()])}"));
    }

    /*
    Given a string a delimiters and return true if they are balanced.
     */
    static boolean isBalanced(String str)
    {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++)
        {
            if(map.containsValue(str.charAt(i)))
                stack.add(str.charAt(i));//add to stack
            else if(map.containsKey(str.charAt(i)))
            {
                //check to see if the char is compatible with value pair.
                if(stack.peek().equals(map.get(str.charAt(i))))
                    stack.pop();
                else
                    return false;
            }
            else
                return false;
        }
        return (stack.empty());
    }
}
