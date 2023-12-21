import java.util.ArrayList;
import java.util.List;

public class A9_MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        mergSort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void mergSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergSort(arr, low, mid);
        mergSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        print(arr);
        int[] temp = new int[high - low + 1];
        int l = low;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= high) {
            if (arr[l] <= arr[r]) {
                temp[i++] = arr[l++];
            } else
                temp[i++] = arr[r++];
        }
        while (l <= mid)
            temp[i++] = arr[l++];
        while (r <= high)
            temp[i++] = arr[r++];

        for (int k = low; k <= high; k++) {
            arr[k] = temp[k - low];
        }

    }

    private static List<Integer> mergeSortDS(int[] arr, List<Integer> result) {

        if (arr.length == 1) {
            List<Integer> sub = new ArrayList<Integer>();
            sub.add(arr[0]);
            return sub;
        }

        List<int[]> subs = divide(arr);

        List<Integer> left = mergeSortDS(subs.get(0), result);

        List<Integer> right = mergeSortDS(subs.get(1), result);

        return mergeDS(result, left, right);

        // return result;
    }

    private static List<Integer> mergeDS(List<Integer> res, List<Integer> left, List<Integer> right) {

        int l = 0;
        int r = 0;
        List<Integer> temp = new ArrayList<>();
        while ((l < left.size() && r < right.size())) {
            if (left.get(l) <= right.get(r)) {
                temp.add(left.get(l));
                l++;
            } else {
                temp.add(right.get(r));
                r++;
            }
        }
        while (l < left.size()) {
            temp.add(left.get(l));
            l++;
        }
        while (r < right.size()) {
            temp.add(right.get(r));
            r++;
        }
        if (res.size() == 0)
            return temp;

        return mergeDS(new ArrayList<>(), res, temp);
    }

    private static List<int[]> divide(int[] arr) {
        int mid = (arr.length - 1) / 2;
        int[] left = new int[mid + 1];
        int[] right = new int[arr.length - left.length];
        int i = 0;
        while (i <= mid) {
            left[i] = arr[i];
            i++;
        }
        int j = 0;
        while (i < arr.length) {
            right[j] = arr[i];
            j++;
            i++;
        }
        List<int[]> subs = new ArrayList<>();
        subs.add(left);
        subs.add(right);
        return subs;

    }

    private static void print(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}
