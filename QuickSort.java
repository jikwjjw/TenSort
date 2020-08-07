package letcode;

import java.util.Arrays;

public class QuickSort {
    /**
     * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * </p>
     *
     * @author ji
     * 先从队尾开始向前扫描且当low < high时,如果a[high] > tmp,则high–-,但如果a[high] < tmp,则将high的值赋值给low,即arr[low] = a[high],同时要转换数组扫描的方式,即需要从队首开始向队尾进行扫描了
     * 同理,当从队首开始向队尾进行扫描时,如果a[low] < tmp,则low++,但如果a[low] > tmp了,则就需要将low位置的值赋值给high位置,即arr[low] = arr[high],同时将数组扫描方式换为由队尾向队首进行扫描.
     * 不断重复①和②,知道low>=high时(其实是low=high),low或high的位置就是该基准数据在数组中的正确索引位置.
     */
    public static int[] quickSort(int[] array, int left, int right) {
        int low, high, flag, temp;
        if (left >= right) {
            return array;
        }
        low = left;
        high = right;
        flag = array[left];
        while (low < high) {
            //先从右边找
            while (array[high] >= flag && low < high) {
                high--;
            }
            //再从左边找
            while (array[low] <= flag && low < high) {
                low++;
            }
            //交换
            if (low < high) {
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        //一趟交换完将基准值放入临界位置
        array[left] = array[low];
        array[low] = flag;
        //向左递归
        quickSort(array, left, low);
        quickSort(array, low + 1, right);
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {55, 10, 35, 61, 89, 36, 1, 77};
        System.out.println(Arrays.toString(quickSort(arr, 0, 7)));
    }

}
