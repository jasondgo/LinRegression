import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
       private String path;
       private List<String> lineHolder = new ArrayList<>();
       public FileReader(String path){
           this.path = path;
           readLine();
       }

       private void readLine() {
           try {
               Scanner scan = new Scanner(new File(path));
               scan.nextLine();
               while (scan.hasNext()) {
                   lineHolder.add(scan.nextLine());
               }
              // System.out.println(lineHolder);

           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
       }

       public List<DataPoint> getData(){

          return lineHolder.stream().map( s ->(s.split(","))).map(s -> new DataPoint(Double.parseDouble(s[1]),Double.parseDouble(s[2]),
                   Double.parseDouble(s[3]),Double.parseDouble(s[4]),Double.parseDouble(s[5]),Double.parseDouble(s[6]))).collect(Collectors.toList());



       }



}
