package sort;



public class VariableSort {
	
	public static void main(String[] args) {
		int[] array = new int[] {3, 6, 2, 1, 0, 8, 4, 56, 34, 21};
		int[] arr1 = InsertSort(array);
		int[] arr2 = BubbleSort(array);
		int[] arr3 = SelectSort(array);
		int[] arr4 = QuickSort(array, 0, array.length-1);
		int[] arr5 = mergeSort(array, 0, array.length-1);
		//int[] arr = arr5;
		String str = "2329din979sddsi9";
		String[] arr = str.split("[a-z]+");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//System.out.println(binarySearch(arr5, 8, 0, array.length));
	}

	/**
	 * 冒泡排序
	 * @param array
	 * @return
	 */
	public static int[] BubbleSort(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for(int j=i; j<array.length-1; j++) {
				//跟相邻的比较
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	public static int[] InsertSort(int[] array) {
		for (int i=1; i<array.length-1; i++) {
			int temp = array[i];
			int j = i - 1;
			// 要是比前面的小，那就不停的交换，直到到正确的位置
			while(j >= 0 && array[j] > temp){
				array[j + 1] = array[j];
				j--;
			}
			// 最后停的位置
			if(j != i - 1){
				array[j + 1] = temp;		
			}
		}
		return array;
	}

	/**
	 * 选择排序
	 * @param array
	 * @return
	 */
	public static int[] SelectSort(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			int minIndex = i;
			for(int j=i; j<array.length-1; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			//选出最小的，做交换
			if(minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}	
		}
		return array;
	}

	/**
	 * 希尔排序，将序列分成子序列，对子序列分别排序，然后将子序列合并起来
	 * @param array
	 * @return
	 */
	public static int[] ShellSort(int[] array) {
		
		for (int step = array.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < array.length; i++) {

                int j = i;
                int temp = array[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && array[j - step] > temp) {
                    array[j] = array[j - step];
                    j = j - step;
                }
                array[j] = temp;
            }
        }
        return array;
	}

	/**
	 * 快速排序
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] QuickSort(int[] array, int left, int right){
		int index = partition(array, left, right);
		if(left < index - 1){
			//index是最后返回的left值
			QuickSort(array, left, index - 1);
		}
		if(index+1 < right){
			QuickSort(array, index, right);
		}
		return array;
	}
	
	private static int partition(int[] array, int left, int right){
		int pivot = array[(left + right) / 2];
		int temp;
		
		while(left < right){
			while(array[left] < pivot) left++;
			while(array[right] > pivot) right--;

			//在左边找到了比它大的，在右边找到了比它小的
			if(left < right){
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

	private static void merge(int []array,int left,int mid,int right){
        int []tmp=new int[array.length];//辅助数组
        
        int p1=left, p2=mid+1, k=left;//p1、p2是检测指针，k是存放指针

        while(p1<= mid && p2<=right){
            if(array[p1] <= array[p2])
                tmp[k++] = array[p1++];
            else
                tmp[k++] = array[p2++];
        }

        while(p1<=mid) tmp[k++]=array[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=array[p2++];//同上

        //复制回原数组
        for (int i = left; i <=right; i++) 
        	array[i]=tmp[i];
    }

	/**
	 * 归并排序
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
    public static int[] mergeSort(int [] array,int start,int end){
        if(start < end){//当子序列中只有一个元素时结束递归
            int mid=(start + end)/2;//划分子序列
            mergeSort(array, start, mid);//对左侧子序列进行递归排序
            mergeSort(array, mid+1, end);//对右侧子序列进行递归排序
            merge(array, start, mid, end);//合并
        }
		return array;
    }

    
    public static int binarySearch(int[] array, int key, int start, int end) {
    	int mid = (start+end)/2;
    	System.out.println(mid);
    	if (key < array[mid]) {
    		System.out.println("a");
    		return binarySearch(array, key, start, mid);
		}else if(key > array[mid]){
			System.out.println("b");
			return binarySearch(array, key, mid, end);
		}else {
			return mid;
		}
    }
    	
}

