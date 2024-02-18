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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
       String withoutLast = s.substring(0, s.length()-2);
    char status = s.charAt(s.length()-2);
    String res ="";
    
    int hr =Integer.parseInt(s.substring(0, 2));
    if((status =='P' ||status =='p'))
    {
        // if(hr ==12)
        // {
        //     hr =12;
            
        // }
        if(hr <12)
        {
            hr += 12;
        }
    }if(status =='A' && hr==12)
    {
        hr -= 12;
    }
    
    if(hr <12)
    {
        
     res = "0"+String.valueOf(hr)+withoutLast.substring(2);
    }else
    {
         res =String.valueOf(hr)+withoutLast.substring(2);
    }
    return res;

    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
