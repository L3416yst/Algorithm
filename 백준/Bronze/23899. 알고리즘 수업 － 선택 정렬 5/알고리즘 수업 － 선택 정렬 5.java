import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean equal;
    public static int[] A;
    public static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int amount = Integer.parseInt(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());
        A = new int[amount];
        for (int i = 0; i < amount; i++) {
            A[i] = Integer.parseInt(a.nextToken());
        }
        StringTokenizer b = new StringTokenizer(br.readLine());
        B = new int[amount];
        for (int i = 0; i < amount; i++) {
            B[i] = Integer.parseInt(b.nextToken());
        }
        equal = false;
        if (Arrays.equals(A, B)) {
            equal = true;
        } else {
            selectionSort(A, amount);
        }
        if(equal) {
            bw.write(1 + "\n");
        } else {
            bw.write(0 + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void selectionSort(int[] A, int n) {
        for (int last = n - 1; last >= 1; last--) {
            int k = 0;
            for (int j = 1; j <= last; j++) {
                if (A[j] > A[k]) {
                    k = j;
                }
            }
            int temp = A[k];
            A[k] = A[last];
            A[last] = temp;

            if (Arrays.equals(A, B)) {
                equal = true;
                return;
            }
        }
    }
}
