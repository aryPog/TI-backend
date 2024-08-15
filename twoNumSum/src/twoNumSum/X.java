package twoNumSum;
import java.util.Scanner;

class X {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num_one, num_two, sum;
		System.out.println("Write me a Integer: ");
		num_one = sc.nextInt();
		System.out.println("Write me another Integer: ");
		num_two = sc.nextInt();
		
		sum = num_one + num_two;
		
		System.out.println("The sum is: " + sum);
	}
}
