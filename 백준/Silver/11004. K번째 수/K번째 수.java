import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static int[] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer f = new StringTokenizer(br.readLine());
		int amount = Integer.parseInt(f.nextToken());
		int find = Integer.parseInt(f.nextToken());
		int[] num = new int[amount];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < amount; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		tmp = new int[num.length];
		mergeSort(num, 0, amount - 1);

		bw.write(num[find - 1] + "\n");
		bw.flush();
		bw.close();
	}

	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = p;

		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = A[i++];
		}
		while (j <= r) {
			tmp[t++] = A[j++];
		}

		for (int k = p; k <= r; k++) {
			A[k] = tmp[k];
		}
	}
}
