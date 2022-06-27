
import java.util.ArrayList;
import java.util.List;

public class LinearRegression {
    private int input = 6; // number of input values including y-intercept
    private int coeff = 5; // number of m/coefficient values
    private double lr = 0.01;
    private List<Double> mValues = new ArrayList<>(List.of(0.0,0.0,0.0,0.0,0.0,0.0));// should hold each coefficient and y-intercept
    private List<Double> mValueHolder = new ArrayList<>(List.of(0.0,0.0,0.0,0.0,0.0,0.0));
    private List<DataPoint> data = new ArrayList<>();

    public LinearRegression(List<DataPoint> data){
        this.data = data;

    }


    public void macro(){ // choose limit of k value, how many times do you want to do gradient descent
        for(int k = 0; k < 5; k++ ){
            mValueHolder.set(0, mValues.get(0) - 2 * lr * derivativeFunc(Category.Vertical_Length));
            mValueHolder.set(1, mValues.get(1) - 2 * lr * derivativeFunc(Category.Diagonal_Length));
            mValueHolder.set(2, mValues.get(2) - 2 * lr * derivativeFunc(Category.Cross_Length));
            mValueHolder.set(3, mValues.get(3) - 2 * lr * derivativeFunc(Category.Height));
            mValueHolder.set(4, mValues.get(4) - 2 * lr * derivativeFunc(Category.Diagonal_Width));
            mValueHolder.set(5, mValues.get(5) - 2 * lr * derivativeFunc(Category.Y_Intercept));

            mValues.set(0, mValueHolder.get(0));
            mValues.set(1, mValueHolder.get(1));
            mValues.set(2, mValueHolder.get(2));
            mValues.set(3, mValueHolder.get(3));
            mValues.set(4, mValueHolder.get(4));
            mValues.set(5,mValueHolder.get(5));


        }

        System.out.println("Actual Weight: " + data.get(0).weight() + " " + "Guessed Weight: " + getEquationValue(data.get(0)));
        System.out.println(mValues);
    }

    private double derivativeFunc( Category c ){
        double total = 0;
        if(c != Category.Y_Intercept)
        for(int i = 0; i < data.size(); i++ ){
            total += ( getEquationValue(data.get(i)) - data.get(i).weight()) * data.get(i).chooseReturn(c);
        }

        else{
            for(int i = 0; i < data.size(); i++ ){
                total += ( getEquationValue(data.get(i)) - data.get(i).weight());
            }
        }

        return total;
    }


    private double getEquationValue(DataPoint data){
         return mValues.get(0) * data.vertLen() + mValues.get(1) * data.diagLen() +
                 mValues.get(2) * data.crossLen() + mValues.get(3) * data.height() + mValues.get(4) * data.diagWid() +
                 mValues.get(5);


    }


}

// ORDER of mValues and mValueHolder is the same as the order of the DataPoint Parameters ALWAYS!!
/*
Function to predict weight:
 h(x) = (m6)(x7) + (m5)(x6) + ... (x0) ->  x0 is y-intercept and m are coefficents for each input

Cost Function:

 J(m) = summation( (y - h(x))^2 ) -> y is the actual weight, summation is for all input values

Take derivative of J(m) with respect to a given m (Ex. d/d(m2) )
    Derivative of this equation is 2(y - h(x)) * x -> This x value is the one multiplied against the m value we took the derivative with respect to

Calculate new m value using equation m = m - (lr)d/dm(y - h(x))^2 -> lr is learning rate

Do this for each m

Now actually adjust each m value in h(x) with what you calculated

Do that all over again
*/
