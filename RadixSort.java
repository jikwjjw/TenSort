package sort;

import java.util.Arrays;

import org.junit.Test;

public class RadixSort {
	/**
	 * �Ȱ�����ÿ�����ĸ�λ���������� �ٽ�ʮλ������ �ٽ���λ������ �Դ����� û��ʮλ����λ�����Ĳ�0�� 
	 * ������λ�ϵ���������� ����������������
	 * 
	 * @param arr
	 * 
	 * ����������Ͱ����ͼ�������Ľ��
	 * @return
	 */
	public int[] radixSort(int[] arr) {
		// �����������ֵ
		int max = arr[0];
		// ָ��
		int exp;
		// �������ֵ
		for (int i1 : arr) {
			if (i1 > max) {
				max = i1;
			}
		}
			// �Ӹ�λ��ʼ���������������
			for (exp = 1; max / exp > 0; exp *= 10) {
				// �洢����Ԫ�ص���ʱ����
				int[] temp = new int[arr.length];
				// ��Ͱ����
				int[] buckets = new int[10];

				// �����ݳ��ֵĴ����洢��buckets��
				for (int value : arr) {
					// (value / exp) % 10 :value�����λ
					buckets[(value / exp) % 10]++;
				}

				//��������
				
				// ����buckets[i]��
				for (int i = 1; i < 10; i++) {
					buckets[i] += buckets[i - 1];
				}

				// �����ݴ洢����ʱ����temp��
				for (int i = arr.length - 1; i >= 0; i--) {
					temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
					buckets[(arr[i] / exp) % 10]--;
				}

				// ������Ԫ��temp����arr
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
