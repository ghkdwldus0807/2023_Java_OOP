//21101989 황지연 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RemoveText {

	public static void main(String[] args) throws IOException {
		String remove = args[0];
        String filename = args[1];
        File file = new File(filename);
        
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line.replaceAll(remove, ""));
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading");
            System.exit(1);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error writing");
            System.exit(1);
        }
        
        System.out.println("Removed file : "+ sb.toString());

	}

}
