package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 希尔排序又称缩小增量排序，实际上是一种分组插入排序
 * 
 * @author ji
 *         先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，
 *         取第二个增量d2<d1重复上述的分组和排序，直至所取的增量 =1( < …<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 */
public class ShellSort {
	public int[] shellSort(int[] arr) {
		for (int step = arr.length / 2; step > 0; step /= 2) {// 步长逐步减小
			// 对一个步长区间进行比较 [step,arr.length)
			for (int i = step; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				// j - step 就是代表与它同组隔壁的元素
				while (j - step >= 0 && arr[j - step] > temp) {
					arr[j] = arr[j - step];
					j = j - step;
				}
				arr[j] = temp;
			}
		}
		return arr;
	}

	@Test
	public void test() {
		int[] arr = { 10, 4, 3, 61, 2, 36, 5 };
		System.out.println(Arrays.toString(shellSort(arr)));
	}
}
