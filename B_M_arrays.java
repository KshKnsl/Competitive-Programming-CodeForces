import java.util.*;

public class B_M_arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] freq = new int[m + 10];
            for (int i = 0; i < n; i++) {
                freq[arr[i] % m]++;
            }

            int ans = (freq[0] > 0) ? 1 : 0;
            int l = 1, r = m - 1;
            
            while (l <= r) 
            {
                if (freq[l]==0 && freq[r] == 0) 
                {
                    l++;
                    r--;
                    continue;
                }
                if (freq[l] < freq[r]) 
                {
                    int temp = freq[l];
                    freq[l] = freq[r];
                    freq[r] = temp;
                }
                
                if (freq[r] > 0) {
                    freq[l] -= (freq[r] + 1);
                    ans++;
                }
                
                if (freq[l] > 0) {
                    ans += freq[l];
                }
                l++;
                r--;
            }
            
            System.out.println(ans);
        }
        sc.close();
    }
}