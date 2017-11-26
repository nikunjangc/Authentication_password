
package com.company;
import java.util.*;

public class Authentication {

    private final String password = "4523";

    boolean matched = false;
    List<Integer> userNum = new ArrayList<> (); //can be anything
    List<Integer> displayNum = new ArrayList<>(); //will display 0123456789
    List<Integer> generator = new ArrayList<>(); //will display random number between 0-3
    // for successive 4523 for eg 1223
    List<Integer> compare = new ArrayList<>(); //will keep the number associated with the position of user password
    // and puts the random number for that
    //ie if the user password is 4523 ..

    List<Integer> storePassword = new ArrayList<Integer>();  //this will keep user password (string) into  integer array list
    Scanner scanner = new Scanner(System.in);
    Random random;


    public Authentication() {

    }
    //this will simply display number 0-9
    public void displayGeneral() {
        for (int i = 0; i < 10; i++) {
            displayNum.add(i);
        }
        System.out.println("this is initial numbering user have to check his code with this number ");
        System.out.println("suppose your code is 356");
        System.out.println("user have to see whats below 356, in the random generate code and enter it");
        System.out.println(displayNum);

    }

    //this will generate random number for 0-10, ie in between 1-3
    //eg for             0123456789
    //something like    1223221221 //this will change every time
    public void generateRandom() {
        for (int i = 0; i < 10; i++) {
            random=new Random();
            int pickedNumber = random.nextInt(3) + 1;
            generator.add(pickedNumber);
        }
        System.out.println("random generated code");
        System.out.println(generator);
        //this will convert user stored password into integer array
        for(int i = 0; i < password.length(); i++) {
            char strArray = password.charAt(i);

            storePassword.add( Integer.parseInt(strArray+""));

        }


    }

    //this function will convert user password into the randomly generated number
    public void checkRandomAndDefultPassword() {

        for (int j = 0; j < storePassword.size(); j++) {
            compare.add(generator.get(storePassword.get(j)));
        }
        System.out.println("Below  line is just for checking //");
        System.out.println(" In real code this will be hidden ");
        System.out.println( compare);

    }
    // this function will take user password , that needs to be verified,ie the user will not enter his real code
    //he will enter the random generated number with the position associated with his code.
    public void userCode() {
        System.out.println("Enter the code : ");
        String getCode = scanner.next();
        System.out.println();

        for(int i = 0; i < getCode.length(); i++) {

            char strArray = getCode.charAt(i);
            userNum.add(Integer.parseInt(strArray + ""));
        }
        System.out.println("user num "+userNum);

    }

    //this will compare the user code and gives the output
    public void checkValue() {
        for (int i = 0; i <userNum.size();i++) {
            if (userNum.get(i) == compare.get(i)) {
                matched = true;
            } else {
                matched = false;
                break;
            }
        }
        if (matched == true && userNum.size()==compare.size()) {
            System.out.println("password matched");
        } else {
            System.out.println("password error");
        }


    }
}