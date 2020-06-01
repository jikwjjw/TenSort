package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆； 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * 
 * @author ji 堆排序的基本思想是： 将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 *         将其与末尾元素进行交换，此时末尾就为最大值。 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
 *         如此反复执行，便能得到一个有序序列了
 * 
 *         一般升序采用大顶堆，降序采用小顶堆 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *         小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */
public class HeapSort {
	public int[] heapSort(int[] arr) {
		// 1.构建大顶堆
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			// 从第一个非叶子节点开始，从下至上，从右至左调整结构
			adjustHeap(arr, i, arr.length);
		}
		// 2.调整堆结构+交换堆顶元素与末尾元素
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			// 重新对堆进行调整
			adjustHeap(arr, 0, i);
		}
		return arr;
	}

	public void adjustHeap(int[] arr, int parent, int length) {
		// 将temp作为父节点
		int temp = arr[parent];
		// 左孩子
		int lChild = 2 * parent + 1;
		while (lChild < length) {
			// 右孩子节点
			int rChild = lChild + 1;
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			if (rChild < length && arr[lChild] < arr[rChild]) {
				lChild++;
			}
			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if (temp >= arr[lChild]) {
				break;
			}
			// 把孩子结点的值赋给父结点
			arr[parent] = arr[lChild];
			// 选取孩子结点的左孩子结点,继续向下筛选
			parent = lChild;
			lChild = 2 * lChild + 1;
		}
		arr[parent] = temp;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(heapSort(arr)));
	}
}
