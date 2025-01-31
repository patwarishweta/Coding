package Sorting.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1)
            return nums;
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        List<Integer> res = mergeHelper(list, 0, nums.length -1);
        return res.stream().mapToInt(i->i).toArray();
    }

    public static List<Integer> mergeHelper(List<Integer> nums, int left, int right) {
        if(left >= right)
            return nums;

        int mid = left + (right - left) / 2;

        List<Integer> leftList = new ArrayList<>(nums.subList(0, mid));
        List<Integer> rightList = new ArrayList<>(nums.subList(mid+1, right));

        return merge(leftList, rightList);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sortedList = new ArrayList<>();

        int leftIndex = 0, rightIndex =0;

        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex) <= right.get(rightIndex)) {
                sortedList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                sortedList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while(rightIndex < right.size()) {
            sortedList.add(right.get(rightIndex));
            rightIndex++;
        }

        while(leftIndex < left.size()) {
            sortedList.add(left.get(leftIndex));
            leftIndex++;
        }

        return sortedList;
    }
}
