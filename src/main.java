import java.util.List;

public class main {
    public static void main(String[] arg){
        FileReader f = new FileReader("/Users/jason/OneDrive/Desktop/LinReg/Fish.csv");
        List<DataPoint> data = f.getData();

        System.out.println(data);
    }
}
