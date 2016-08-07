import java.util.Random;

public class HeapSort {
	private static int[] a;
	private static int n;
	private static int left;
	private static int right;
	private static int largest;

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

	public static void buildheap(int[] a) {
		n = a.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	public static void maxheap(int[] a, int i) {
		left = 2 * i;
		right = 2 * i + 1;
		if (left <= n && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			exchange(i, largest);
			maxheap(a, largest);
		}
	}

	public static void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void sort(int[] a0) {
		a = a0;
		buildheap(a);

		for (int i = n; i > 0; i--) {
			exchange(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
	}

	public static void main(String[] args) {

		int[] a1 = randomNumGenerate();
		sort(a1);
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i] + " ");
		}

		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("\n" + "Total time cost:" + time);
	}
}
