import java.util.*;

public class SumSubsets {

    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(asf);
            }
            return;
        }

        // Include current element
        printTargetSumSubsets(arr, idx + 1, asf + arr[idx] + ", ", sos + arr[idx], tar);

        // Exclude current element
        printTargetSumSubsets(arr, idx + 1, asf, sos, tar);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int tar = sc.nextInt();

        printTargetSumSubsets(arr, 0, "", 0, tar);
    }
}
