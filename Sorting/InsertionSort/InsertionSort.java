public class InsertionSort{
	public static void main(String args[]){
		int[] arr = { 4, 1, 3, 9, 7};
		System.out.println("Array before sorting:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" , ");
		sort(arr,arr.length);
		System.out.println();
		System.out.println("Array after sorting:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" , ");
	}
	public static void sort(int[] arr,int n){
		if(n==1)
			return;
		sort(arr,n-1);
		for(int j=n-1;j>0;j--)
		{
			if(arr[j]<arr[j-1])
			{
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
	}

}