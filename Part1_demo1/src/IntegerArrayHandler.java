import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayHandler {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void EnterNumber (){
        int newnumber;

        System.out.println("Enter integer. \nIf you want to stop, you can enter zero.");
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter number: ");
            newnumber = scanner.nextInt();
            if (newnumber != 0) {
                numbers.add(newnumber);
            }else {
                break;
            }
        }
    }

    public void CalculateSum(){
        int Sum = 0;

        System.out.println("The number of elements in the list is: " + numbers.size());
        System.out.println("About: " + numbers);

        for (int num : numbers){
            Sum += num;
        }
        System.out.println("Sum of numbers: " + Sum);

    }

    public void EvenOddChecker(){
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int num : numbers){
            int a = num;

            if ((a % 2) == 0 ){
                even.add(a);
            }else {
                odd.add(a);
            }
        }

        System.out.println("There are " + odd.size() + " odd numbers: " + odd);
        System.out.println("There are " + even.size() + " even numbers: " + even);
    }

    public void FindMaxMin (boolean a){
        // a=true, find max
        // a=false, find mind

        if (a){
            int max = numbers.get(0);
            for (int num : numbers){
                if (max < num){
                    max = num;
                }
            }
            System.out.println("The largest number is: " + max);

        }else {
            int min = numbers.get(0);
            for (int num : numbers){
                if (min > num){
                    min = num;
                }
            }
            System.out.println("The smallest number is: " + min);
        }
    }
}