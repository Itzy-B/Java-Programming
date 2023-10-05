import java.util.*;
public class Scratch {
    public static void main(String[] args) {
        allNumsWithin(null, 0);
    }
    public static int allNumsWithin(int[] A, int k) {
        int[] count = new int[k];
        int left = 0;
        int uniqueCount = 0;
        int minLength = Integer.MAX_VALUE;
    
        for (int right = 0; right < A.length; right++) {
            if (A[right] >= 0 && A[right] < k && count[A[right]] == 0) {
                uniqueCount++;
            }
            count[A[right]]++;
    
            while (uniqueCount == k) {
                minLength = Math.min(minLength, right - left + 1);
    
                if (A[left] >= 0 && A[left] < k && count[A[left]] == 1) {
                    uniqueCount--;
                }
                count[A[left]]--;
                left++;
            }
        }
    
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
