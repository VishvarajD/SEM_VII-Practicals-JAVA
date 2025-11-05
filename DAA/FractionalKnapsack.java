//Steps 
/*1.input array
 * 2.Class Item
 * 3.sort arrays acc to v / w
 * 4.then formula
 */
import java.util.*;

public class FractionalKnapsack {
    
    static class Item {
        int weight;
        int value;
        Item(int weight,int value){
            this.value = value;
            this.weight = weight;
        }
    }
    static double getMaxValue(Item[] items , int caps){
        Arrays.sort(items,(a,b)->Double.compare(
            b.value/b.weight, a.value/a.weight
        ));
        double finalV = 0.0;
        for(Item item:items){
            if(caps==0){
                return finalV;
            }
            if(caps >= item.weight){
                finalV += item.value;
                caps -= item.weight;
            }else{
                finalV += caps * (double)item.value/item.weight; 
                caps = 0;
            }
        }
        return finalV;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };
        int capacity = 50;
        System.out.println("Maximum value in Knapsack = " + getMaxValue(items, capacity));
    }
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(1) 
    
}
