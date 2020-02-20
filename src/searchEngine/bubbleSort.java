package searchEngine;

public class bubbleSort {
	
    static int sort(double[] s11, int len)   // To count the number of inversions using Bubble Sort
    {
        int inv_count = 0;
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++)
                if (s11[i] > s11[j])
                    inv_count++;
        return inv_count;
    }

}
