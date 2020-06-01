package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * ����һ�����������鵱����Ͱ��
 * �����������ݣ����Ұ�����һ��һ���ŵ���Ӧ��Ͱ��ȥ��
 * ��ÿ�����ǿյ�Ͱ��������
 * �Ӳ��ǿյ�Ͱ����ź��������ƴ�������� 
 * @author ji
 *
 */
public class BucketSort {
	public  int[] bucketSort(int[] arr) {

		int max = arr[0];
		int min = arr[0];
		int[] sorted = new int[arr.length];//��������
		ArrayList<Integer> aList = new ArrayList<>(); //�ռ���
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		// Ͱ��
		int bucketNum = (max - min) / arr.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// ��ÿ��Ԫ�ط���Ͱ
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// ��ÿ��Ͱ��������
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
