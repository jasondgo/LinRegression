import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] arg){


        FileReader f = new FileReader("/Users/jason/OneDrive/Desktop/LinReg/Fish.csv");
        List<DataPoint> data = f.getData();
        LinearRegression lnRg = new LinearRegression(data);
        lnRg.macro();
        System.out.println(data);




    }
}


/*
Function to predict weight:
 h(x) = (m6)(x7) + (m5)(x6) + ... (x0) ->  x0 is y-intercept and m are coefficents for each input

Cost Function:

 J(m) = summation( (y - h(x))^2 ) -> y is the actual weight, summation is for all input values

Take derivative of J(m) with respect to a given m (Ex. d/d(m2) )
    Derivative of this equation is 2(y - h(x)) * x -> This x value is the one multiplied against the m value we took the derivative with respect to

Calculate new m value using equation m = m - d/dm(y - h(x))^2

Do this for each m

Now actually adjust each m value in h(x) with what you calculated

Do that all over again

 */