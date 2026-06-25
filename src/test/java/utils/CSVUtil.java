package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static String[][] getData(String filePath) {

        List<String[]> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] values = line.split(",");
                data.add(values);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        String[][] result = new String[data.size()][];

        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }

        return result;
    }
}