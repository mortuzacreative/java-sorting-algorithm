import java.util.Random;

public class InsertionSort {

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

	public static int[] doInsertionSort(int[] input) {

		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

	public static void main(String a[]) {
		int[] arr1 = randomNumGenerate();
		arr1 = doInsertionSort(arr1);
		for (int i : arr1) {
			System.out.println(i);
		}
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("Sorting time: " + time);
	}

}
