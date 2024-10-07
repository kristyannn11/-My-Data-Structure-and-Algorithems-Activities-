import java.util.Scanner;

public class LinearSrch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);							////Object, instance of a class

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }


        System.out.print("Enter the value to search using Linear Search: ");
        int target = sc.nextInt();

        int linearResult = linearSearch(array, target);
        System.out.println("Linear Search result: " +
            (linearResult != -1 ? "Found at index " + linearResult : "Not found"));
    }


    public static int linearSearch(int[] array, int target) {			//Nag Create og function nga linearSearch
			for (int i = 0 ; i < array.length; i++){					//Ang diri kay loop ni bai, kahibaw naka ani bai kay batak kayka
				if (array[i] == target) {
					return i;
				}
			}
			return -1;													//Empty
		}
	}