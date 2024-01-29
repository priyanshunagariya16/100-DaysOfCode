class Solution {

    private static final Map<Integer, String> MAP1 = new HashMap<>(){{
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
    }};
    private static final Map<Integer, String> MAP2 = new HashMap<>(){{
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
    }};
    private static final Map<Integer, String> MAP3 = new HashMap<>(){{
        put(10, "Ten");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
    }};
    private static final Map<Integer, String> MAP4 = new HashMap<>(){{
        put(1, "Thousand");
        put(2, "Million");
        put(3, "Billion");
        put(4, "Trillion");
    }};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String str = "";
        int count = 0;
        while (num > 0) {
            int value = num % 1000;
            if (count > 0) {
                if (value > 0) {
                    if (!str.isEmpty()) {
                        str = " " + str;
                    }
                    str = MAP4.get(count) + str;
                }
            }
            String cur = getThreeDigitWords(value);
            if (!cur.isEmpty()) {
                if (!str.isEmpty()) {
                    str = " " + str;
                }
                str = cur + str;
            }
            num /= 1000;
            count++;
        }
        return str;
    }

    private String getThreeDigitWords(int num) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return MAP1.get(num);
        } else if (num == 10) {
            return MAP3.get(num);
        } else if (num < 20) {
            return MAP2.get(num);
        } else {
            StringBuffer sb = new StringBuffer();
            int one = num % 10; // 3
            int two = (num % 100 - one) / 10; // 2
            int three = (num % 1000 - one - two * 10) / 100; // 1
            if (three > 0) {
                sb.append(MAP1.get(three));
                sb.append(" Hundred");
            }
            if (one == 0 && two == 0) {
                return sb.toString();
            } else if (one == 0) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(MAP3.get(two * 10));
            } else if (two == 0) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(MAP1.get(one));
            } else {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                if (two == 1) {
                    int value = two * 10 + one;
                    sb.append(MAP2.get(value));
                } else {
                    sb.append(MAP3.get(two * 10));
                    sb.append(" ");
                    sb.append(MAP1.get(one));
                }
            }
            return sb.toString();
        }
    }
}