package meta;

public class Solution {

 public static boolean find(int[] arr){
   int n = arr.length;
   int zero = 0;
  for(int i = 0; i < n; i ++){
    if(Math.abs(arr[i]) >= 0 && Math.abs(arr[i]) < n){
     if(arr[i] == 0)
      zero = 1;
     arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
    }else{
     return false;
    }
  }
   if(zero == 0){
    return false;
   }
  for(int i =0 ; i < n; i++){
   if(arr[i] > 0) {
    return false;
   }
  }
  return true;
 }

 public static void main(String args[]){
  int[] arr = new int[]{0,1,5,2,4};
  System.out.println(find(arr));
 }
}
