package TwoPointers;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character
 * from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba" Output: true
 * <p>
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {

  public boolean checkPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return secondValidityCheck(s, left + 1, right) || secondValidityCheck(s, left, right - 1);
      }


    }
    return true;
  }

  private boolean secondValidityCheck(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return false;
      }

    }
    return true;

  }

  /**
   * recursive way of implementing the same function.
   *
   * @param left  start index.
   * @param right end index.
   * @param s     string.
   * @param count count of characters which are not forming part of Palindrome.
   * @return true if palindrome, else false.
   */
  public boolean checkPalindrome(int left, int right, String s, int count) {

    if (count > 1) {
      return false;
    }

    if (left >= right) {
      return true;
    }

    if (s.charAt(left) == s.charAt(right)) {
      return checkPalindrome(left + 1, right - 1, s, count);
    } else {
      count = count + 1;
      return checkPalindrome(left, right - 1, s, count) ||
          checkPalindrome(left + 1, right, s, count);
    }


  }


  public static void main(String args[]) {
    String s = "abba";
    ValidPalindrome obj = new ValidPalindrome();
    // System.out.println(obj.checkPalindrome(s));
    System.out.println(obj.checkPalindrome(0, s.length() - 1, s, 0));

  }


}
