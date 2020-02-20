package searchEngine;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class queryRanker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] s1 = new double[10000], s2 = new double[10000], s3 = new double[10000], s4 = new double[10000], s5 = new double[10000],
				result = new double[10000], s11 = new double[10000], s12 = new double[10000], s13 = new double[10000], s14 = new double[10000], s15 = new double[10000];
		int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0;
		double q1 = 0, q2 = 0, q3 = 0, q4 = 0, q5 = 0, q11 = 1, q12 = 1, q13 = 1, q14 = 1, q15 = 1;
		try { //Read all the source files
			Scanner sc = new Scanner(new File("source1.txt"));
			int i = 0;
			while (sc.hasNextDouble()) {
				s1[i++] = sc.nextDouble();
			}

			sc = new Scanner(new File("source2.txt"));
			int j = 0;
			while (sc.hasNextDouble()) {
				s2[j++] = sc.nextDouble();
			}

			sc = new Scanner(new File("source3.txt"));
			int k = 0;
			while (sc.hasNextDouble()) {
				s3[k++] = sc.nextDouble();
			}

			sc = new Scanner(new File("source4.txt"));
			int l = 0;
			while (sc.hasNextDouble()) {
				s4[l++] = sc.nextDouble();
			}

			sc = new Scanner(new File("source5.txt"));
			int m = 0;
			while (sc.hasNextDouble()) {
				s5[m++] = sc.nextDouble();
			}
			sc.close();

		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}

	    for (int i=1; i<=4; i++) {

for(int j=0; j<s1.length; j++) {   //Initiall weights are 1
	
	s11[j] = s1[j]*q11;
	s12[j] = s2[j]*q12;
	s13[j] = s3[j]*q13;
	s14[j] = s4[j]*q14;
	s15[j] = s5[j]*q15;
	
}


double[] r2 = add(s11, s12, s13, s14, s15);


result = r2.clone();
Arrays.sort(result); //Sort the combined array

int[] index = new int[10000];
for (int k = 0; k < result.length; k++) {
	int oldIndex = getCorrespondingIndex(result, r2, k);
	index[k] = oldIndex;

}

reorder(s11, s12, s13, s14, s15, index);


int i11 = bubbleSort.sort(s11, s11.length);
int i12=  bubbleSort.sort(s12, s11.length);
int i13 = bubbleSort.sort(s13, s11.length);
int i14 = bubbleSort.sort(s14, s11.length);
int i15 = bubbleSort.sort(s15, s11.length);

// Uncomment the below if you want to run mergesort
//int i11 = mergesort.mergesort(s11, s11.length);
//int i12=  mergesort.mergesort(s12, s11.length);
//int i13 = mergesort.mergesort(s13, s11.length);    
//int i14 = mergesort.mergesort(s14, s11.length);
//int i15 = mergesort.mergesort(s15, s11.length);


//Uncomment the below if you want to run quicksort
//int i11 = QuickSort.quicksort(s11,0,s11.length-1);
//int i12=  QuickSort.quicksort(s12, 0,s11.length-1);
//int i13 = QuickSort.quicksort(s13,0, s11.length-1);    
//int i14 = QuickSort.quicksort(s14,0, s11.length-1);
//int i15 = QuickSort.quicksort(s15,0, s11.length-1);



 // We calculated the weights to normalize it

 q1 = (double)1/(1+i11);
 q2 = (double)1/(1+i12);
 q3 = (double)1/(1+i13);
 q4 = (double)1/(1+i14);
 q5 = (double)1/(1+i15);
 
 System.out.println("weight 1 : " +  " "+ q11 );
 System.out.println("weight 2 : "+  " "+ q12 );
 System.out.println("weight 3 : "+  " "+ q13 );
System.out.println("weight 4 : "+  " "+ q14 );
 System.out.println("weight 5 : " + " "+ q15 );
 
 //This weight will be added to the source files
 q11 = (double) (5*q1)/(q1+q2+q3+q4+q5);
 q12 = (double) (5*q2)/(q1+q2+q3+q4+q5);
 q13 = (double) (5*q3)/(q1+q2+q3+q4+q5);
 q14 = (double) (5*q4)/(q1+q2+q3+q4+q5);
 q15 = (double) (5*q5)/(q1+q2+q3+q4+q5);

 
	    
 System.out.println(i + "round, inverion : " + i11 );
 System.out.println(i + "round, inverion : " + i12 );
 System.out.println(i + "round, inverion : " + i13 );
 System.out.println(i + "round, inverion : " + i14 );
 System.out.println(i + "round, inverion : " + i15 );

 }

	}
// Adding the numbers in source files
	public static double[] add(double[] s11, double[] s12, double[] s13, double[] s14, double[] s15) {
		double[] r1 = new double[10000];

		for (int i = 0; i < 10000; i++) {
			r1[i] = s11[i] + s12[i] + s13[i] + s14[i] + s15[i];
		}

		return r1;
	}
// Getting the index
	public static int getCorrespondingIndex(double[] r2, double[] result, int index) {
		for (int i = 0; i < r2.length; i++)
			if (result[index] == (r2[i]))
				return i;
		return -1;
	}
	
// Reordering the source files	

	public static void reorder(double[] s11, double[] s12, double[] s13, double[] s14, double[] s15, int[] index) {
		double[] temp1 = new double[10000], temp2 = new double[10000], temp3 = new double[10000], temp4 = new double[10000],
				temp5 = new double[10000];

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