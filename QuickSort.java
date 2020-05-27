package sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
 * Ȼ���ٰ��˷����������������ݷֱ���п�������
 * ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ����������
 * @author ji
 * �ȴӶ�β��ʼ��ǰɨ���ҵ�low < highʱ,���a[high] > tmp,��high�C,�����a[high] < tmp,��high��ֵ��ֵ��low,��arr[low] = a[high],ͬʱҪת������ɨ��ķ�ʽ,����Ҫ�Ӷ��׿�ʼ���β����ɨ����
 * ͬ��,���Ӷ��׿�ʼ���β����ɨ��ʱ,���a[low] < tmp,��low++,�����a[low] > tmp��,�����Ҫ��lowλ�õ�ֵ��ֵ��highλ��,��arr[low] = arr[high],ͬʱ������ɨ�跽ʽ��Ϊ�ɶ�β����׽���ɨ��.
 * ���ظ��ٺ͢�,֪��low>=highʱ(��ʵ��low=high),low��high��λ�þ��Ǹû�׼�����������е���ȷ����λ��.
 */
public class QuickSort {
	public int[] quickSort(int[] array,int left,int right){
		int low,high,flag,temp;
        if(left >= right){
            return array;
        }
        low = left;
        high = right;
        flag = array[left];
        while (low < high){
            //�ȴ��ұ���
            while (array[high] >= flag && low < high){
            	high --;
            }
            //�ٴ������
            while (array[low] <= flag && low < high){
            	low ++;
            }
            //����
            if(low < high){
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        //һ�˽����꽫��׼ֵ�����ٽ�λ��
        array[left] = array[low];
        array[low] = flag;
        //����ݹ�
        quickSort(array,left,low-1);
        quickSort(array,low+1,right);
		return array;
	}
	@Test
	public void test(){
		int[] arr ={1,10,35,61,89,36,55};
		System.out.println(Arrays.toString(quickSort(arr,0,6)));
	}
}
