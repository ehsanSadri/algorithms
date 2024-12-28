package binaryTreeSearch;

public class BinarySearch {
    public static int iterativeBinSearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int recursiveBinSearch(int[] arr, int x, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] < x) {
            return recursiveBinSearch(arr, x, mid + 1, right);
        }
        return recursiveBinSearch(arr, x, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] items = {3, 5, 10, 12, 17, 21, 25, 28, 33, 36, 40, 44, 47, 50, 56, 64, 68, 70};

        int iterativeResult = iterativeBinSearch(items, 3);
        System.out.println("Index of 3 using iterative binary search: " + iterativeResult);

        int recursiveResult = recursiveBinSearch(items, 44, 0, items.length - 1);
        System.out.println("Index of 44 using recursive binary search: " + recursiveResult);
    }
}