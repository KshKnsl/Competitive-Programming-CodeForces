import java.util.*;
public class Code {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) 
        {
            long x=sc.nextLong();
            long n=sc.nextLong();
            if(x%2==0)
            {
                if(n%4==1)
                System.out.println(x-n);
                else if(n%4==2)
                System.out.println(x+1);
                else if(n%4==3)
                System.out.println(n+1+x);
                else 
                System.out.println(x);
            }
            else 
            {
                if(n%4==1)
                System.out.println(x+n);
                else if(n%4==2)
                System.out.println(x-1);
                else if(n%4==3)
                System.out.println(x-n-1);
                else 
                System.out.println(x); 
            }
            
        }
        sc.close();
    }
}