package sort;

import java.util.Arrays;

import org.junit.Test;

public class RadixSort {
	/**
	 * 先按数组每个数的个位数进行排序 再将十位数排序 再将百位数排序 以此类推 没有十位数百位数…的补0。 
	 * 当所有位上的数排完序后 整个数组就是有序的
	 * 
	 * @param arr
	 * 
	 * 基数排序是桶排序和计数排序的结合
	 * @return
	 */
	public int[] radixSort(int[] arr) {
		// 待排序列最大值
		int max = arr[0];
		// 指数
		int exp;
		// 计算最大值
		for (int i1 : arr) {
			if (i1 > max) {
				max = i1;
			}
		}
			// 从个位开始，对数组进行排序
			for (exp = 1; max / exp > 0; exp *= 10) {
				// 存储待排元素的临时数组
				int[] temp = new int[arr.length];
				// 分桶个数
				int[] buckets = new int[10];

				// 将数据出现的次数存储在buckets中
				for (int value : arr) {
					// (value / exp) % 10 :value的最底位
					buckets[(value / exp) % 10]++;
				}

				//计数排序：
				
				// 更改buckets[i]，
				for (int i = 1; i < 10; i++) {
					buckets[i] += buckets[i - 1];
				}

				// 将数据存储到临时数组temp中
				for (int i = arr.length - 1; i >= 0; i--) {
					temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
					buckets[(arr[i] / exp) % 10]--;
				}

				// 将有序元素temp赋给arr
				System.arraycopy(temp, 0, arr, 0, arr.length);
			}
		return arr;
	}
	@Test
	public void test() {
		int[] arr ={63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};
		System.out.println(Arrays.toString(radixSort(arr)));
	}
}
