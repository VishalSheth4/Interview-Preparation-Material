import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int len = petrolpumps.size();
        int firstPointer = 0;
        int lastPointer = 1;
        int balanceFuel = petrolpumps.get(firstPointer).get(0) - petrolpumps.get(firstPointer).get(1);
        while (lastPointer != firstPointer || balanceFuel < 0) {
            while (balanceFuel < 0 && firstPointer != lastPointer) {
                balanceFuel -= petrolpumps.get(firstPointer).get(0) - petrolpumps.get(firstPointer).get(1); 
                firstPointer = (firstPointer + 1) % len; 
                if (firstPointer == 0) 
                return -1; 
            }
            balanceFuel += petrolpumps.get(lastPointer).get(0) - petrolpumps.get(lastPointer).get(1); 
            lastPointer = (lastPointer + 1) % len; 
        }
        return firstPointer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
