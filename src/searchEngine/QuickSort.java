package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuickSort 

{ 
	static int count =0;

    static ArrayList<Double> partition(ArrayList<Double> arr, int l, int r) { 
    	//use the arraylist for pivot, first and last element
        ArrayList<Double> pivot = new ArrayList<Double>(); 
        ArrayList<Double> big = new ArrayList<Double>();
        ArrayList<Double> small = new ArrayList<Double>();
        if (arr.size() > 1) {

            pivot.add(arr.get(0));

            for (int j = 1; j <= r; j++) {
                double temp = pivot.get(0);
                if (arr.get(j) < temp) {
                    // put smaller element in small array
                    Double t = arr.get(j);
                    small.add(t);
                    count += big.size() + pivot.size(); // increase count here
                } else if (arr.get(j) > temp) {
                    // Insert larger element in larger array
                    double t = arr.get(j);
                    big.add(t);
                } else if (arr.get(j) == temp) {
                    // Insert  in the mid array
                    double t = arr.get(j);
                    pivot.add(t);
                    count += big.size();             // increase count here
                    }
            }
            ArrayList<Double> left = partition(small, 0, small.size() - 1);  //Created two arraylist for left and right
            ArrayList<Double> right = partition(big, 0, big.size() - 1);

            if (right != null) {
                big.addAll(right);
            }
            if (left != null) {
                small.addAll(left);
            }
            if (pivot != null) {
                small.addAll(pivot);
            }
            if (big != null) {
                small.addAll(big);
            }
            return small;
        } else if (arr.size() == 0) {
            return null;
        } else {
            small.addAll(pivot);
            small.addAll(big);
            return small;
        }

    }

    static int quickSort(double[] arrr, int l, int r)                //To count the number of inversions using Quick Sort
    {
        count=0;
        ArrayList<Double> arr = Arrays.stream(arrr).boxed().collect(Collectors.toCollection(ArrayList::new));
        partition(arr, l, r);
        return count; //return count here
    }
}