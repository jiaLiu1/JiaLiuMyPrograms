package Introduction;
import java.util.*;

public class sortAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] test = {7,7,7,7,7,7,7,7,7,2,9,7,8,0,9};
//		selectionSort(test);
//		bubbleSort(test);
//		System.out.println("4! is " + factorial(4));
		System.out.println("Lets do a quicksort of " + Arrays.toString(test));
		quickSort(test,0,test.length-1);
//		System.out.println("Starting with " + Arrays.toString(test));
//		System.out.println("ending with: " + Arrays.toString(mergeSort(test)));
	}
	
	static int count = 0;
	public static void quickSort(int[] array, int start, int end) {
		if(count < 100){
			count++;
			if(start == end)return;
			int pivotIndex = (end+start)/2;
			System.out.println("Attempting to quicksort array from " + 
					"" + start + " to " + end + ". The pivotIndex is " + pivotIndex + "\n" + Arrays.toString(array));
			int pivot = array[pivotIndex];
			int i = start;
			int j = end;
			while(i <= j){
				if(array[i] >= pivot && array[j] <= pivot){
					System.out.println("Swapping the " + array[i] + " and " + array[j]);
					swap(array, i, j);
					i++;
					j--;
				}
				if(array[i] <= pivot){
					i++;
				}
				if(array[j] > pivot){
					j--;
				}
			}
			quickSort(array, start, j);
			quickSort(array, j + 1, end);
			System.out.println("Result is: " + Arrays.toString(array));
		}
	}

	private static int factorial(int n) {
		if(n < 2){
			return 1;
		}
		return n*factorial(n-1);
	}

	public static void selectionSort(int[] array){
		for(int i = 0; i < array.length; i++){//represents yellow 2 ms
			int indexOfTempMin = i; // represents red 1 ms -> 1 ms
			for(int j = i; j < array.length; j++){//represents blue 2 ms
				if(array[j] < array[indexOfTempMin]){ //1 ms
					indexOfTempMin = j; // 1 ms
					//System.out.println("index " + i + " and indexOfTempMin = " + indexOfTempMin); 
				}
			}
			//System.out.println(Arrays.toString(array));
			swap(array, i, indexOfTempMin); //3 ms
			//System.out.println("we swap " + i + " and " + indexOfTempMin + " resulting in " + Arrays.toString(array));
		}
	}//n^2
	
	public static void bubbleSort(int[] array){
		System.out.println(Arrays.toString(array));
		for(int i = 1; i < array.length - 1; i++){//
			for(int j = 0; j < array.length - i; j++){//
				if(array[j+1] < array[j]){
					swap(array, j, j+1);
					System.out.println("we swap " + j + " and " + ( j + 1 ) + " resulting in " + Arrays.toString(array));
				}
				System.out.println(j);
			}
		}		
	}//n^2 O(n^2)
	
	public static int[] merge(int[] a, int[] b){
		int i = 0;
		int j = 0;
		int k = 0;//index in result
		int[] result = new int[a.length + b.length];
		while(i < a.length && j < b.length){
			if(a[i] <= b[j]){
				result[k] = a[i];
				i++;
			}
			else{
				result[k] = b[j];
				j++;
			}
			k++;
		}
		while(i < a.length){
			result[k] = a[i];
			k++;
			i++;
		}
		while(j < b.length){
			result[k] = b[j];
			k++;
			j++;
		}
		return result;
	}
	
	public static int[] mergeSort(int[] array){
		if(array.length == 1){
			return array;
		}
		int half = (array.length)/2;
		int[] half1 = new int[half];
		int[] half2 = new int[array.length-half];
		//Copy elements from the first half of the array
		for(int i = 0; i < half1.length; i++){
			half1[i] = array[i];
		}
		//Copy elements from the second half of the array
		for(int j = 0; j < half2.length; j++){
			half2[j] = array[j+half];
		}
		System.out.println(Arrays.toString(half1) + " and " + Arrays.toString(half2));
		return merge(mergeSort(half1), mergeSort(half2));
	}
	
	public static void swap(int[] array, int a, int b) {
		int placeholder = array[a]; // 1 ms
		array[a] = array[b]; // 1 ms
		array[b] = placeholder; // 1 ms
	}
}
