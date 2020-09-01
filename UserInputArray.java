package mypack;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import mypack.SymbolChecker;



public class UserInputArray {

    /* User Input Array

    By using java.util.Scanner, we now can input a number of user input.

    When the user is done, he can type the command "/done" to exit user input.

    The input String a set to an array, which is also the output for the class.

    Lastly there are Field Settings
         -  removes all BLANK and null elemets from list
         - Remove blank,emtpy space, out of the a string
    */


/* =============================================================================
                                    FIELDS
==============================================================================*/

    boolean Remove_Empty_Elements;

    boolean Remove_Empty_Characters;


/* =============================================================================
                            CONSTRUCTOR: Checker Settings
==============================================================================*/

// CONSTRUCTOR:  Setting for  User input Elements
public UserInputArray(boolean Elements, boolean Character) {
    this.Remove_Empty_Elements = Elements;
    this.Remove_Empty_Characters = Character;
}


/* =============================================================================
                        METHOD: User input Array
==============================================================================*/

   public String[] MakeList() {

      Scanner sc = new Scanner(System.in);
      ArrayList<String> AlphaArray = new ArrayList<String>(); // Create an ArrayList object

      // Settings ----------------------------------------------------------------
      // Here we input the settings for Symbol checker (which characters al legal)
      SymbolChecker myCheck = new SymbolChecker(true, true, true, false, false, true, false);
       ArrayList<Boolean> Checklist = new ArrayList<Boolean>(); // Create an ArrayList object

      // repeat user-input action,
      // when user types "/done", break loop
      String element ="";

      System.out.println("Input a String list, When finished press: /done");

        do {
            element = sc.nextLine(); //input

////////////////////////////////////////////////////////////////////////////////
                            // SymbolChecker
////////////////////////////////////////////////////////////////////////////////

// input -----------------------------------------------------------------------
// Here we input the String type, that needs to be checked)
myCheck.SymbolChecker(element);

// output ----------------------------------------------------------------------
// Here we ouput a boolean result:
// true, when all character al legal
boolean output = (myCheck.booleanReturn());
// System.out.println(ouput); // print out

////////////////////////////////////////////////////////////////////////////////

            AlphaArray.add(element); // to list
            Checklist.add(output); // add boolean to list

        } while (!element.contains("/done")); // condition

                // compare 2 list ----------------------------------------------
                // if Checklist index value is true...
                // add AlphaArray Element => MyArray
                ArrayList<String> myArray = new ArrayList<String>();
                for (int i = 0; i < AlphaArray.size(); i++) {
                      if (Checklist.get(i)) {
                          myArray.add(AlphaArray.get(i)); }
                }

                // Remove Empty Elements ---------------------------------------
                if (Remove_Empty_Elements) {
                myArray.removeAll(Collections.singleton(null));
                myArray.removeAll(Collections.singleton(""));
                }

                // remove spaces from String -----------------------------------
                if (Remove_Empty_Characters) {
                for (int i = 0; i < myArray.size(); i++) {
                    String blank = myArray.get(i).replaceAll("\\s+","");;
                    myArray.set(i, blank);
                }}

               // copy elements from ArrayList > Static Array ------------------
               int arrsize = myArray.size(); // get array size
               String[] StaticArray = new String[arrsize]; // create obj
               // LOOP
               for (int j = 0; j < arrsize; j++) {
                    StaticArray[j] = myArray.get(j); }

              // NOTE: ArrayList can't be outputed for a class, by return
              // instead we use java.util.Arrays


      return StaticArray;

  } // end method



/*==============================================================================
                                  EXECUTE
==============================================================================*/


   public static void main(String args[]) {

      UserInputArray obj = new UserInputArray(true, true); // create class object
      String arr[] = obj.MakeList(); // create array, fill with method input
      System.out.println("Array Elements "+Arrays.toString(arr)); // print array as string

  } // end Main`
} // end Class
