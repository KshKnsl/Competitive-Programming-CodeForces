
import java.io.*;
import java.util.*;
//Bhai,ye question itna vahiyat kyo hai
//contest waale dimag se paidal ho gaye kya?
//Isko banane waala apni akal ko ghar pe bhool aaya lagta hai, saala c********* level 1000!
//Bhai, is question ko padh ke mera dimaag thak gaya!!!!!!!!!!!!!

public class D_Skibidi_Table 
{
    static class Pair {
        long x, y;
        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();

        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long size = 1L << n;

            while (q-- > 0) 
            {
                String query = sc.next();
                if (query.equals("->")) 
                {
                    long x = sc.nextLong();
                    long y = sc.nextLong();
                    System.out.println(task1(x - 1, y - 1, size));
                } 
                else if (query.equals("<-")) 
                {
                    long d = sc.nextLong();
                    Pair ans = task2(d - 1, size);
                    System.out.println((ans.x + 1) + " " + (ans.y + 1));
                }
            }
        }
    }

    static long task1(long x, long y, long size) 
    {
        if (size == 2) 
        {
            if (x == 0 && y == 0)                return 1;
            else if (x == 1 && y == 1)           return 2;
            else if (x == 1 && y == 0)           return 3;
            else return 4;
        }
        long half = size / 2;
        long q = half * half;
        if (x < half && y < half)          return task1(x, y, half);
        else if (x >= half && y >= half)   return q + task1(x - half, y - half, half);
        else if (x >= half && y < half)    return 2 * q + task1(x - half, y, half);
        else                               return 3 * q + task1(x, y - half, half);
    }

    static Pair task2(long d, long size) 
    {
        if (size == 2) 
        {
            if (d == 0)       return new Pair(0, 0);
            if (d == 1)       return new Pair(1, 1);
            if (d == 2)       return new Pair(1, 0);
            return new Pair(0, 1);
        }
        long half = size / 2;
        long q = half * half;
        if (d < q)            return task2(d, half);
        else if (d < 2 * q) 
        {
            Pair coords = task2(d - q, half);
            return new Pair(coords.x + half, coords.y + half);
        } 
        else if (d < 3 * q) 
        {
            Pair coords = task2(d - 2 * q, half);
            return new Pair(coords.x + half, coords.y);
        } 
        else 
        {
            Pair coords = task2(d - 3 * q, half);
            return new Pair(coords.x, coords.y + half);
        }
    }
    static class Scan {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
