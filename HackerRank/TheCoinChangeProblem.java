import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheCoinChangeProblem {

    static long getWays(long n, long[] c){
        if(n<0)
            return 0L;
        else if(n==0)
            return 1L;
        else
        {
           return getWays(n-c[0],c)+getWays(n-c[1],c)+getWays(n-c[2],c);
            
        }
   
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
