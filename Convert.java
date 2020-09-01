import java.util.*;




public class Convert {

/*==============================================================================
                                0. Variables
==============================================================================*/

    int UserVal;

/*==============================================================================
                                0. Constructor
==============================================================================*/

    public Convert(int input)
     {
         this.UserVal = input;
     }



/*==============================================================================
                                1. METHOD: Binary
==============================================================================*/

        // 1. Convert to Binary ----------------------------------------------------
        int Binary() {

        // Generate Factor List ------------------------------------------------
        // First we need a list of factors, but not highter than the input value
        ArrayList<Integer> Factors = new ArrayList<Integer>();
        int i =0;
        int Fac = 1; // starter value

        while(i<100) {
            Fac = Fac *2;     // 1*2= (2) *2= (4) *2= (8) *2= (16)
            Factors.add(Fac); // array = [2,4,8,16, 32, 64, 128]

            i++;

            // Loop Condition: Only Factors below the input value
            if (Fac < UserVal) {
                  continue;
            } else {
                  break;
        } } // End Loop
        // Remove last value from array, which is a value above the Input
        Collections.reverse(Factors);
        Factors.remove(0);
        Factors.add(1); // 32, 16, 8, 4, 2, 1


        // Genarate a list of ZEROS --------------------------------------------
        // This list will be minipulated with results values
        ArrayList<Integer> Result = new ArrayList<Integer>();
        for (int j=0; j<Factors.size(); j++) {
             Result.add(0); } // Result = [0, 0, 0, 0, 0]


        // Substract Input with Factors ---------------------------------------
        // Substract with factory only if the sum is above 0, else move on
        int Sum = UserVal;
        for ( int k =0; k < Factors.size(); k++) {
                if (Sum >= Factors.get(k)) { // GREATER or EQUAL
                    Sum = Sum - Factors.get(k);
                    Result.set(k, 1); }
                    //    33  - 32 = 1    (k = 0)   Factor = 32     Result: 0 => 1
                    //     1  - 32 = 1    (k = 1)   Factor = 16     Result: 0 => 0
                    //     1  - 32 = 1    (k = 2)   Factor = 8      Result: 0 => 0
                    //     1  - 32 = 1    (k = 3)   Factor = 4      Result: 0 => 0
                    //     1  - 32 = 1    (k = 4)   Factor = 2      Result: 0 => 0
                    //     1  - 1  = 0    (k = 5)   Factor = 1      Result: 0 => 1
        }// End Loop


            // ArrayList => Array ----------------------------------------------
            int AL = Factors.size();
            int[] res = new int[AL];
            for (int l = 0; l < Result.size(); l++) {
                 res[l] = Result.get(l); // Input items
                }
            int bin = Integer.parseInt(Arrays.toString(res).replace(", ", "").replace("[", "").replace("]", ""));


            // return Binary_output;
            return bin;

        } // end Method



/*==============================================================================
                            2. METHOD: Octal
==============================================================================*/


    int Octal() {

        // Integer => Octal String
        String ItOS = Integer.toOctalString(UserVal);
        // String => Integer
        int Oct_Out = Integer.valueOf(ItOS);

    return Oct_Out;

    }


/*==============================================================================
                            3. METHOD: Hex
==============================================================================*/


    int Hex() {

        // Integer => Octal String
        String HtOS = Integer.toHexString(UserVal);
        // String => Integer
        int Hex_Out = Integer.valueOf(HtOS);

    return Hex_Out;

    }





















/*==============================================================================
                                   EXECUTE
==============================================================================*/

    public static void main(String args[]) {

        Convert myobj = new Convert(150);

    // 1. Convert to Binary ----------------------------------------------------
    int Binary = myobj.Binary();
    System.out.println("Binary: "+Binary);

    // 2. Convert to Octal -----------------------------------------------------
    int Octal = myobj.Octal();
    System.out.println("Octal: "+Octal);

    // 3. Convert to Hex -------------------------------------------------------
    int Hex = myobj.Hex();
    System.out.println("Hex: "+Hex);

    } // Main

} // End Class
