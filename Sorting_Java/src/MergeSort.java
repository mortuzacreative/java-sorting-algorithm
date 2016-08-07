import java.util.Random;

public class MergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	static double startTime = System.currentTimeMillis();

	public static int[] randomNumGenerate() {
		Random random = new Random();
		int index = 100000;
		int[] rndm = new int[index];
		for (int i = 0; i < rndm.length; i++) {
			int num = random.nextInt(index);
			rndm[i] = (num == 0) ? num + 1 : num;
		}
		return rndm;
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}

	public static void main(String a[]) {

		int[] inputArr = randomNumGenerate();
		MergeSort mms = new MergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.println(i);
		}
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("Sorting time: " + time);
	}
}
