import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DecodeMassageFile {
    public static void main(String[] args) {
        String path="src/codedFile.txt";
        System.out.println(decode(path));
    }

    private static String decode(String massage_file) {

        Map<String,String> fileDataMap= convertFileIntoMap(massage_file);
        String strToDecode= getRightMostValueFromPyramid(fileDataMap);

        StringBuilder resultString=new StringBuilder();
        String[]words=strToDecode.trim().split(",");
        for (String word:words){
            String decodedValue=fileDataMap.get(word);
            resultString.append(decodedValue).append(" ");
        }
        return resultString.toString();
    }

    public static Map<String,String> convertFileIntoMap(String filPath){

        Map<String,String>map=new HashMap<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filPath))) {
            String line;
            while ((line=reader.readLine()) !=null){
                String[] row=line.trim().split("\\n");
                String[]rowElements=row[0].trim().split(" ");
                if(!row[0].isBlank()) {
                    String key = rowElements[0].trim();
                    String value = rowElements[1].trim();
                    if(! map.containsKey(key)){
                        map.put(key,value);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }

    public static String getRightMostValueFromPyramid(Map<String,String>map){
        StringBuilder rightMostNum= new StringBuilder();
        int numElements=map.keySet().size();
        int rows=0;
        int appendedSum=0;
        while (numElements>0){
            rows++;
            appendedSum+=rows;
            rightMostNum.append(appendedSum).append(",");
            numElements-=rows;
        }

        return rightMostNum.toString();
    }
}
