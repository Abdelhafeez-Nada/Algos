
// public int threeSumClosest(int[] nums, int target) {
//         Arrays.sort(nums);
//         int ans = 2147483647;
//         int ruturnedRes=0;
//         int res;
//         for(int i=0;i<nums.length-2;i++)
//         {
//             if( i>0 && nums[i] == nums[i-1] )
//                 continue;

//             int left = i+1;
//             int right = nums.length-1;
//             while ( right > left)
//             {
//                 res = nums[left] + nums[right] + nums[i];
//                 if(ans > Math.abs(res-target))
//                 {
//                     ans = Math.abs(res-target);
//                     ruturnedRes = res;
//                 }

//                 if(res == target)
//                     break;

//                 if(res < target)
//                     left++;
//                 else
//                     right--;
//             }
//         }
//         return ruturnedRes;
//     }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int ans = threeSumClosest(new int[] { -1000, -5, -5, -5, -5, -5, -5, -1, -1, -1 }, -14);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int temp = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == target)
                    return currentSum;
                // if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                // closestSum = currentSum;
                // }
                if (temp > Math.abs(target - currentSum)) {
                    closestSum = currentSum;
                    temp = Math.abs(target - currentSum);
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

}
