package searchEngine;

public class inversion {

	static int mergeSort(float[] s11, int array_size) // sort the input array and return number of inversions

	{

		float temp[] = new float[array_size];

		return _mergeSort(s11, temp, 0, array_size - 1);

	}

	/*
	 * An auxiliary recursive which sorts the input array and return number of
	 * inversions in the array
	 */

	static int _mergeSort(float[] s11, float[] temp, int left, int right)

	{

		int mid, inv = 0;

		if (right > left)

		{

			/*
			 * Divide the array into two parts and call _mergeSort and CountInv()
			 * 
			 * for each of the parts
			 */

			mid = (right + left) / 2; // get the middle element

			inv = inv + _mergeSort(s11, temp, mid + 1, right); //// get the inversion count in right part

			inv = _mergeSort(s11, temp, left, mid); // get the inversion count in left part

			inv = inv + merge(s11, temp, left, mid + 1, right); // get the inversion count in merging the left and right
																// part

		}

		return inv;

	}

	// It will merge two sorted array and count the inversion

	static int merge(float[] s11, float[] temp, int left, int mid, int right)

	{

		int i, j, k;

		int inv = 0;

		i = left; /* i is index for left subarray */

		j = mid; /* j is index for right subarray */

		k = left; /* k is index for resultant merged subarray */

		while ((i <= mid - 1) && (j <= right))

		{

			if (s11[i] <= s11[j])

			{

				temp[k++] = s11[i++];

			}

			else

			{

				temp[k++] = s11[j++];

				inv += (mid - i);

			}

		}

		/*
		 * Copy the remaining elements of right subarray
		 * 
		 * (if there are any) to temp
		 */

		while (j <= right)

			temp[k++] = s11[j++];

		/*
		 * Copy the remaining elements of left subarray
		 * 
		 * (if there are any) to temp
		 */

		while (i <= mid - 1)

			temp[k++] = s11[i++];

		/* Copy back the merged elements to original array */

		for (i = left; i <= right; i++)

			s11[i] = temp[i];

		return inv;

	}

}
