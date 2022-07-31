import java.util.Arrays;
import java.util.Stack;

public class Problem1 {
	static boolean x;
	static boolean flag;

	public static void calculatingFloors(int[] a) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < a.length; i++) {
			x = true;
			int ai = a[i];
			for (int j = i; j < a.length; j++) {
				if (j == i) {
					continue;
				} else {
					int aj = a[j];
					if (ai >=aj) {
					x = true;
						continue;
					} else {
						x = false;
						stack.push(ai);
						break;
					}
				}
			}

			if (x == true) {
				try {
					Stack stacktmp = displayFloor(stack,ai,i,a);
					stack.clear();
					stack = (Stack<Integer>)stacktmp.clone();
					stacktmp.clear();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Day " + (i + 1) + " :");
			}
		}
	}

	public static Stack displayFloor(Stack stack, int currentFloor, int itr, int[] arrayFloor) {

		int[] arrayOfPoppedItems = new int[arrayFloor.length];
		int count = 0;

		System.out.print("Day " + (itr + 1) + " : " + currentFloor);
		Stack<Integer> stacktmp = new Stack<Integer>();
		boolean largestInStack;
		if (itr == arrayFloor.length - 1) {
			while (!stack.empty()) {
				int popFloor = (int) stack.pop();
				arrayOfPoppedItems[count++] = popFloor;
			}
			if (arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
					if (arrayOfPoppedItems[i] != 0) {
						System.out.print(" " + arrayOfPoppedItems[i]);
					}

				}
			}

			return stacktmp;
		} else {
			if (!stack.empty()) {
				while (!stack.empty()) {
					largestInStack = true;
					int popFloor = (int) stack.pop();
					for (int i = itr; i < arrayFloor.length; i++) {
						if (i == itr) {
							continue;
						}
						if (popFloor < arrayFloor[i]) {
							stacktmp.push(popFloor);
							largestInStack = false;
							break;
						} else {
							largestInStack = true;
						}
					}
					if (largestInStack == true) {
						arrayOfPoppedItems[count++] = popFloor;
					}
				}
			}
			if (arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
					if (arrayOfPoppedItems[i] != 0) {
						System.out.print(" " + arrayOfPoppedItems[i]);
					}
				}
			}

			return stacktmp;
		}
	}
}