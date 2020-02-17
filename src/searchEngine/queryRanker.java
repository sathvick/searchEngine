package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class queryRanker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] s1 = new float[10000], s2 = new float[10000], s3 = new float[10000], s4 = new float[10000], s5 = new float[10000],
				result = new float[10000], s11 = new float[10000], s12 = new float[10000], s13 = new float[10000], s14 = new float[10000], s15 = new float[10000];
		int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0;
		float q1 = 0, q2 = 0, q3 = 0, q4 = 0, q5 = 0, q11 = 1, q12 = 1, q13 = 1, q14 = 1, q15 = 1;
		try {
			Scanner sc = new Scanner(new File("source1.txt"));
			int i = 0;
			while (sc.hasNextFloat()) {
				s1[i++] = sc.nextFloat();
			}

			sc = new Scanner(new File("source2.txt"));
			int j = 0;
			while (sc.hasNextFloat()) {
				s2[j++] = sc.nextFloat();
			}

			sc = new Scanner(new File("source3.txt"));
			int k = 0;
			while (sc.hasNextFloat()) {
				s3[k++] = sc.nextFloat();
			}

			sc = new Scanner(new File("source4.txt"));
			int l = 0;
			while (sc.hasNextFloat()) {
				s4[l++] = sc.nextFloat();
			}

			sc = new Scanner(new File("source5.txt"));
			int m = 0;
			while (sc.hasNextFloat()) {
				s5[m++] = sc.nextFloat();
			}
			sc.close();

//			System.out.println("Source 1 :" + Arrays.toString(s1));
//			System.out.println("Source 2 :" + Arrays.toString(s2));
//			System.out.println("Source 3 :" + Arrays.toString(s3));
//			System.out.println("Source 4 :" + Arrays.toString(s4));
//			System.out.println("Source 5 :" + Arrays.toString(s5));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(Arrays.toString(s2));
//	    int w1 =1, w2=1, w3=1, w4=1, w5=1;
	    for (int i=0; i<1000000; i++) {
	    	System.out.println(i);
for(int j=0; j<s1.length; j++) {
	
	s11[j] = s1[j]*q11;
	s12[j] = s2[j]*q12;
	s13[j] = s3[j]*q13;
	s14[j] = s4[j]*q14;
	s15[j] = s5[j]*q15;
	
//	System.out.println("weighted array" + Arrays.toString(s11));
}
float[] r2 = add(s11, s12, s13, s14, s15);

result = r2.clone();
Arrays.sort(result);

int[] index = new int[10000];
for (int k = 0; k < result.length; k++) {
	int oldIndex = (int) getCorrespondingIndex(r2, result, k);
	index[k] = oldIndex;

}

reorder(s11, s12, s13, s14, s15, index);

 i1 = inversion.mergeSort(s11, 10000);
 i2 = inversion.mergeSort(s12, 10000);
 i3 = inversion.mergeSort(s13, 10000);
 i4 = inversion.mergeSort(s14, 10000);
 i5 = inversion.mergeSort(s15, 10000);

 q1 = (float)1/(1+i1);
 q2 = (float)1/(1+i2);
 q3 = (float)1/(1+i3);
 q4 = (float)1/(1+i4);
 q5 = (float)1/(1+i5);
 
 q11 = (float) 5*q1/(q1+q2+q3+q4+q5);
 q12 = (float) 5*q2/(q1+q2+q3+q4+q5);
 q13 = (float) 5*q3/(q1+q2+q3+q4+q5);
 q14 = (float) 5*q4/(q1+q2+q3+q4+q5);
 q15 = (float) 5*q5/(q1+q2+q3+q4+q5);
 
	    
 System.out.println(i + "round" + i1 );
 System.out.println(i + "round" + i2 );
 System.out.println(i + "round" + i3 );
 System.out.println(i + "round" + i3 );
 System.out.println(i + "round" + i4 );
 }
//	    System.out.println("weighted array" + Arrays.toString(s11));

		
//		System.out.println("Addition Array :" + Arrays.toString(r2));
//		System.out.print(r2[9575]);
//		System.out.print(s1[0]);

//		copying one array to another

//		System.out.println("Sorted Array :" + Arrays.toString(result));


//		 System.out.println(Arrays.toString(r2));
		

//		System.out.println("Reordered Source 1 : " + Arrays.toString(s1));
//		System.out.println("Reordered Source 2 : " + Arrays.toString(s2));
//		System.out.println("Reordered Source 3 : " + Arrays.toString(s3));
//		System.out.println("Reordered Source 4 : " + Arrays.toString(s4));
//		System.out.println("Reordered Source 5 : " + Arrays.toString(s5));
		

		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(e);
		
//		inversionQuickSort.sort(s1, 0, 10000);
//		inversionQuickSort.printArray(s1);

	}

	public static float[] add(float[] s11, float[] s12, float[] s13, float[] s14, float[] s15) {
		float[] r1 = new float[10000];

		for (int i = 0; i < 10000; i++) {
			r1[i] = s11[i] + s12[i] + s13[i] + s14[i] + s15[i];
		}

		return r1;
	}

	public static float getCorrespondingIndex(float[] r2, float[] result, int index) {
		for (int i = 0; i < r2.length; i++)
			if (result[index] == (r2[i]))
				return i;
		return -1;
	}

	public static void reorder(float[] s11, float[] s12, float[] s13, float[] s14, float[] s15, int[] index) {
		float[] temp1 = new float[10000], temp2 = new float[10000], temp3 = new float[10000], temp4 = new float[10000],
				temp5 = new float[10000];

//		result[i] should be present at index[i] index
		for (int i = 0; i < 10000; i++) {
			temp1[index[i]] = s11[i];
			temp2[index[i]] = s12[i];
			temp3[index[i]] = s13[i];
			temp4[index[i]] = s14[i];
			temp5[index[i]] = s15[i];
		}

//		Copy temp[] to s[]
		for (int i = 0; i < 10000; i++) {
			s11[i] = temp1[i];
			s12[i] = temp2[i];
			s13[i] = temp3[i];
			s14[i] = temp4[i];
			s15[i] = temp5[i];
			index[i] = i;
		}
	}

}
