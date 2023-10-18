public class QuickSortII {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 1, 9, 3, 4, 6 };
        qs(nums, 0, nums.length - 1);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    private static void qs(int[] nums, int low, int high) {
        if (!(low < high))
            return;
        int partition = partition(nums, low, high);
        qs(nums, low, partition - 1);
        qs(nums, partition + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        while (left < right) {
            while (!(nums[left] > nums[low]) && left < high)
                left++;
            while (!(nums[right] <= nums[low]) && right > low)
                right--;
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, low, right);
        return right;
    }

    private static void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
