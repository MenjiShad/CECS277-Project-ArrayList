/* James Dinh
 * 01/28/2015
 * Purpose: This program generates quick pick lottery tickets
 *          This class is the main method
 * Inputs: Number of generated tickets
 * Output: Ticket numbers sorted in ascending order, for each ticket
 */
import java.util.ArrayList;
import java.util.List;

public class Lottery_Generator{
  
  public static void main(String[] arghs){
    
    ArrayList<Integer> tickets = new ArrayList<Integer>(); // stores the tickets
    ArrayList<Integer> lotto = new ArrayList<Integer>(); // stores number of each ticket
    java.util.Scanner input = new java.util.Scanner(System.in);
    int numOfTickets; // holds user input for number of tickets
    int counter = 0;
    
    do {
      System.out.println("How many tickets would you like?"); // Asks user for number of tickets to generate
      numOfTickets = input.nextInt();
      if (numOfTickets < 0) // Value cannot be negative
        System.out.println("Invalid input. Try again.");
    } while (numOfTickets < 0); // input validation
    input.close(); // close Scanner
    
    while (counter < numOfTickets) {
      lotto = SetList.generate(lotto); // Generates tickets
      tickets.addAll(lotto);// Add the generated ticket into the main list
      lotto.clear(); // clear out the ticket
      counter++;
    }
    
    int ticketCount = 1; // keeps track of ticket number
    // use subList() to get the "range" of the numbers
    // The 2nd parameter of subList() is exclusive
    for (int i = 0; i < 6 * numOfTickets; i = i + 6) {
      display(tickets.subList(i, i + 6), ticketCount++);
    }
  }
  
  // Displays list values on a range
  private static void display(List<Integer> list, int ticketCount) {
    
    System.out.println("Ticket " + ticketCount + ": ");
    for (int quickPick : list) {
      System.out.print(quickPick + " ");
    }
    System.out.println();
  }
}
