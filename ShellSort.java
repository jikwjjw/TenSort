package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 希尔排序又称缩小增量排序，实际上是一种分组插入排序
 * 
 * @author ji
 *先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，
 *取第二个增量d2<d1重复上述的分组和排序，直至所取的增量 =1( < …<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 */
public class ShellSort {
	public int[] shellSort(int[] arr) {
		for (int step = arr.length / 2; step > 0; step /= 2) {// 步长逐步减小
			 //对一个步长区间进行比较 [step,arr.length)
			for (int i = step; i < arr.length; i++) {
				int value = arr[i];
				int j;
				// 对步长区间中具体的元素进行比较
				for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
					// j为左区间的取值，j+step为右区间与左区间的对应值。
					arr[j + step] = arr[j];
				}
				// 此时step为一个负数，[j + step]为左区间上的初始交换值
				arr[j + step] = value;
			}
		}
		return arr;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(shellSort(arr)));
	}
}
