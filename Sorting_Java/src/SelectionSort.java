import java.util.Random;

public class SelectionSort {

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

	public static int[] doSelectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}

	public static void main(String a[]) {

		int[] arr1 = randomNumGenerate();
		int[] arr2 = doSelectionSort(arr1);
		for (int i : arr2) {
			System.out.println(i);
		}

		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("Sorting time: " + time);
	}
}
