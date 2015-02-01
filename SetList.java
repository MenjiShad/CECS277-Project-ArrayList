/* James Dinh
 * 01/28/2015
 * Purpose: This program generates quick pick lottery tickets
 *          This method generates 6 random numbers
 * Inputs: Number of generated tickets
 * Output: Ticket numbers sorted in ascending order, for each ticket
 */
import java.util.ArrayList;

public class SetList{
  
  // Get values into the list
  public static ArrayList<Integer> generate(ArrayList<Integer> list){
    
    int rangeMax = 49; // rangeMax determines maximum value of the random roll
    int rangeMin = 1; // rangeMin determines minimum value of the random roll
    int lotteryNum; // lotteryNum holds the RNG value
    
    // Loop that adds values to the list
    // Generate 6 numbers per ticket
    for (int counter = 0; counter < 6; counter++){
      // Generate random number between rangeMin and rangeMax (inclusive)
      lotteryNum = (int) (rangeMax * Math.random()) + rangeMin;
      // As long a duplicate number is produced, keep generating a random number
      while (list.contains(lotteryNum))
        lotteryNum = (int) (rangeMax * Math.random()) + rangeMin; 
      list.add(lotteryNum); // Adds the RNG value to the list
    }
    java.util.Collections.sort(list);
    return list;
  }
}
