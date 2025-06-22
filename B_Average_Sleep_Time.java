import java.io.*;
import java.util.*;

public class B_Average_Sleep_Time 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            long tot=0;
            long cur=0;
            int den= n-k+1;
            for(int i=0;i<k;i++) 
            {
                tot+=arr[i];
                cur+=arr[i];
            }
            for(int i=k;i<n;i++)
            {
                cur-=arr[i-k];
                cur+=arr[i];
                tot+=cur;
            }
            System.out.println((double)tot/den);
        }
    }
}