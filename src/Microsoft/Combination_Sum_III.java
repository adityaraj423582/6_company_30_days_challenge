package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
