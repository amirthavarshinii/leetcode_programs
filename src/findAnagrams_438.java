import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAnagrams_438 {

  public List<Integer> findAnagrams(String s, String p) {

    // creating a map to store the frequency count in string p
    Map<Character,Integer> pMap = new HashMap<>();

    for(int i = 0; i < p.length(); i++){
      char c = p.charAt(i);
      pMap.put(c, pMap.getOrDefault(c,0)+1);
    } //o(p)




    // creating a map to store the frequencycount in string s
    // limiting to only storing upto length of p string
    // once it will that length I will remove the left most
    //character from the string.

    Map<Character,Integer> sMap = new HashMap<>();


    List<Integer> indices = new ArrayList<>();

    // iterating the s string and storing it in the map.
    int left = 0;
    for(int right = 0; right < s.length(); right++){ //O(s)
      char c = s.charAt(right);
      sMap.put(c, sMap.getOrDefault(c,0)+1);
      //whenever the length of the string becomes equal to the  p length
      // then we have to check if its an anagram.
      if(right - left + 1 == p.length()){
        if(pMap.equals(sMap)){
          indices.add(left);
        }
        char leftChar = s.charAt(left);
        sMap.put(leftChar, sMap.get(leftChar) -1);
        if(sMap.get(leftChar) == 0){
          sMap.remove(leftChar);
        }
        left++;
      }


    }


    return indices;

  }

  public static void main(String args[]){

    findAnagrams_438 obj = new findAnagrams_438();
    obj.findAnagrams("cbaebabacd","abc");

  }


}