class Solution {
    public int minOperations(String s) {
        char[] a = s.toCharArray();
        char[] b = a.clone();
        Arrays.sort(b);
        if(Arrays.equals(a,b)) return 0;
        if(a.length == 2) return -1;
        if (a[0] == b[0] || a[a.length - 1] == b[b.length - 1])
        return 1;

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == b[0] || a[i] == b[b.length - 1]) return 2;
          
        }
    return 3;
    }
}