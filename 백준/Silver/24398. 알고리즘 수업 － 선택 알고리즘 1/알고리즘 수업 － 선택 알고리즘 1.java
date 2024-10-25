import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int count = 0;
	public static int K;
	public static int a;
	public static int b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer f = new StringTokenizer(br.readLine());
		int amount = Integer.parseInt(f.nextToken());
		int find = Integer.parseInt(f.nextToken());
		K = Integer.parseInt(f.nextToken());
		int[] num = new int[amount];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < amount; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int answer = select(num, 0, num.length - 1, find);
		if (K > count) {
			bw.write(-1 + "\n");
		} else {
			if (a <= b) {
				bw.write(a + " " + b);
			} else {
				bw.write(b + " " + a);
			}
		}
		bw.flush();
		bw.close();
	}
	public static int select(int[] A, int p, int r, int q) {
		if (p == r) return A[p];
		int t = partition(A, p, r);
		int k = t - p + 1;
		if (q < k) {
			return select(A, p, t  -1 , q);
		} else if ( q == k) {
			return A[t];
		} else {
			return select(A, t + 1, r, q - k);
		}
	}
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int y = 0;
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if(A[j] <= x) {
				count++;
				y = A[++i];
				if (count == K) {
					a = A[i];
					b = A[j];
				}
				A[i] = A[j];
				A[j] = y;
			}
		}
		if (i + 1 != r) {
			count++;
			if (count == K) {
				a = A[i + 1];
				b = A[r];
			}
			y = A[i + 1];
			A[i + 1] = A[r];
			A[r] = y;
		}
		return i + 1;
	}

}
