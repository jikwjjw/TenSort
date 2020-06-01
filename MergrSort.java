package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 二路归并
 * 分而治之(divide - conquer);每个递归过程涉及三个步骤
 * 第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
 * 第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
 * 第三, 合并: 合并两个排好序的子序列,生成排序结果.
 * @author ji
 *
 */
public class MergrSort {
	public int[] mergrSort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergrSort(arr, low, mid);
			mergrSort(arr, mid+1, high);
			// 合并
			merge(arr, low, mid, high);
		}
		return arr;
	}

	public void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		// 把右边剩余的数移入数组
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		// 把新数组中的数赋给arr数组
		for(int x=0;x<temp.length;x++){
			arr[x+low] =temp[x];
		}
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(mergrSort(arr, 0, arr.length-1)));
	}
}
