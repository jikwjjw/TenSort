package sort;

import java.util.Arrays;

import javax.security.auth.kerberos.KerberosKey;

import org.junit.Test;

/**
 * ����˼�룺ÿһ����һ������������ݲ��뵽ǰ���Ѿ��ź�������������У�ֱ����������Ԫ��Ϊֹ��
 * 
 * @author ji
 *
 */
public class InsertSort {
	public int[] insertSort(int[] arr) {
		// Ĭ�ϵ�0��Ԫ�������
		for (int i = 1; i < arr.length; i++) {
			// ����Ԫ��С���������е����һ��Ԫ��ʱ����ǰ����
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		return arr;
	}

	@Test
	public void test() {
		int[] arr = { 1, 10, 35, 61, 89, 36, 55 };
		System.out.println(Arrays.toString(insertSort(arr)));
	}
}
