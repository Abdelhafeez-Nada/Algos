public class MergeSortII {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 3, 2, 1, 7, 4 };

        // merge(nums, 0, (nums.length - 1) / 2, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);

        for (int n : nums) {
            System.out.print(n + " ");
        }

    }

    private static void mergeSort(int[] nums, int low, int high) {

        if (!(low < high))
            return;
        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}
