package db;

import java.io.BufferedReader;
import java.io.FileReader;

public class DBInit {

    public String readTeardown(){
        String sql = "";
        try {
            String filePath = "src/main/resources/teardown.sql";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while (true){
                String line = br.readLine();

                if(line == null) break;

                sql = sql + line+" ";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sql;
    }
}
