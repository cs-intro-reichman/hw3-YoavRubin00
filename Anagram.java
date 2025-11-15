import java.util.Arrays;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
    public static void main(String args[]) {
        // ... (main method remains the same)
    } 

    // Returns true if the two given strings are anagrams, false otherwise.
    public static boolean isAnagram(String str1, String str2) {
        String pStr1 = preProcess(str1);
        String pStr2 = preProcess(str2);

        if(pStr1.length() != pStr2.length()){
            return false;
        }
        
        if(pStr1.length() == 0){
             return true;
        }
        
        char[] chars1 = pStr1.toCharArray();
        char[] chars2 = pStr2.toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    // Returns a preprocessed version of the given string...
    public static String preProcess(String str) {
        String lowerCaseStr = str.toLowerCase();
        
        // 1. הסר את כל מה שאינו אות או רווח
        String cleanedWithSpaces = lowerCaseStr.replaceAll("[^a-z ]", ""); 
        
        // 2. הסר את הרווחים הנותרים (כדי לעמוד בדרישת הדוגמה ובדיקות האנגרמות)
        return cleanedWithSpaces.replaceAll(" ", "");
    } 
        
    // Returns a random anagram of the given string.
    public static String randomAnagram(String str) {
        if(str == null || str.length() < 2){
            return str;
        }
        char[] chars = str.toCharArray();
        Random random = new Random();
        for(int i = chars.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}