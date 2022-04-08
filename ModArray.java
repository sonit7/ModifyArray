package array;
import java.util.Arrays;
import java.util.Scanner;

public class ModArray {
	/**1. array variables**/
	private int[] array;
	static Scanner scan;
	
	/**2. class constructors**/
	public ModArray() {
		array = new int[]{1,5,2,4,9,6};
	}
	
	public ModArray(int[] a) {
		array = a;
	}
	
	public ModArray(Scanner s) {
		scan = s;
		System.out.println("How many elements do you want in your array?");
		int size = scan.nextInt();
		array = new int[size];
		for(int i=0; i<array.length; i++) {
			System.out.println("Enter an element ");
			array[i] = scan.nextInt();
		}
		System.out.println("Here is your final array\n"+this.toString());
	}
	
	/**3. This method adds an element to the end of an array**/
	public void append(int e) {
		int temp[] = new int[array.length+1];
		for(int i=0; i<array.length; i++) {
			temp[i] = array[i];
		}
		temp[array.length] = e;
		array = temp;
	}

	/**4. This method adds an element to the inserted index of an array, shifting elements greater than or equal to the position rightward**/
	public void insert(int index, int e) {
		int[] temp = new int[array.length+1];
		int tempIndex = 0;
		for(int i=0; i<array.length; i++) {
			temp[tempIndex] = array[i];
			if(i==index-1) {
				tempIndex++;
				temp[tempIndex] = e;
			}
			tempIndex++;
		}
		array = temp;
	}
	
	/**5. This method removes an element from a specific index of an array, shifting elements greater than or equal to the position leftward**/
	public void pop(int index) {
		int[] temp = new int[array.length-1];
		if(index!=0) {
			int tempIndex = 0;
			for(int i=0; i<temp.length; i++) {
				temp[i] = array[tempIndex];
				if(i==index-1)
					tempIndex+=2;
				else
					tempIndex++;
			}
		}
		else {
			int tempIndex = 1;
			for(int i=0; i<temp.length; i++) {
				temp[i] = array[tempIndex];
				tempIndex++;
			}
		}
		array = temp;
	}
	
	/**6. This method removes the element at the last index of an array**/
	public void remove() {
		int[] temp = new int[array.length-1];
		for(int i=0; i<temp.length; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	
	/**7. toString method for displaying array **/
	public String toString() {
		String line = "";
		for(int i=0; i<array.length; i++) {
			line+=array[i]+" ";
		}
		return line;
	}
	
	/**8. Tester/Runner/Main Method**/
	public static void main(String[] args) {
		ModArray one = new ModArray();
		one.append(3);
		System.out.println(one);
		one.insert(1,8);
		System.out.println(one);
		one.pop(4);
		System.out.println(one);
		one.remove();
		System.out.println(one);
	}
}
