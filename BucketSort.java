package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * 设置一个定量的数组当作空桶；
 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 对每个不是空的桶进行排序；
 * 从不是空的桶里把排好序的数据拼接起来。 
 * @author ji
 *
 */
public class BucketSort {
	public  int[] bucketSort(int[] arr) {

		int max = arr[0];
		int min = arr[0];
		int[] sorted = new int[arr.length];//排序数组
		ArrayList<Integer> aList = new ArrayList<>(); //终集合
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 桶数
		int bucketNum = (max - min) / arr.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
		for (int i = 0; i < bucketArr.size(); i++) {
			for (int j = 0; j < bucketArr.get(i).size(); j++) {
				aList.add(bucketArr.get(i).get(j));
			}
		}
		for(int i =0;i<aList.size();i++){
			sorted[i] = aList.get(i);
		}
		return sorted;
	}

	@Test
	public void test() {
		int[] arr = { 1, 2, 3, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(bucketSort(arr)));
	}
}
