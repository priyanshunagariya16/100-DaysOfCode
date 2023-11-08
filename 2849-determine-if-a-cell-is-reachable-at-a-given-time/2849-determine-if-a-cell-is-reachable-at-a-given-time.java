class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
            return Math.abs(sx - fx) <= t && Math.abs(sy - fy) <= t && (t != 1 ||sx != fx || sy != fy);
        }
    }