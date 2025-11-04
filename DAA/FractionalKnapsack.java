import java.util.*;
class Item {
    int weight;
    int value;
    Item(int weight,int value){
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    static double getMaxValue(Item[] items , int caps){

        Arrays.sort(items,(a, b) -> Double.compare(
            (double)b.value/ b.weight,
            (double)a.value/ a.weight
        ));
        double finalVal = 0.0;
        for(Item item : items ){
            if(caps == 0){
                return finalVal;
            }
            if(item.weight <= caps){
                finalVal += item.value;
                caps-= item.weight; 
            }
            else{
                finalVal +=  caps* (double) item.value/item.weight;
                caps = 0;
            }
        }

        return finalVal;
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
