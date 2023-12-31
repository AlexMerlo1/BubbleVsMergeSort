import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class App {

public static void bubbleSort(ArrayList<Integer> list) {
    int n = list.size();
    Integer temp;
    
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (list.get(j) > list.get(j + 1)) {
                // Swap elements
                temp = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, temp);
            }
        }
    }
}

public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
    int n = list.size();
    
    //Check if the list is able to be sorted
    if (n <= 1) {
        return new ArrayList<>(list);
    }

    //Split the list into two halves
    ArrayList<Integer> left = new ArrayList<>(n / 2);
    ArrayList<Integer> right = new ArrayList<>(n - n / 2);

    for (int i = 0; i < n / 2; i++) {
        left.add(list.get(i));
    }

    for (int i = n / 2; i < n; i++) {
        right.add(list.get(i));
    }

    //Sort the left and right halves
    left = mergeSort(left);
    right = mergeSort(right);

    //Merge the sorted left and right halves
    ArrayList<Integer> merged = new ArrayList<>();
    int i = 0, j = 0;

    while (i < left.size() && j < right.size()) {
        if (left.get(i) < right.get(j)) {
            merged.add(left.get(i));
            i++;
        } else {
            merged.add(right.get(j));
            j++;
        }
    }

    while (i < left.size()) {
        merged.add(left.get(i));
        i++;
    }

    while (j < right.size()) {
        merged.add(right.get(j));
        j++;
    }

    return merged;
}

public static void main(String[] args) throws Exception {
    //Prompt user for length of list
    ArrayList<Integer> array = new ArrayList<Integer>();
    System.out.println("How long do you want your random list to be? ");
    Scanner scanner = new Scanner(System.in);
    int listLength = scanner.nextInt();
    Random random = new Random();
    //Create the list of determined size
    for (int i = 0; i < listLength; i++) {
        int randomNumber = random.nextInt(100);
        array.add(randomNumber);
    }





long bubble_start_time = System.nanoTime();
bubbleSort(array);
long bubble_end_time = System.nanoTime();

long bubble_run_time = bubble_end_time - bubble_start_time;

if (bubble_run_time > 1_000_000) {
System.out.println("BubbleSort Sort total run time is " + (bubble_run_time / 1_000_000) + " milliseconds");
}
else{
    System.out.println("BubbleSort total run time is " + (bubble_run_time) + " nanoseconds");
}

long start_time = System.nanoTime();
ArrayList<Integer> merged_list = mergeSort(array);
long end_time = System.nanoTime();
long total_run_time = (end_time - start_time);
if (total_run_time > 1_000_000) {
System.out.println("Merge Sort total run time is " + (total_run_time / 1_000_000) + " milliseconds");
}
else{
    System.out.println("Merge Sort total run time is " + (total_run_time) + " nanoseconds");

}
Scanner scanner2 = new Scanner(System.in);
boolean running = true;

while (running) {
    System.out.print("Do you want to see the sorted list? (yes/no): ");
    String response = scanner2.nextLine().toLowerCase();

    if (response.equals("yes")) {
        System.out.println("Sorted List: " + merged_list);
        running = false;
    } else if (response.equals("no")) {
        System.out.println("Have a good day!");
        running = false;
    } else {
        System.out.println("Please enter 'yes' or 'no'.");
    }
}
scanner.close();
scanner2.close();

}

}
