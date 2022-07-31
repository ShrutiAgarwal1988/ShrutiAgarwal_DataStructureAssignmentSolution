

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("Enter the total no of floors in the building : ");
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] Floors = new int[n];
			for (int i = 0; i < n; i++) {
				System.out.println("Enter the floor size given on day : " + (i + 1));
				int a = sc.nextInt();
			Floors[i] =a;
			}
			Problem1.calculatingFloors(Floors);
		}
	}

}