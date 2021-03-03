package arithmetic;

import org.junit.Test;

/**
 * Description
 * Create by flame
 * Date 2021/3/3 9:56
 */
public class BinarySearch {



    public int binarySerach(int[] arr, int val) {

        while (true) {
            int middle = arr.length / 2;
            if(middle!=0&&arr.length%2==1){
                middle += 1;
            }
            int midVal = arr[middle];
            if (middle == 0 && midVal != val) {
                return -1;
            }
            if (midVal == val) {
                return middle;
            } else if (midVal > val) {
                int[] arr1 = new int[middle - 1];
                for (int i = 0; i < middle - 1; i++) {
                    arr1[i] = arr[i];
                }
                arr = arr1;
            } else if (midVal < val) {
                int[] arr1 = new int[arr.length - middle-1];

                for (int i = middle+1,j=0; i < arr.length; i++,j++) {
                    arr1[j] = arr[i];
                }
                arr = arr1;
            }

        }
    }

    @Test
    public void test() {
        int[] arr=new int[]{2,3,6,7,8,12,23,35,78};
        System.out.println(binarySerach2(arr,78));
    }

    public int binarySerach2(int[] arr, int val) {

            int middle = arr.length ;
            int start=0;
            int end=arr.length-1;
            int count=0;
        while (true) {
            System.out.println("##########"+(count++));
            middle = start+(end-start+1)/2;

            int midVal = arr[middle];
            if (middle == 0 && midVal != val||middle>arr.length-1||middle<0) {
                return -1;
            }
            if (midVal == val) {
                return middle;
            } else if (midVal > val) {
                 end=middle-1;
            } else if (midVal < val) {
                start=middle;
            }

        }
    }
}
