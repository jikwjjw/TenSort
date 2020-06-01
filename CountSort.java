package sort;

import java.util.Arrays;

import org.junit.Test;

public class CountSort {
	public int[] countSort(int[] arr) {
		int max = getMax(arr);   // ��ȡ��������ֵ����������ֵ����0 - max֮��
		// ����һ��max+1��С���������ڱ�ʾ��0 - max�������ֵ��ظ�����
		int[] countArray = new int[max + 1];
		int[] resultArray = new int[arr.length];
		// ��ΪcountArray���±����array�е����֣���ֵ����array��Ԫ�صĳ��ִ���������countArray[array[i]]++
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]]++;
		}
		// ��countArray�е�ÿһ��Ԫ�ر����ǰһ��Ԫ����ӵĺ�,ͳ��ÿһ��Ԫ��ǰ���ж��ٸ�С������Ԫ��
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
		}
		 for(int i=arr.length-1;i>=0;i--)//����arr���飬����result����
	        {
	            resultArray[countArray[arr[i]]-1]=arr[i];//��arr�и�Ԫ�طŵ�����resultArray��ָ����λ��
	            countArray[arr[i]]--;//��countArray�и�Ԫ��-1����������һ��ͬ����С��Ԫ��
	            
	        }
		 return resultArray;
	}

	public int getMax(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				throw new RuntimeException("����������С��0");
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
