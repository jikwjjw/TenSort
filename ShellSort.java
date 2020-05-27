package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ϣ�������ֳ���С��������ʵ������һ�ַ����������
 * 
 * @author ji
 *��ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼���顣���о���Ϊd1�ı����ļ�¼����ͬһ�����С����ڸ����ڽ���ֱ�Ӳ�������Ȼ��
 *ȡ�ڶ�������d2<d1�ظ������ķ��������ֱ����ȡ������ =1( < ��<d2<d1)�������м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ��
 */
public class ShellSort {
	public int[] shellSort(int[] arr) {
		for (int step = arr.length / 2; step > 0; step /= 2) {// �����𲽼�С
			 //��һ������������бȽ� [step,arr.length)
			for (int i = step; i < arr.length; i++) {
				int value = arr[i];
				int j;
				// �Բ��������о����Ԫ�ؽ��бȽ�
				for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
					// jΪ�������ȡֵ��j+stepΪ��������������Ķ�Ӧֵ��
					arr[j + step] = arr[j];
				}
				// ��ʱstepΪһ��������[j + step]Ϊ�������ϵĳ�ʼ����ֵ
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
