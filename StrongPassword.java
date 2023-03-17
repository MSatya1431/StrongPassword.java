import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) 
    {
        int count = 0;
        boolean hasLowerCase = false, hasUpperCase = false, hasDigit = false, hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-+";

        // Check if the password has at least one of each required type of character
        for (int i = 0; i < n; i++) 
        {
            char c = password.charAt(i);
            if (Character.isLowerCase(c))
            {
                hasLowerCase = true;
            } 
            else if (Character.isUpperCase(c)) 
            {
                hasUpperCase = true;
            } 
            else if (Character.isDigit(c))
            {
                hasDigit = true;
            } 
            else if (specialChars.indexOf(c) >= 0) 
            {
                hasSpecialChar = true;
            }
        }
        if (!hasLowerCase) count++;
        if (!hasUpperCase) count++;
        if (!hasDigit) count++;
        if (!hasSpecialChar) count++;
        // Check if the password length plus the number of required characters is less than 6
        if (n + count < 6) 
        {
            count += 6 - (n + count);
        }
        return count;
    }
}

public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
