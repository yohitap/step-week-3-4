
public class RiskThresholdLookup {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: threshold=" + target + " → found at index " + i + " (" + comparisons + " comps)");
                return i;
            }
        }
        System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comps)");
        return -1;
    }

    static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;
        int comparisons = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Insertion index for " + target + ": " + low + " (" + comparisons + " comps)");
        return low;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Floor(" + target + "): " + result + " (" + comparisons + " comps)");
        return result;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Ceiling(" + target + "): " + result + " (" + comparisons + " comps)");
        return result;
    }

    public static void main(String[] args) {
        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        linearSearch(unsorted, 30);

        binaryInsertionPoint(sorted, 30);
        floor(sorted, 30);
        ceiling(sorted, 30);
    }
}