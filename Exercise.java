public class Exercise {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        Map<Integer, List<Integer[]>> map = new HashMap<>();
        List<Integer[]> result = new LinkedList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // Sum of the first 2 numbers
                int sum = array[i] + array[j];
                // Difference between the target sum and the sum of the first 2 numbers
                int diff = targetSum - sum;
                if (map.containsKey(diff)) {
                    List<Integer[]> pairs = map.get(diff);
                    for (Integer[] pair : pairs) {
                        result.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int sum = array[i] + array[k];
                if (!map.containsKey(sum)) {
                    map.put(sum, new LinkedList<>());
                }
                map.get(sum).add(new Integer[] {array[i], array[k]});
            }
        }
        return result;
    }

}
