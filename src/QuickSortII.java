public class QuickSortII {

    public static void main(String[] args) {

    }

    private static int partition(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        while (left < right) {
            while (!(nums[left] > nums[low]) && left <= high)
                left++;
            while (!(nums[right] <= nums[low]) && right >= low)
                right++;
            swap(nums, left, right);
        }
    }

    private static void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
