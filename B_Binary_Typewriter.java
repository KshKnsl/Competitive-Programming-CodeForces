
import java.util.*;

public class B_Binary_Typewriter 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            String s = sc.next();

            int T = 0;
            int zo = 0;
            int oz = 0;
            if(s.charAt(0)=='1'){ T++; zo++;}

            for (int i = 1; i < n; i++) 
            {
                if (s.charAt(i) != s.charAt(i - 1)) 
                {
                    T++;
                    if (s.charAt(i - 1) == '0' && s.charAt(i) == '1') 
                    {
                        zo++;
                    } 
                    else 
                    {
                        oz++;
                    }
                }
            }
            int res=0;
            if (zo >= 2 || oz >= 2)
            res-= 2;
            else if (zo >= 1 && oz >= 1)
            res-= 1;
            System.out.println(n + T + res);
        }
        sc.close();
    }
}