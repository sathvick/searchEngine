package searchEngine;


import java.util.Arrays;



public class quick {

    static int count;

    static int sum;



    public static int sort(int[] array) {

        sort(array, 0, array.length - 1);

		return sum;

    }





    private static void sort(int[] array, int l, int r) {

        if (l < r) {

            // select pivot element (left-most)  

            int pivot = array[l];

            // partition and shuffle around pivot 

            int i = l;

            int j = r;

            while (i < j) {

                // move right to avoid pivot element 

                i += 1;

                // scan right: find elements greater than pivot 

                while (i <= r && array[i] < pivot) {

                    i += 1;

                }

                // scan left: find elements smaller than pivot

                while (j >= l && array[j] > pivot) {

                    j -= 1;

                }

                if (i <= r && i < j) {

                    // swap around pivot  

                    swap(array, i, j);

                }

            }

            // put pivot in correct place

            swap(array, l, j);

            sum += ++count;

            // sort partitions 

            sort(array, l, j - 1);

            sort(array, j + 1, r);

        }

    }





    private static void swap(int[] array, int i, int j) {

        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {

            int tmp = array[i];

            array[i] = array[j];

            array[j] = tmp;

        }

    }



    public static void main(String[] args) {

        int[] array = new int[]  { 8, 9, 11, 1, 8, 2 };



        new quick().sort(array);

        System.out.println("Sorted: " + Arrays.toString(array));

        System.out.println(sum);

    }



}



