import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] array = {1,-34,67,45,32,0};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int first, int last){
        if (array.length==0){
            return;
        }
        int i=first,j=last;
        int pivot=array[(first+last)/2];

        while (i<=j){
            while (array[i] < pivot){i++;};
            while (array[j] > pivot){j--;};

            if (i<=j){ //不加上等號指標不能前進
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }

            if (first<j) {quickSort(array,first,j);}
            if (i<last) {quickSort(array,i,last);}
        }



    }
}
