package com.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        //如果数组为空或者数组元素小于3
        if (nums == null || nums.length < 3) {
            return threeSum;
        }
        //对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果nums[i] > 0 因为数组已经有序，加上后面的数一定不等于0
            if (nums[i] > 0 )
                return threeSum;
            //去除重复的值
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == 0) {
                    int [] arr = new int[]{nums[i], nums[l], nums[r]};
                    threeSum.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //判断左界是否和下一位置重
                    while (l < r && nums[l] == nums[l + 1])
                        l = l + 1;
                    //判断右界是否和下一位置重
                    while (l < r && nums[r] == nums[r -1])
                        r = r - 1;
                    l = l + 1;
                    r = r - 1;
                } else if (tmp > 0) { //说明nums[r]太大， r左移
                    r = r - 1;
                } else {
                    l = l + 1;
                }
            }

        }
        return threeSum;
    }
}
