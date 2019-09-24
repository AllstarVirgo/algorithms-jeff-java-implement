package utils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author potato
 * @Date 2019/9/24 10:07
 */
public class ProcessMobile {
    public static void processFile( ) throws IOException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            FileReader fileReader = new FileReader(new File("keji.txt"));
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(new FileWriter("newMobile.txt"));
            Set<String> stringSet = new HashSet<>();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                if(line.trim()!="") {
                    stringSet.add(line.trim());
                    bufferedWriter.append(processLine(line.trim()));
                }
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            assert bufferedWriter != null;
            bufferedWriter.close();
        }

    }

    public static void main(String[] args) throws IOException {
        processFile();
    }

    public static String processLine(String line){
        String preSql = "insert into NEWSMS_MOBILE values('";
        String suffix = "',null,null,null);";
        return preSql + line + suffix;
    }
}
