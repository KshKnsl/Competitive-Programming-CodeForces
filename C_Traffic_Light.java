import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class C_Traffic_Light {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char current = sc.next().charAt(0);
            String s = sc.next();

            s=s+s;
            int[] nextGreen = new int[2*n];
            int lastGreen = -1;

            for (int i = 2*n - 1; i >= 0; i--) 
            {
                if (s.charAt(i) == 'g') lastGreen = i;
                nextGreen[i] = lastGreen-i;
            }
            // System.out.println(Arrays.toString(nextGreen));
            int minTime = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) 
            {
                if (s.charAt(i) == current) 
                {
                    int time =  nextGreen[i];
                    minTime = Math.max(minTime, time);
                }
            }

            System.out.println(minTime);
        }
        
        sc.close();
    }
}
