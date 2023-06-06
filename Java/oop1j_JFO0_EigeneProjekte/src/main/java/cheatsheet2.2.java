public class cheatSheet2 {

    public static void main(String[] args) {
// Instantiate Object
		Student student1 = new Student("Luca", 25);
// Set Parameters
        student1.name = "Dario";                // Accessing field if parameter is public
        student1.setAge(26);             // Use Setter method if parameter is private
// Get Parameters
        String name = student1.name;            // Accessing field if parameter is public
        int age = student1.getAge();            // Use Getter method if parameter is private
        String school = Student.school;         // Accessed by directly referencing the class, not the object
// Array
        int[] myIntArray = new int[3];          // Initialize array with 3 elements (index 0,1,2)
        myIntArray[0] = 42;                     // Declare element at index 0 with 42
        int[] myIntArray = { 42, 69, 420 };     // Initialize and declare array
// ArrayList
import java.util.ArrayList;
        ArrayList<Integer> myIntArrayList = new ArrayList<>();      // Initializes new ArrayList with Integers
        myIntArrayList.add(value);              // Adds value to end of list
        myIntArrayList.add(index, value);       // Adds value at index
        myIntArrayList.clear();                 // Clears ArrayList
        myIntArrayList.indexOf(value);          // Returns index of value
        myIntArrayList.get(index);              // Returns value at index
        myIntArrayList.remove(index);           // Removes element at index
        myIntArrayList.set(index, value);       // Sets value at index
        myIntArrayList.size();                  // Returns length of list
        myIntArrayList.toString();              // Returns String of entire list
// Iterating using for-each
        for (int num : myIntArrayList){         // Iterates through every index of the array and sets num to corresponding value
        }
// Iterating using Iterator (only forward)
import java.util.Iterator;
        Iterator<String> iterator = myIntArrayList.iterator();
        while(iterator.hasNext()){              // Checks if there is a next element
            System.out.println(iterator.next()); // Print out next element //remove()
        }
// Iterating using ListIterator
import java.util.ListIterator;
        ListIterator<String> listiterator = myIntArrayList.listIterator();
        while(litr.hasPrevious()){
            System.out.println(listiterator.previous();
	    }
// Exeption Handling using if-else
        int divisor = 0;
        int a = 10 /divisor;                            // Exeption occurs
        if (divisor ==0){                               // Handling by avoiding exeption
        }else{
        }
// Exeption Handling using try-catch
        try {
            // Code that is likely to cause an exeption
        } catch (Exeption e){
            // Code that handles most exeptions
        } catch (IOException e){
            // Code that handles I/O exeptions
        } catch (NullPointerException e){
            // Code that handles NullPointer exceptions
        } catch (ArrayIndexOutOfBoundsException e){
            // Code that handles ArrayIndexOutOfBounds exceptions
        }
    }
}