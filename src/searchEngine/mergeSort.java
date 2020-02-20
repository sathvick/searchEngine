package searchEngine;

import java.util.Arrays;



import java.util.ArrayList;
import java.util.List;

public class mergeSort {

    public static int mergeSort(double[] s11, int array_size) {
        double temp[] = new double[array_size];
        return _mergeSort(s11, temp, 0, array_size);
    }

	/*
	 * An auxiliary recursive method that sorts a slice of the input array and
	 * returns the number of inversions.
	 */
	static int _mergeSort(double[] s11, double[] temp, int left, int right) {
		int count = 0;
		if (right - left > 1) {
			/*
			 * Divide the array into two parts and call _mergeSort() for each of the parts
			 */
			int mid = (right + left + 1) / 2;

			/*
			 * Inversion count will be sum of inversions in left-part, right-part and number
			 * of inversions in merging
			 */
			count += _mergeSort(s11, temp, left, mid);
			count += _mergeSort(s11, temp, mid, right);

			/* Merge the two parts */
			count += merge(s11, temp, left, mid, right);
		}
		return count;
	}

    /* This method merges two sorted slices of the array and returns the inversion count */
    static long merge(double[] s11, double temp[], int left, int mid, int right) {
        long count = 0;

        int x = left; /* x is index for left subarray */
        int y = mid;  /* y is index for right subarray */
        int z = left; /* z is index for resultant merged subarray */
        while (x < mid && y < right) {
            if (s11[x] <= s11[y]) {
                temp[z++] = s11[x++];
            } else {
                temp[z++] = s11[y++];
                count += mid - x;
            }
        }

        /* Copy the remaining elements of left subarray if any */
        while (x < mid)
            temp[z++] = s11[x++];

        /* Copy the remaining elements of right subarray if any */
        while (y < right)
            temp[z++] = s11[y++];

        /* Copy back the merged elements to original array */
        for (x = left; x < right; x++)
            s11[x] = temp[x];

        return count;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
    	double[] inputArray = new double[10000];
        
             int inversion_count = mergeSort(inputArray, inputArray.length);
            System.out.println("Number of inversions is " + inversion_count + "\n");

    }
}
            
           