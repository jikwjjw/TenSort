package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 基本思想：每一步将一个待排序的数据插入到前面已经排好序的有序序列中，直到插完所有元素为止。
 * 
 * @author ji
 *
 */
public class InsertSort {
	public int[] insertSort(int[] arr) {
		// 默认第0个元素有序的
		for (int i = 1; i < arr.length; i++) {
			// 待排元素小于有序序列的最后一个元素时，向前插入
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		return arr;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(insertSort(arr)));
	}
}
