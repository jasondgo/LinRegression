

public record DataPoint(double weight, double vertLen, double diagLen, double crossLen, double height, double diagWid) {

    public double chooseReturn(Category c ){

        if(c == Category.Weight)
            return weight;

        else if(c == Category.Vertical_Length)
            return vertLen;

        else if(c == Category.Diagonal_Length)
             return diagLen;

        else if(c == Category.Cross_Length)
             return crossLen;

        else if(c == Category.Height)
             return height;

        else
            return diagWid;



    }

}
