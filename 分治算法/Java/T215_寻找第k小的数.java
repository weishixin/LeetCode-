package DivideAndConquer;

public class T215_Ѱ�ҵ�kС���� {
	
	//���ѽⷨ
	
	//�������ѣ�Ҫ��ÿ�����ڵ��ֵҪ���ڻ�����亢�ӽڵ��ֵ
	public void buildMaxHeap( int [] arr , int parent , int length){
		//lengthΪ����ĳ���
		int child = parent*2 +1; //parent������
		int temp = arr[parent];//���ڵ��ֵ������ʱ����,temp��ס��һ��ʼ�ĸ��ڵ�
		for (; child < length ; child = child*2 + 1){
			if ( child < length -1 && arr[child] < arr[child + 1]  ){
				//������ С�� �Һ���ʱ ����Ҫ�����ֵָ�� �Һ���
				child ++ ;
			}
			if ( arr[child] > temp){
				//�븸�ڵ�Ƚ�
				arr[parent] = arr[child];
				parent = child ;
				//�������滹�б��ʼ�ĸ��ڵ���������Ҫ��������������ֻ���µ�ǰ�Ѿ�������λ����������������̽��
			}
			else {
				break;
			}
			
		}
		arr[parent] = temp;//����ԭ���ĸ��ڵ�ŵ����ͣ����λ��
	}
	public void heapSort( int [] arr){
		//��������
		for ( int i = arr.length-1 ; i >= 0 ; i --){
			//�ӵ�����һ����Ҷ�ӽڵ�������󣬴������£����б�������������
			buildMaxHeap(arr, i, arr.length); 
		}
		//�������
		
		for( int j = arr.length-1 ; j > 0 ; j --){
			//����jҪ����0 ��Ϊ�˿��Խ���
			int t = arr[j];
			arr[j] = arr[0];
			arr[0] = t ;
			
			buildMaxHeap(arr, 0, j);//��ʼ�����root�ڵ�Ϊ���һ��Ԫ�ص�ֵ
		}
		
//		return 
		
	}
	
	//�ο����ӣ�https://blog.csdn.net/lpq1201/article/details/80690319
	public int findKthLargest(int[] nums, int k) {
		for ( int i = nums.length-1 ; i >= 0 ; i --){
			//�ӵ�����һ����Ҷ�ӽڵ�������󣬴������£����б�������������
			buildMaxHeap(nums, i, nums.length); 
		}

		int count = 0 ;
		int j = nums.length -1 ;
		while(count < k ){//count����������ֻ����ǰk��
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
		T215_Ѱ�ҵ�kС���� t = new T215_Ѱ�ҵ�kС����();
		int [] arr ={3,2,1,5,6,4};
//		t.heapSort(arr);
//		for ( int j : arr){
//			System.out.println(j);
//		}
		System.out.println(t.findKthLargest(arr, 2));
//		System.out.println(arr[arr.length-2]);
		
	}
}
