import java.util.*;
public class B_Difference_of_GCDs 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] result = new int[n];
            boolean possible = true;

            for (int i = 1; i <= n; i++) 
            {
                int multiple = ((l + i - 1) / i) * i;
                if (multiple > r) 
                {
                    possible = false;
                    break;
                }
                result[i - 1] = multiple;
            }

            if (possible) 
            {
                System.out.println("YES");
                for (int num : result) 
                {
                    System.out.print(num + " ");
                }
                System.out.println();
            } 
            else 
            {
                System.out.println("NO");
            }
        }
    }
}