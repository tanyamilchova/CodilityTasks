import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewOccurrances {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (isOddNum(n) && (n >= 1 && n <= 1000000)) {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                int element = Integer.parseInt(sc.nextLine());
                if (element >= 1 && element <= 1000000000) {
                    arr[i] = element;
                }
            }
                if(  validArrayInput1(arr)){
            int unpairedElement = solution1(arr);
            System.out.println(unpairedElement);
                }else {
                    System.out.println("Wrong input");
                }

            }
            else System.out.println("Invalid input");

        }




    private static int solution1(int[] arr) {
        Map<Integer, Integer> inputMap = generateMap(arr);
        boolean hasOneOdd = true;
        int oddValue = 0;
        for (Map.Entry<Integer, Integer> e : inputMap.entrySet()) {
            if (e.getValue() % 2 != 0) {
                oddValue = e.getKey();
            }
        }
        return oddValue;
    }

    public static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }

    public static boolean isOddNum(int num) {
        return num % 2 != 0;
    }

    public static Map<Integer, Integer> generateMap(int[] arr) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!inputMap.containsKey(arr[i])) {
                inputMap.put(arr[i], 1);
            } else {
                int value = inputMap.get(arr[i]);
                value++;
                inputMap.put(arr[i], value);
            }
        }
        return inputMap;
    }


    private static boolean validArrayInput1(int[] arr) {
        Map<Integer, Integer> map = generateMap(arr);
        boolean oneEvenOccurance=false;
        boolean lessThanOneEvenOccurance=true;
        for (Map.Entry<Integer,Integer>e:map.entrySet()){
            if(e.getKey()%2!=0){
                if(!oneEvenOccurance){
                    oneEvenOccurance=true;
                }else {
                    System.out.println("More than one odd occurrence");
                    lessThanOneEvenOccurance=false;
                    break;
                }
            }
        }
        return lessThanOneEvenOccurance;

    }
}
