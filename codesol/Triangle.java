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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
      if(n <= 0) {
          throw new IllegalArgumentException("n must be a positive integer.");
      }
      
      for(int i = 1; i <= n; i++) {
          //i represents the no. of # needed in each row
          //and n - i represents the spaces to be left in each row
          //both goes in opposite direction
          for(int j = 1; j <= n - i; j++) {
              System.out.print(" ");
          }
          for(int j = 1; j <= i; j++) {
              System.out.print("#");
          }
          System.out.println();
      }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
