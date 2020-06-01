package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ���Ǿ����������ʵ���ȫ��������ÿ������ֵ�����ڻ���������Һ��ӽ���ֵ����Ϊ�󶥶ѣ� ����ÿ������ֵ��С�ڻ���������Һ��ӽ���ֵ����ΪС����
 * 
 * @author ji ������Ļ���˼���ǣ� �����������й����һ���󶥶ѣ���ʱ���������е����ֵ���ǶѶ��ĸ��ڵ㡣
 *         ������ĩβԪ�ؽ��н�������ʱĩβ��Ϊ���ֵ�� Ȼ��ʣ��n-1��Ԫ�����¹����һ���ѣ�������õ�n��Ԫ�صĴ�Сֵ��
 *         ��˷���ִ�У����ܵõ�һ������������
 * 
 *         һ��������ô󶥶ѣ��������С���� �󶥶ѣ�arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *         С���ѣ�arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */
public class HeapSort {
	public int[] heapSort(int[] arr) {
		// 1.�����󶥶�
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			// �ӵ�һ����Ҷ�ӽڵ㿪ʼ���������ϣ�������������ṹ
			adjustHeap(arr, i, arr.length);
		}
		// 2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			// ���¶Զѽ��е���
			adjustHeap(arr, 0, i);
		}
		return arr;
	}

	public void adjustHeap(int[] arr, int parent, int length) {
		// ��temp��Ϊ���ڵ�
		int temp = arr[parent];
		// ����
		int lChild = 2 * parent + 1;
		while (lChild < length) {
			// �Һ��ӽڵ�
			int rChild = lChild + 1;
			// ������Һ��ӽ�㣬�����Һ��ӽ���ֵ�������ӽ�㣬��ѡȡ�Һ��ӽ��
			if (rChild < length && arr[lChild] < arr[rChild]) {
				lChild++;
			}
			// ���������ֵ�Ѿ����ں��ӽ���ֵ����ֱ�ӽ���
			if (temp >= arr[lChild]) {
				break;
			}
			// �Ѻ��ӽ���ֵ���������
			arr[parent] = arr[lChild];
			// ѡȡ���ӽ������ӽ��,��������ɸѡ
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
