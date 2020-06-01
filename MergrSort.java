package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ��·�鲢
 * �ֶ���֮(divide - conquer);ÿ���ݹ�����漰��������
 * ��һ, �ֽ�: �Ѵ������ n ��Ԫ�ص����зֽ������������, ÿ�������а��� n/2 ��Ԫ��.
 * �ڶ�, ����: ��ÿ�������зֱ���ù鲢����MergeSort, ���еݹ����
 * ����, �ϲ�: �ϲ������ź����������,����������.
 * @author ji
 *
 */
public class MergrSort {
	public int[] mergrSort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergrSort(arr, low, mid);
			mergrSort(arr, mid+1, high);
			// �ϲ�
			merge(arr, low, mid, high);
		}
		return arr;
	}

	public void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		// �ѽ�С�������Ƶ���������
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// �����ʣ�������������
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		// ���ұ�ʣ�������������
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		// ���������е�������arr����
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
