import java.io.*;
import java.util.*;
// import java.util.stream.Collectors; 

public class D_Creating_a_Schedule 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int tests = sc.nextInt();
        while (tests-- > 0) 
        {
            int groups = sc.nextInt(); 
            int rooms = sc.nextInt(); 
            int[] roomIds = sc.nextArray(rooms); 

            Map<Integer, List<Integer>> floorMap = new HashMap<>();
            for (int id : roomIds) {
                int floor = id / 100;
                floorMap.computeIfAbsent(floor, k -> new ArrayList<>()).add(id);
            }

            List<Integer> floors = new ArrayList<>(floorMap.keySet());
            Collections.sort(floors);

            // Sort room lists within each floor
            for (int floorNum : floors) {
                Collections.sort(floorMap.get(floorNum));
            }

            int numUFloors = floors.size();
            int[][] sched = new int[groups][6];

            if (numUFloors < 2) { 
                int targetF = floors.get(0);
                List<Integer> targetFRooms = floorMap.get(targetF); // Already sorted
                for (int g = 0; g < groups; g++) {
                    int r = targetFRooms.get(g); 
                    for (int c = 0; c < 6; c++) {
                        sched[g][c] = r;
                    }
                }
            } else { 
                int[] fRoomCounts = new int[numUFloors];
                for(int i=0; i<numUFloors; ++i) {
                    fRoomCounts[i] = floorMap.get(floors.get(i)).size();
                }

                int[] availA = Arrays.copyOf(fRoomCounts, numUFloors);
                int[] availB = Arrays.copyOf(fRoomCounts, numUFloors);
                
                int[] aCounts = new int[numUFloors]; 
                int[] bCounts = new int[numUFloors]; 

                int[] oddFIdx = new int[groups];
                int[] evenFIdx = new int[groups];

                int loMin = 0;
                int hiMax = numUFloors - 1;
                int loMax = numUFloors - 1;
                int hiMin = 0;

                int half = groups / 2;
                for (int g = 0; g < half; ++g) {
                    while (loMin < numUFloors && availA[loMin] == 0) loMin++;
                    oddFIdx[g] = loMin;
                    availA[loMin]--;
                    aCounts[loMin]++;

                    while (hiMax >= 0 && availB[hiMax] == 0) hiMax--;
                    evenFIdx[g] = hiMax;
                    availB[hiMax]--;
                    bCounts[hiMax]++;
                }

                for (int g = half; g < groups; ++g) {
                    while (loMax >= 0 && availA[loMax] == 0) loMax--;
                    oddFIdx[g] = loMax;
                    availA[loMax]--;
                    aCounts[loMax]++;

                    while (hiMin < numUFloors && availB[hiMin] == 0) hiMin++;
                    evenFIdx[g] = hiMin;
                    availB[hiMin]--;
                    bCounts[hiMin]++;
                }
                
                List<List<Integer>> fPools = new ArrayList<>();
                for (int j = 0; j < numUFloors; ++j) {
                    int actualF = floors.get(j);
                    List<Integer> allF_R_sorted = floorMap.get(actualF); // This list is now sorted
                    
                    int numTake = Math.max(aCounts[j], bCounts[j]);
                    List<Integer> takenR = new ArrayList<>();
                    for(int k=0; k<numTake; ++k) {
                        takenR.add(allF_R_sorted.get(k));
                    }
                    fPools.add(takenR);
                }

                int[] currA = new int[numUFloors]; 
                int[] currB = new int[numUFloors]; 

                for (int g = 0; g < groups; ++g) {
                    int oddF = oddFIdx[g];
                    int rOdd = fPools.get(oddF).get(currA[oddF]);
                    currA[oddF]++;
                    sched[g][0] = rOdd; sched[g][2] = rOdd; sched[g][4] = rOdd;

                    int evenF = evenFIdx[g];
                    int rEven = fPools.get(evenF).get(currB[evenF]);
                    currB[evenF]++;
                    sched[g][1] = rEven; sched[g][3] = rEven; sched[g][5] = rEven;
                }
            }

            for (int g = 0; g < groups; g++) {
                for (int c = 0; c < 6; c++) {
                    out.print(sched[g][c] + (c == 5 ? "" : " "));
                }
                out.println();
            }
        }
        out.close();
    }

    static class Scan 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
        int[][] nextArray2D(int n, int m) { int[][] arr = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextInt(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007; // Not used in this problem's logic

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd((int) a, (int) b)) * b; }
    static long modAdd(long a, long b) { return (a % MOD + b % MOD) % MOD; }
    static long modSub(long a, long b) { return (a % MOD - b % MOD + MOD) % MOD; }
    static long modMul(long a, long b) { return (a % MOD * b % MOD) % MOD; }
    static int modExpo(int a, int b) { if (b == 0) return 1; int res = modExpo(a, b / 2); res = (int) modMul(res, res); return (b % 2 != 0) ? (int) modMul(res, a) : res; }
    static int modInv(int a) { return modExpo(a, MOD - 2); }
    static int modDiv(int a, int b) { return (int) modMul(a, modInv(b)); }

    static boolean[] sieve(int n) { boolean[] isPrime = new boolean[n + 1]; Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false; for (int i = 2; i * i <= n; i++) if (isPrime[i]) for (int j = i * i; j <= n; j += i) isPrime[j] = false; return isPrime; }
    static int countDigits(int x) { int count = 0; while (x > 0) { count++; x /= 10; } return count; }
    static long factorial(int n) { long res = 1; for (int i = 2; i <= n; i++) res = modMul(res, i); return res; }
    static long nCr(int n, int r) { if (r > n) return 0; long num = factorial(n); long denom = modMul(factorial(r), factorial(n - r)); return modDiv((int) num, (int) denom); }
    static int lowerBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] < x) low = mid + 1; else high = mid; } return low; }
    static int upperBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] <= x) low = mid + 1; else high = mid; } return low; }
}
