// standalone code for mac coverage of lines using limited number of tests (i.e. maximum coverage problem)
import java.io.*;
import java.util.*;

public class MaxCover {
    public static void main(String [] args) {

        // This will reference one line at a time
        String line = null;
        String full = "";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader("input/input.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // tests to be considered
            Set<String> testsToBeConsidered = new HashSet<>();

            while((line = bufferedReader.readLine()) != null) {
                full += " " + line;
            }

            // Always close files.
            bufferedReader.close();

            //HashMap<String, Set<String>> testCoverMap = new HashMap<>();
            HashMap<String, List<String>> testCoverMap = new HashMap<>();

            Set<String> coveredLines = new HashSet<>();

            StringTokenizer itr = new StringTokenizer(full);

            String currentTest = null;
            List<String> linesByTest = new ArrayList<>();

            while (itr.hasMoreTokens()) {
                String[] words = itr.nextToken().split("_");

                if(currentTest == null)
                    currentTest = words[0];

                if(!words[0].equals(currentTest)){
                    testCoverMap.put(currentTest, linesByTest);
                    currentTest = words[0];
                    linesByTest = new ArrayList<>();
                }

                linesByTest.add(words[1]);
            }

            // add last test and it's lines
            testCoverMap.put(currentTest, linesByTest);

            // for user input of number of tests to consider
            //Scanner sc = new Scanner(System.in);

            // number of tests to consider
            //System.out.println("Enter number of tests to be considered:");
            //int noOfTestToConsider = sc.nextInt();

            //taking 3 test cases for max cover by default
            int noOfTestToConsider = 3;

            // check if user inserted a valid value
            if(noOfTestToConsider <= testCoverMap.size()){
                // Main logic
                while (noOfTestToConsider > 0) {

                    // finding test with max coverage
                    String maxKey = null;

                    for (String key : testCoverMap.keySet()) {
                        if (maxKey == null || testCoverMap.get(key).size() > testCoverMap.get(maxKey).size()) {
                            maxKey = key;
                        }
                    }

                    // Adding the lines covered by max coverage set to final set
                    for (String s : testCoverMap.get(maxKey)) {
                        // adding to final set for covered lines
                        coveredLines.add(s);

                        // add to tests to be considered
                        testsToBeConsidered.add(maxKey);

                    }

                    // removing the key value pair that was added to final set
                    testCoverMap.remove(maxKey);

                    // removing the covered line from the remaining sets of other tests
                    for(String s : coveredLines){
                        for(List<String> ss : testCoverMap.values()) {
                            ss.remove(s);
                        }
                    }

                    noOfTestToConsider--;

                }


                // FileReader reads text files in the default encoding.
                FileWriter fileWriter = new FileWriter("input/input.txt", false);

                // Always wrap FileReader in BufferedReader.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                StringTokenizer itrWrite = new StringTokenizer(full);

                String newLine = "";

                while (itrWrite.hasMoreTokens()) {
                    String[] words = itrWrite.nextToken().split("_");

                    if(testsToBeConsidered.contains(words[0])){
                        newLine += words[0] + "_" + words[1] + " ";
                    }
                }

                bufferedWriter.write(newLine);

                // Always close files.
                bufferedWriter.close();

                for (String tests : testsToBeConsidered){
                    System.out.println(tests);
                }
            }

        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch(IOException ex) {
            System.out.println("Error reading file");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }
}