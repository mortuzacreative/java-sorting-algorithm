import java.util.Random;

public class JustSort {
	static int[] numbers;

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

	// ------------------swap value----------------------
	public static void swap(int arrayValue, int value) {
		int temp = numbers[arrayValue];
		numbers[arrayValue] = numbers[value];
		numbers[value] = temp;

	}

	// ------------get Greatest Value-----------------
	public static int getMaxValue(int bCount) {
		int maxValue = 0;
		for (int j = 0; j < bCount; j++) {
			int currentValue = numbers[j];
			if (currentValue > maxValue) {

				maxValue = currentValue;
			}
		}
		return maxValue;
	}

	public static int[] sort(int[] value) {
		int count = numbers.length;
		for (int i = -count; i < count; i++) {
			int maxValue = getMaxValue(count);
			for (int j = 0; j < count; j++) {
				int indexValue = numbers[j];
				if (maxValue == indexValue) {
					swap(count - 1, j);
					break;
				}
			}
			count--;
		}
		return numbers;
	}

	public static void main(String[] args) {

		numbers = randomNumGenerate();
		sort(numbers);
		System.out.println("Sorting......");

		/// ------for print----
		for (int j : numbers) {
			System.out.println(numbers[j]);
		}

		// ----------------calculate time cost--------------
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("Execute cost: " + time);
	}

}
