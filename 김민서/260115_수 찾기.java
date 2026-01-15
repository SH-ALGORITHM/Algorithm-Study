import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> A = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		int[] B1 = new int[m];
		Map<Integer, Integer> find = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			B1[i] = B[i];
			find.put(B[i], 0);
		}

		Arrays.sort(B);

		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = m - 1;

			while (start <= end) {
				int mid = (end + start) / 2;

				if (A.get(i) == B[mid]) {
					find.replace(B[mid], 1);
					break;
				} else if (A.get(i) > B[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			System.out.println(find.get(B1[i]));
		}
	}

}