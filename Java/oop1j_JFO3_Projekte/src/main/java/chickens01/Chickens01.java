// Calculate the totalEggs collected on the days from Monday to Wednesday. 
// The chickens lay eggsPerChicken on noon every day. 
//On Monday the numbers of chickens are chickenCount.
//On Tuesday, one more chicken gets added. 
//On Wednesday, half of all chickens are eaten. 
//How many eggs can be harvested if: 
//scenario 1: eggsPerChicken = 5, chickenCount = 3
//scenario 2: eggsPerChicken = 4, chickenCount = 8

package chickens01;

public class Chickens01 {    
    public static void main(String[] args) {
        int totalEggs = 0;
        int eggsPerChicken = 5;
        int chickenCount = 3;

        //Monday
        totalEggs = chickenCount * eggsPerChicken;

        //Tuesday
        ++chickenCount; 
        totalEggs = eggsPerChicken * chickenCount; 

        //Wednesday
        chickenCount = chickenCount/2; 
        totalEggs = eggsPerChicken * chickenCount; 

        System.out.println(totalEggs);       
    }   
}
