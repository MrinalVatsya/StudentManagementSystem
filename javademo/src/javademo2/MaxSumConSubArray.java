/**
 * 
 */
package javademo2;

import java.util.Scanner;

/**
 * @author mrinalvatsya
 *
 */
public class MaxSumConSubArray {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int i , n = in.nextInt();
	int arr[] = new int[n];
	for(i=0;i<n;i++)
	{
		arr[i] = in.nextInt();
	}
	int M[] = new int[n];//to store maximum sum subarray till that index 
	for(i = 0 ; i < n; i++)
	{
		M[i] = 0;
	}
	M[0] = Math.max(M[0], arr[0]);
	for(i=1;i<n;i++)
	{
		if(M[i-1]+ arr[i] > 0)
		{
			M[i] = Math.max(arr[i], M[i-1] + arr[i]);
		}
		else
			M[i] = 0;
	}
	int max = Integer.MAX_VALUE;
	for(i=0;i<n;i++)
	{
		if(M[i] < max)
			max = M[i];
	}
	System.out.println(max);
	}
}
