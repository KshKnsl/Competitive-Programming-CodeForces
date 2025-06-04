import java.util.*;
public class D_Districts_Connection 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			Set<Integer> s = new HashSet<>();
			
			for (int i = 0; i < n; i++)
			{
				a[i] = sc.nextInt();
				s.add(a[i]);
			}
			
			if (s.size() == 1)
			{
				System.out.println("NO");
				continue;
			}
			
			System.out.println("YES");
			int f = a[0], idx = -1;
			for (int i = 1; i < n; i++)
			{
				if (a[i] != f)
				{
					System.out.println(1 + " " + (i + 1));
					idx = i;
				}
			}
			
			for (int i = 1; i < n; i++)
			{
				if (a[i] == f)
					System.out.println((idx + 1) + " " + (i + 1));
			}
		}
	}
}
