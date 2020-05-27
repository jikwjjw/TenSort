package sort;

import java.util.Arrays;
import org.junit.Test;

/**
 * 选择排序，从头至尾扫描序列，找出最小的一个元素，和第一个元素交换，接着从剩下的元素中继续这种选择和交换方式，最终得到一个有序序列
 * 
 * @author ji
 *
 */
public class SelectSort {
	public int[] selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			// 找出最小元素的下标
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(selectSort(arr)));
	}
}
