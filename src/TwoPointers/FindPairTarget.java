package TwoPointers;

/**
 * Given a sorted array A (sorted in ascending order),
 * having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
 * {10, 20, 35,20,50 50, 75, 80}
 * {10, 20, 20, 35,50, 50, 75, 80}
 * X = 70
 * output:
 * 1
 * @link https://www.geeksforgeeks.org/two-pointers-technique/
 *
 *
 * time complexity - O(n)
 * space complexity - O(1). // did not use any additional data structure.
 */
public class FindPairTarget {


  public int findCountOfPairSum(int[] arr, int target){

    int left = 0;
    int right = arr.length -1 ;
    int countOfPairs = 0;
    /**
     * why are we doing left < right ??
     *
     */
    while(left < right){
      int sum = 0;
      sum += arr[left];
      sum += arr[right];
      if(sum == target){
        countOfPairs += 1;
        left++;
        right --; // can't use same element twice so once two elements
        //are forming a pair , they cant be used again therefore its
        //safe to skip both of these.
      }
      else if(sum < target){
        left++;
      }else{
        right --;
      }


    }

    return countOfPairs;
  }


  public static void main(String args[]){

    FindPairTarget obj = new FindPairTarget();
    int[] arr = new int[]{10,20,20,35,50,50,75,80};
    System.out.println(obj.findCountOfPairSum(arr,70));
  }


}
