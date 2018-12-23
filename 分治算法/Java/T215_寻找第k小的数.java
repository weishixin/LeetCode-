package DivideAndConquer;

public class T215_寻找第k小的数 {
	
	//最大堆解法
	
	//构造最大堆，要求每个父节点的值要大于或等于其孩子节点的值
	public void buildMaxHeap( int [] arr , int parent , int length){
		//length为数组的长度
		int child = parent*2 +1; //parent的左孩子
		int temp = arr[parent];//父节点的值赋给临时变量,temp记住了一开始的父节点
		for (; child < length ; child = child*2 + 1){
			if ( child < length -1 && arr[child] < arr[child + 1]  ){
				//当左孩子 小于 右孩子时 ，需要把最大值指向 右孩子
				child ++ ;
			}
			if ( arr[child] > temp){
				//与父节点比较
				arr[parent] = arr[child];
				parent = child ;
				//可能下面还有比最开始的父节点大的数，需要继续交换，这里只记下当前已经交换的位置索引，继续往下探索
			}
			else {
				break;
			}
			
		}
		arr[parent] = temp;//最后把原来的父节点放到最后停留的位置
	}
	public void heapSort( int [] arr){
		//构建最大堆
		for ( int i = arr.length-1 ; i >= 0 ; i --){
			//从倒数第一个非叶子节点从右至左，从上至下，进行遍历，构造最大堆
			buildMaxHeap(arr, i, arr.length); 
		}
		//构造完毕
		
		for( int j = arr.length-1 ; j > 0 ; j --){
			//这里j要大于0 ，为了可以交换
			int t = arr[j];
			arr[j] = arr[0];
			arr[0] = t ;
			
			buildMaxHeap(arr, 0, j);//初始情况下root节点为最后一个元素的值
		}
		
//		return 
		
	}
	
	//参考链接：https://blog.csdn.net/lpq1201/article/details/80690319
	public int findKthLargest(int[] nums, int k) {
		for ( int i = nums.length-1 ; i >= 0 ; i --){
			//从倒数第一个非叶子节点从右至左，从上至下，进行遍历，构造最大堆
			buildMaxHeap(nums, i, nums.length); 
		}

		int count = 0 ;
		int j = nums.length -1 ;
		while(count < k ){//count用来计数，只交换前k个
			int t = nums[j];
			nums[j] = nums[0];
			nums[0] = t ;
			
			buildMaxHeap(nums, 0 , j);
			j -- ;
			count ++;
		}

		return nums[nums.length-k];
    }
	public static void main(String args[]){
		T215_寻找第k小的数 t = new T215_寻找第k小的数();
		int [] arr ={3,2,1,5,6,4};
//		t.heapSort(arr);
//		for ( int j : arr){
//			System.out.println(j);
//		}
		System.out.println(t.findKthLargest(arr, 2));
//		System.out.println(arr[arr.length-2]);
		
	}
}
