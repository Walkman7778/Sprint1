package string;
import java.io.*;
import java.util.*;
public class StringUsage {
    String strPathInp = "C:\\Users\\lenat\\Desktop\\JavaSprint1\\Sprint1\\src\\string\\inputFile.txt";
    String strPathOut = "C:\\Users\\lenat\\Desktop\\JavaSprint1\\Sprint1\\src\\string\\outputFile.txt";
    // Here I introduced 2 variables with absolute path from and to the file
    public static void main(String[] args) throws IOException {
        StringUsage strUsage = new StringUsage();
        File input = new File(strUsage.strPathInp);
        File output = new File(strUsage.strPathOut);
        FileWriter writer = new FileWriter(output);
        Scanner scanner = new Scanner(input);
        StringBuffer buffer = new StringBuffer();
        //Calling methods with parameters. Scanner open content of file, writer save result in output, buffer opened value
        copyWrite(writer, scanner, buffer);
        toUpper (writer, scanner, buffer);
        toLower (writer, scanner, buffer);
        length (writer, scanner, buffer);
        numbOfVowels (writer, scanner, buffer);
        numbOfConsonates (writer, scanner, buffer);
        numbOfWords (writer, scanner, buffer);
        maxLenghtWord (writer, scanner, buffer);
        minLenghtWord(writer, scanner, buffer);
        allDuplicateWords(writer, scanner, buffer);
        writer.close();
        scanner.close();
    }
    // Reading in the consle content of file  and  its writing to other  file
    private static void copyWrite(FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException {
        while (scanner.hasNext()) {
            buffer.append(scanner.nextLine() + "\n");
        }
        String str = String.valueOf(buffer);   // Eqwalizing value buffer and variable str wich contains the str.
        System.out.println(str);
        writer.write(str+"\n");            //Writing into a file value of buffer
    }
    private static void toUpper (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append((scanner.nextLine () + "\n").toUpperCase ()); // I transfered to buffer content with upper register
        }
        System.out.println ("toUpper"+"\n"+(buffer.toString ()).toUpperCase ()+"\n");
        writer.write(("toUpper"+"\n"+buffer.toString ()).toUpperCase ()+"\n");
    }
    private static void toLower (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append ((scanner.nextLine () + "\n").toLowerCase ());// I transfered to buffer content with lower register
        }
        System.out.println ("toLower"+"\n"+buffer.toString ().toLowerCase ()+"\n");
        writer.write ("toLower"+"\n"+(buffer.toString ()).toLowerCase ()+"\n");
    }
    private static void length (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append (scanner.nextLine());
        }
        String str = String.valueOf(buffer);
        System.out.println ("lengh="+str.length());
        writer.write("lengh="+str.length()+"\n");
    }
   private static void numbOfVowels (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append (scanner.nextLine () + "\n");
        }
        String str = String.valueOf (buffer);
        // Counting numbers of vowels currentChar- return character corresponding to value of counter ;
        // currentCharAsString save characters in a string variable
        int counterOfVowels = 0;
        String vowels = "AOUIEaouie";
        for (int i = 0; i < str.length (); i++)
        {
            Character currentChar = str.charAt (i);
            String currentCharAsString = String.valueOf (currentChar);
            if (vowels.contains (currentCharAsString))
            {
                counterOfVowels++;
            }
        }
        System.out.println ("numbOfVowels="+counterOfVowels);
        writer.write ("numbOfVowels="+counterOfVowels + "\n");
    }
    private static void numbOfConsonates (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append (scanner.nextLine () + "\n");
        }
        String str = String.valueOf (buffer);
        int counterOfConsonates = 0;
        String  consonates= "BCDFGJKLMNPQSTVXZHRWYbcdfgjklmnpqstvxzhrwy";
        for (int i = 0; i < str.length (); i++)
        {
            Character CurrentChar = str.charAt (i);
            String CurrentCharAsString = String.valueOf (CurrentChar);
            if (consonates.contains (CurrentCharAsString))
            {
                counterOfConsonates++;
            }
        }
        writer.write ("numbOfConsonates="+counterOfConsonates +"\n");
        System.out.println ("numbOfConsonates="+counterOfConsonates);
    }
    private static void numbOfWords (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append (scanner.nextLine () + "\n");
        }
        // I wrote content of buffer in string variable
        String str = String.valueOf (buffer);
        // I put the adverse condition of parcursing the file
        if (str == null || str.isEmpty ())
        {
            System.out.println ("str. in empty");
        }
        // Using Tokanizer for  counting words
        StringTokenizer tokens = new StringTokenizer (str);
        System.out.println ("numbOfWords="+tokens.countTokens ());
        writer.write ("numbOfWords="+tokens.countTokens ()+"\n");
    }
    private static void maxLenghtWord (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
    {
        while (scanner.hasNext ())
        {
            buffer.append (scanner.nextLine () + "\n");
        }
        String str = String.valueOf (buffer);
        //Introducing array for saving list of content all words between whitespaces
        List<String> strings = Arrays.asList(str.split("\\s"));
        //Sorting array and finding the  biggest element using method Comparator
        String biggestWord = Collections.max(strings, Comparator.comparing(String::length));
        System.out.println("maxLenghtWord: "+biggestWord);
        writer.write("maxLenghtWord: "+biggestWord + "\n");
    }
   private static void minLenghtWord (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
   {
       while (scanner.hasNext ())
       {
           buffer.append (scanner.nextLine () + "\n");
       }
       String str = String.valueOf (buffer);
       List<String> strings = Arrays.asList(str.split("\\s"));
       String shortWord = Collections.min(strings, Comparator.comparing(String::length));
       System.out.println("minLenghtWord: "+shortWord);
       writer.write("minLenghtWord: "+shortWord+"\n");
   }
   private static void allDuplicateWords (FileWriter writer, Scanner scanner,StringBuffer buffer) throws IOException
   {
       while (scanner.hasNext ())
       {
           buffer.append (scanner.nextLine () + "\n");
       }
       String str = String.valueOf (buffer);
       List<String> list = Arrays.asList(str.split("\\s"));
       //I inculded  in  HashSet list of double words from set String
       Set<String> doubleWords = new HashSet<String>(list);
       String strTemp = "";
       //Pssing HashSet and determining doubleWords
       for (String word : doubleWords)
           //Condition for repeating words if repeats >1 then true
           if (Collections.frequency(list, word)>1) {
               strTemp=strTemp+word+"\n";
           }
       System.out.println("allDuplicateWords : "+strTemp);
       writer.write("allDuplicateWords : "+strTemp);
   }
}