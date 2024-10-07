//mga class ni diri boss
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String [] args){

		//mao ni katong scanner maong maka type
		Scanner sc = new Scanner(System.in);

		//Mangayo og pila kabuok ibutang ni bossing
		System.out.print("Enter size of the number: ");
		int number = sc.nextInt();

		// diri kay murag mangayog sa gi specified nga gi butang ni bossing
		int[] array = new int[number];

				//Mangayo og unsay ipa sort ni bossing
		        System.out.println("Numbers to be be sorted: ");

		       //loop ni bossing
		       for (int i = 0; i < number; i++) {
		            array[i] = sc.nextInt();
        }

//mo call selectionSort kay naas void
selectionSort(array);


		//diri dapita kay mao naning sorted nga array, nag looping rapud
        System.out.print("Sorted arrays: ");
        for (int i = 0; i < array.length; i++) {
		            System.out.print(array[i] + " ");
        }

}

//Method sa selectionSort
public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // mo swap sa makita nga minimun nga element sa first element
            int temp = array[minIndex];
           	 	array[minIndex] = array[i];
           	 	array[i] = temp;
        }

    }

}
