package sort;

import java.util.Arrays;

import org.junit.Test;

public class CountSort {
	public int[] countSort(int[] arr) {
		int max = getMax(arr);   // 获取数组的最大值，数组所有值都在0 - max之间
		// 创建一个max+1大小的数组用于表示从0 - max所有数字的重复次数
		int[] countArray = new int[max + 1];
		int[] resultArray = new int[arr.length];
		// 因为countArray的下标代表array中的数字，而值代表array中元素的出现次数，所以countArray[array[i]]++
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]]++;
		}
		// 将countArray中的每一个元素变成与前一个元素相加的和,统计每一个元素前面有多少个小于它的元素
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
		}
		 for(int i=arr.length-1;i>=0;i--)//遍历arr数组，构造result数组
	        {
	            resultArray[countArray[arr[i]]-1]=arr[i];//将arr中该元素放到数组resultArray中指定的位置
	            countArray[arr[i]]--;//将countArray中该元素-1，方便存放下一个同样大小的元素
	            
	        }
		 return resultArray;
	}

	public int getMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				throw new RuntimeException("数组中有数小于0");
			}
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(countSort(arr)));
	}
}
