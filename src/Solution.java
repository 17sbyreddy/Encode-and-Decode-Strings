import java.util.ArrayList;
import java.util.List;

public class Solution {

    /* encoding will be length of string then # then string. ex: 5#Hello5#world. Then for decode, have pointer i and j, and incrmeent j one more than i, and get the number before # via j and store it in num variable. Then get the subtring from the first letter to the last and append it to the list. Then move the i pointer to the last letter of the first word. Then repeat process for next word.

     */

    // we will make the model  5#Hello so here we make the string look like this
    public String encode(List<String> strs)
    {
        StringBuilder result = new StringBuilder();
        for (String s : strs)
        {
            result.append(s.length()).append('#').append(s);
        }

        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s)
    {
        List<String> result = new ArrayList();
        int i = 0;
        // going across the length of the whole string 5#Hello
        while (i < s.length())
        {
            int j = i;
            int num = 0;
            // this loop is for a single world so and once loop finishes then we will move on to next word
            while (s.charAt(j) != '#') // stoping before #
            {
                //int g = s.charAt(j++) - '0';
                num = num * 10 + (s.charAt(j) - '0'); //converts int to string
                j++; // moves to next digit of number

            }
            result.add(s.substring(j + 1, j + num + 1)); // gets the word portion of 5#Hello
            i = j + num + 1; // moves pointer to beggning of next word
        }

        return result;
    }
}
