package sort;

import java.util.Arrays;
import org.junit.Test;

/**
 * ѡ�����򣬴�ͷ��βɨ�����У��ҳ���С��һ��Ԫ�أ��͵�һ��Ԫ�ؽ��������Ŵ�ʣ�µ�Ԫ���м�������ѡ��ͽ�����ʽ�����յõ�һ����������
 * 
 * @author ji
 *
 */
public class SelectSort {
	public int[] selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			// �ҳ���СԪ�ص��±�
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
