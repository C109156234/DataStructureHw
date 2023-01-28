import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={3,5,7,1,-1,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        int n=arr.length;
        //heap排序
        int last_node=n-1;
        int parent=(last_node-1)/2;
        for (int i = parent; i >= 0; i--){
            heapify(arr,i,n);
        }
        //最大值換到最後節點 i:節點索引
        for (int i = n-1; i >= 0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
//    i:父節點 ; n:有幾個節點
    public static void heapify(int[] arr,int i,int n){
        int childNode1=2*i+1;
        int childNode2=2*i+2;
        int max=i;
        if (childNode1 < n && arr[childNode1] > arr[max]){
            max=childNode1;
        }
        if (childNode2 < n && arr[childNode2] > arr[max]){
            max=childNode2;
        }
        if (max!=i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
        }
    }
}
