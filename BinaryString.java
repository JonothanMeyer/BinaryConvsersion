
/**
 * Project II: Bianary Conversion
 * Author: Jonothan Meyer
 * 1/31/18
 * 
 * Description: This program takes input of a binary number either a user or a .txt file, checks the length of the input to see that it is 8 characters long,
 * converts those numbers to digits and displays that to the user. It also has additional functionality to write to a different file of the user's choosing.
 * 
 * I/O: Input is either text from a user, or reading from a .txt file. Output is displayed on the screen: the binary number input/read, validation of it (valid/invalid), and the 
 * conversion to digits.
 * 
 * Assumptions and limitations: Maximum of 30 elements. User input will be 0's and 1's, file input is not empty (although it will not crash if it is)
 * References & resources: Methods found in the JAVA API library. Also review from "Introduction to Programming with JAVA" by John Dean and Raymond Dean, Published by
 * McGraw-Hill 2008
 */
import java.util.Scanner;   
import java.io.*;
import java.util.*;
public class BinaryString
{
 String keepGoing = "y";
 Scanner input = new Scanner(System.in);
 String[] textComingIn = new String[30];
 String userInput;
 boolean validator = true;
 public void printInfo(){
 //This will be a simple greeting method and explaination of the program
 System.out.println("This is a program that takes binary numbers from a user, checks if the value entered is 8 characters long, and if so, converts the bianary to decimal, and displays it.\n" +
                     "Additionally this program reads binary numbers from a text file, reads line by line, and preforms the same function of 8 character validation, converstion, and display" +
                     " of the binary number inputs\n");
    }
    
  public void processUserNumbers()
 {
  //take user input for how many numbers they want to check, validates those numbers, converts the validated ones to decimals, and displays the result.
  int x = 0;
  System.out.println("How many numbers would you like to validate today?");
    do {
      try 
      {
               x = input.nextInt();
       }
      catch (InputMismatchException e)
        {   
              validator = !validator;
              System.out.println("Invalid Entry, please enter an integer");
              input.next();
        }
    } while (!validator);
  String[] userInput = new String[x];
  for (int i=0;i<userInput.length;i++)
  {
      System.out.println("Please enter binary #" + (i+1));
      String user = input.next();
      printBinaryValue(user);
      boolean valid = validateNumber(user);
      if (valid == true)
      { printDigitValue(user);
    }
}
}

 public String[] processFileNumbers()
 {
  //this method will take a .txt file name as a parameter, and run it through this program.
  int i = 0;
  String line;
  boolean found = false;
  String textFile;
  System.out.println("Enter the filename you would like to convert from binary to digits.");
  while (found == false) {
  try {

      Scanner fileIn = new Scanner(new FileReader(input.next()));
      while (fileIn.hasNextLine())
      {
      textComingIn[i] = fileIn.nextLine();
      i++;
      //System.out.println(line); (debugging)
    }

    found = true;
    fileIn.close();
     }
  catch (FileNotFoundException e)
  {
      System.out.println("File was not found. Please enter a valid file name.");
    }
}  
  return textComingIn;  
}

public void writeFile(String[] textComingin)
{
// this method is not actually used in the driver, but is included, as per the parameters to be used in the future. It takes the text from another file, and writes it to a new file
PrintWriter toFile;
try {
    System.out.print("Enter file name you would like to write to:");
    toFile = new PrintWriter(input.next());
    toFile.println(textComingin[12]);
    toFile.close();
}
catch (FileNotFoundException e)
{ System.out.println("There was an error, please enter the file name again");
}   
}

public String currentString(String[] textComingIn, int i)
{
  //takes current string from index "i" in textComingin array to be used for other functions such as evaluateNumber, validateNumber, ext.
  String currentString = textComingIn[i];
  return currentString;  
}

public int evaluateNumber(String currentString){
// this method converts the String binary validated input into digits.
    int sum = 0;
    int y;
    for (int i =0;i < currentString.length();i++){
        y = (int)Math.pow(2,7-i);
        if(currentString.charAt(i) == '1')
        sum += y;
        //System.out.println(sum) (debugging)
}
     return sum; 
}

/*public String validateNumbers(String userInput)
 {
 //this method will check the length of the input from the parameter textfile, it will return true if the text is 8 characters long
 String checkEight = "Invalid";
 int eight = userInput.length();
 if (eight == 7) {
 userInput = "Valid";
}
 return userInput;   
}*/ //not used

public String[] validateNumber(String[] dotTextFile)
 {
  //this method checks the length of each index in the array from the text file, creates a new array with "valid" stored in the corresponding index
  //spot as the paramater array if the length is 8 characters, otherwise it puts "Invalid" in that spot if it has less or more.
  String[] checkEightFile = new String[11];
  String eight;
  for (int i=0;i<dotTextFile.length;i++){
      eight = dotTextFile[i];
      int isEight = eight.length();
       if (isEight == 8){
           dotTextFile[i] = "Valid";
        }
       else
           dotTextFile[i] = "Invalid";
    }
  for (int i=0;i<dotTextFile.length;i++){System.out.println(dotTextFile[i]);}
  return checkEightFile;
    }
    
public boolean validateNumber(String currentString){
    boolean valid = false;
    boolean empty = false;
    String checkEight = currentString;

    if (checkEight != null) {
    int isEight = checkEight.length();
    if (isEight == 8){
       checkEight = "Valid";
       valid = true;
        }
       else
       checkEight = "Invalid\n"; 
    System.out.println("Status: " + checkEight);
    }
    return valid;

}

public void printDigitValue(String currentString){
System.out.println("Digit Value: " + evaluateNumber(currentString)); 
}

public void printBinaryValue(String currentString){
if (currentString != null) {
System.out.println("Binary Value: " + currentString);
}
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Driver:
public static void main(String[] args)
 {
     int i = 0; 
     boolean valid;
     Scanner input = new Scanner(System.in);
      BinaryString testReadFile = new BinaryString();
      String[] textComingIn = new String[11];
      testReadFile.printInfo();
      testReadFile.processUserNumbers();
      textComingIn = testReadFile.processFileNumbers();
    do {
      String currentString = testReadFile.currentString(textComingIn,i);

      testReadFile.printBinaryValue(currentString);
      valid = testReadFile.validateNumber(currentString);
      if (valid == true){
      testReadFile.printDigitValue(currentString);
    }
    //testReadFile.writeFile(); //used to test the functionality of writing to a file.
    System.out.println("\n");
    i++;}   while (textComingIn.length > i);
    } 
    }
    