class Solution {
    private static final Map<Integer, Integer> CACHE = new HashMap<>();
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0; // base cases
        if (n == 1) return 1;
        if (CACHE.containsKey(n)) return CACHE.get(n); // memoization
        int s = ((int) (Math.log(n) / Math.log(2))); // java way of calculating base 2 log
        int mask = (1 << s) - 1, xorMask = 1 << (s - 1);
        int res = minimumOneBitOperations((n & mask) ^ xorMask) + minimumOneBitOperations(xorMask) + 1; // recursive step
        CACHE.put(n, res); // memoize
        return res;
    }
}