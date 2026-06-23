import java.util.*;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : target.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;

        for (char c : tMap.keySet()) {
            int available = sMap.getOrDefault(c, 0);
            int needed = tMap.get(c);
            ans = Math.min(ans, available / needed);
        }

        return ans;
    }
}