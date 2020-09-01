package mypack;


import java.util.Arrays; // Array for return Array

/* Symbol checker
Input: SymbolChecker(String input) need a String Value,
which will be converted to a "Character array".

Each element goes through a Loop.

The "Setting" determs which Character is accepted or not, by the loop.
Checking ofr character is decided by its ascii value.

"booleanReturn" return a boolean true: when all character are legal
and false if a character is illegal
*/

public class SymbolChecker {

/* =============================================================================
                                    FIELDS
==============================================================================*/

    // Check #1
    boolean control_asii; // if active(true), system won't accept input
    // Check #2
    boolean symbols_asii;
    // Check #3
    boolean numbers_asii;
    // Check #4
    boolean uppercase_asii;
    // Check #5
    boolean letters_asii;
    // Check #6
    boolean binary_asii; // binary only: all true, accept for numbers
    // Check # 7
    boolean space_asii;

    // Return value
    boolean checker = false; // true if all char are legel, false is a char is illegal



/* =============================================================================
                        CONSTRUCTOR: Checker Settings
==============================================================================*/

    // CONSTRUCTOR: for setting "symbols type check"
    public SymbolChecker(boolean control, boolean symbols, boolean numbers, boolean uppercase, boolean letters, boolean binary, boolean space) {
        this.control_asii = control;
        this.symbols_asii = symbols;
        this.numbers_asii = numbers;
        this.uppercase_asii = uppercase;
        this.letters_asii = letters;
        this.binary_asii = binary;
        this.space_asii = space;
    }


/* =============================================================================
                        METHOD: Symbol Checker
==============================================================================*/

    // METHODS: Input String, convert => Character => Int(ascii)
    // Break loop if an illegal character if found
    // if all characters are legal: boolean checker = true
    // booleanReturn method output true/false
    public void SymbolChecker(String input) {// method #1

        // String -> Char array
        char[] stringToCharArray = input.toCharArray();
        // System.out.println("check string lenght: " +stringToCharArray.length); // check string lenght


// loop each character and check if legal or illegal
for (int i=0; i<stringToCharArray.length; i++) {

    // Current index value
    int check = stringToCharArray[i];

            // Check #1 --------------------------------------------------------
        if (control_asii) { // if true, run snippet
            if (check <= 31) {
                checker = false;
                System.out.println("Please don't use Control input");
                break; } } // if true break loop
        // Check #2 ------------------------------------------------------------
        if (symbols_asii) { // if true, run snippet
            if (check >= 33 && check <= 47 || check >= 58 && check <= 64 || check >= 91 && check <= 96 || check >= 123 && check <= 255) {
                checker = false;
                System.out.println("symbols are illegal");
                break; } } // if true break loop
        // Check #3 ------------------------------------------------------------
        if (numbers_asii) { // if true, run snippet
            if (check >= 48 && check <= 57) {
                checker = false;
                System.out.println("numbers  are illegal");
                break; } } // if true break loop
        // Check #4 ------------------------------------------------------------
        if (uppercase_asii) { // if true, run snippet
            if (check >= 65 && check <= 90) {
                checker = false;
                System.out.println("Please don't use upper-case letters");
                break; } } // if true break loop
        // Check #5 ------------------------------------------------------------
        if (letters_asii) { // if true, run snippet
            if (check >= 97 && check <= 122) {
                checker = false;
                System.out.println("Please don't use letters");
                break; } } // if true break loop
        // Check #6 ------------------------------------------------------------
        if (binary_asii) { // if true, run snippet
            if (check >= 50 && check <= 57) {
                checker = false;
                System.out.println("Please only use 0 & 1");
                break; } } // if true break loop
        // Check #6 ------------------------------------------------------------
        if (space_asii) { // if true, run snippet
            if (check == 32) {
                checker = false;
                System.out.println("spaces are illegal");
                break; } } // if true break loop


        // If all legal Charater
        if (i+1 == stringToCharArray.length) {
            checker = true; }

        // System.out.println("index count: " +i); // check index count

    } // End Loop
} // SymbolChecker


        // Method: returning "Field Values" true or false
        public boolean booleanReturn(){
                    return checker; }


/*==============================================================================
                                    EXECUTE
==============================================================================*/

public static void main(String args[]) {
/*
    // Settings ----------------------------------------------------------------
    // Here we input the settings for Checklist (which characters al legal)
    SymbolChecker myCheck = new SymbolChecker(true, true, true, false, false, true, false);

    // input -------------------------------------------------------------------
    // Here we input the String type, that needs to be checked)
    myCheck.SymbolChecker("cat dog");

    // output ------------------------------------------------------------------
    // Here we ouput a boolean resutl: true if all character al legal
    boolean output = (myCheck.booleanReturn());
    // System.out.println(output); // print out
*/
    } // Main

} // End Class
