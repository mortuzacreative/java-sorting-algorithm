import java.util.Random;

public class BubbleSort {

	static double startTime = System.currentTimeMillis();

	public static int[] randomNumGenerate() {
		Random random = new Random();
		int index = 1000;
		int[] rndm = new int[index];
		for (int i = 0; i < rndm.length; i++) {
			int num = random.nextInt(index);
			rndm[i] = (num == 0) ? num + 1 : num;
		}
		return rndm;
	}

	// logic to sort the elements
	public static void bubble_srt(int array[]) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swapNumbers(i, k, array);
				}
			}
		}
	}

	private static void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

	}

	public static void main(String[] args) {
		int[] input = randomNumGenerate();
		bubble_srt(input);
		printNumbers(input);

		// -----calculate time cost................
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("Sorting time: " + time);

	}
}
