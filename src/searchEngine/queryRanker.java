package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class queryRanker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		int[] s1 = new int[10000], s2 = new int[10000], s3 = new int[10000], s4 = new int[10000], s5 = new int[10000],
				result = new int[10000];
		try {
			sc = new Scanner(new File("source1.txt"));
			int i = 0;
			while (sc.hasNextInt()) {
				s1[i++] = sc.nextInt();
			}

			sc = new Scanner(new File("source2.txt"));
			int j = 0;
			while (sc.hasNextInt()) {
				s2[j++] = sc.nextInt();
			}

			sc = new Scanner(new File("source3.txt"));
			int k = 0;
			while (sc.hasNextInt()) {
				s3[k++] = sc.nextInt();
			}

			sc = new Scanner(new File("source4.txt"));
			int l = 0;
			while (sc.hasNextInt()) {
				s4[l++] = sc.nextInt();
			}

			sc = new Scanner(new File("source5.txt"));
			int m = 0;
			while (sc.hasNextInt()) {
				s5[m++] = sc.nextInt();
			}

			/*
			 * System.out.println("Source 1 :" + Arrays.toString(s1));
			 * System.out.println("Source 2 :" + Arrays.toString(s2));
			 * System.out.println("Source 3 :" + Arrays.toString(s3));
			 * System.out.println("Source 4 :" + Arrays.toString(s4));
			 * System.out.println("Source 5 :" + Arrays.toString(s5));
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(Arrays.toString(s2));
		int[] r2 = add(s1, s2, s3, s4, s5);
		// System.out.println("Addition Array :" + Arrays.toString(r2));
		// System.out.print(r2[9575]);
		// System.out.print(s1[0]);

		// copying one array to another
		result = r2.clone();
		Arrays.sort(result);
		// System.out.println("Sorted Array :" + Arrays.toString(result));
		int[] index = new int[10000];
		for (int i = 0; i < result.length; i++) {
			int oldIndex = getCorrespondingIndex(r2, result, i);
			index[i] = oldIndex;

		}

		// System.out.println(Arrays.toString(r2));
		reorder(s1, s2, s3, s4, s5, index);

		/*System.out.println("Reordered Source 1 : " + Arrays.toString(s1));
		System.out.println("Reordered Source 2 : " + Arrays.toString(s2));
		System.out.println("Reordered Source 3 : " + Arrays.toString(s3));
		System.out.println("Reordered Source 4 : " + Arrays.toString(s4));
		System.out.println("Reordered Source 5 : " + Arrays.toString(s5));
*/
		System.out.println("Number of inversions are " + getInvCount(s1));

	}

	public static int[] add(int[] first, int[] second, int[] third, int[] fourth, int[] fifth) {
		int[] r1 = new int[10000];

		for (int i = 0; i < 10000; i++) {
			r1[i] = first[i] + second[i] + third[i] + fourth[i] + fifth[i];
		}

		return r1;
	}

	public static int getCorrespondingIndex(int[] r2, int[] result, int index) {
		for (int i = 0; i < r2.length; i++)
			if (result[index] == (r2[i]))
				return i;
		return -1;
	}

	public static void reorder(int[] s1, int[] s2, int[] s3, int[] s4, int[] s5, int[] index) {
		int[] temp1 = new int[10000], temp2 = new int[10000], temp3 = new int[10000], temp4 = new int[10000],
				temp5 = new int[10000];

		// result[i] should be present at index[i] index
		for (int i = 0; i < 10000; i++) {
			temp1[index[i]] = s1[i];
			temp2[index[i]] = s2[i];
			temp3[index[i]] = s3[i];
			temp4[index[i]] = s4[i];
			temp5[index[i]] = s5[i];
		}

		// Copy temp[] to result[]
		for (int i = 0; i < 10000; i++) {
			s1[i] = temp1[i];
			s2[i] = temp2[i];
			s3[i] = temp3[i];
			s4[i] = temp4[i];
			s5[i] = temp5[i];
			index[i] = i;
		}
	}

	public static int getInvCount(int [] s1) {
		int inv_count = 0, n = 10000;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (s1[i] > s1[j])
					inv_count++;

		return inv_count;
	}

}
