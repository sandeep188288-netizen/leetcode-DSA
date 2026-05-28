class Solution {
    public int maximumNumberOfStringPairs(String[] words) {

        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int pairs = 0;

        for(String word : words) {

            String rev = new StringBuilder(word).reverse().toString();

            if(map.containsKey(word) && map.containsKey(rev)) {

                if(!word.equals(rev)) {
                    pairs++;
                }
            }
        }

        return pairs / 2;
    }
}