import java.util.Arrays;
import java.util.Scanner;

public class CiclicRotation {
    //An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
    //
    //The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
    //
    //Write a function:
    //
    //class Solution { public int[] solution(int[] A, int K); }
    //
    //that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
    //
    //For example, given
    //
    //    A = [3, 8, 9, 7, 6]
    //    K = 3
    //the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    //
    //    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    //    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    //    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
    //For another example, given
    //
    //    A = [0, 0, 0]
    //    K = 1
    //the function should return [0, 0, 0]
    //
    //Given
    //
    //    A = [1, 2, 3, 4]
    //    K = 4
    //the function should return [1, 2, 3, 4]
    //
    //Assume that:
    //
    //N and K are integers within the range [0..100];
    //each element of array A is an integer within the range [−1,000..1,000].
    //In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=Integer.parseInt(sc.nextLine());
        int numsInArray=Integer.parseInt(sc.nextLine());
        if(isValidInput(k) && isValidInput(numsInArray)) {


            int[] arr = new int[numsInArray];
            for (int i = 0; i < numsInArray; i++) {
                int element = Integer.parseInt(sc.nextLine());
                if (element >= -1000 && element <= 1000) {
                    arr[i] = element;
                } else {
                    System.out.println("Invalid input");
                }
            }
            int[] solutionArray=solution(arr,k);
            System.out.println(Arrays.toString(solutionArray));
        }
        else {
            System.out.println("N and K must be in range [0;100]");
        }


    }

    private static int[] solution(int[] arr, int k) {
        int temp=0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                temp=arr[j+1];
                arr[j+1]=arr[0];
                arr[0]=temp;
            }
        }
        return arr;
    }
    private static boolean isValidInput(int num){
        return num >= 0 && num <= 100;
    }
}
