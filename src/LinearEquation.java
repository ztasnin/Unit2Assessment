public class LinearEquation {
    //instance variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance(){
        int xDis = (x2 - x1)*(x2 - x1); //distance of x values squared
        int yDis = (y2 - y1)*(y2 - y1); //distance of y values squared
        double distance = xDis + yDis;
        distance = roundedToHundredth(Math.pow(distance, 0.5));
        return distance;
    }

    public double slope(){
        double slope = ((double)(y2-y1))/(x2-x1);
            return roundedToHundredth(slope);
    }

    public double yIntercept(){
        return roundedToHundredth(y1 - slope()*x1);
    }

    public double roundedToHundredth(double toRound){
        return (double)Math.round(toRound*100)/100;
    }

    public String equation(){
        int top = (y2 - y1);
        int bottom = (x2-x1);
        String equation = "y = ";

        if (y2 == y1){ //checking horizontal lines
            equation+= y1;
        } else {
            if((top < 0 && bottom < 0) || (top > 0 && bottom > 0)){ //checking for positive slope when x2-x1 and y2-y1 is negative
                equation = equation;
            } else{
                equation+= "-";
            }
            if ((double)(top)/bottom == Math.round(top/bottom)){ //checking for non-decimal slope and printing int slope
                if (Math.abs(top/bottom) != 1) {
                    equation += Math.abs(top / bottom);
                }
            } else { //printing fractional slopes
                top = Math.abs(top);
                bottom = Math.abs(bottom);
                equation += top + "/" + bottom;
            }
            equation += "x ";
            if (yIntercept() != 0){ //adding + sign when y-intercept is positive
                if (yIntercept() > 0) {
                    equation += " + ";
                }
                equation+= yIntercept();
            }
        }
        return equation;
    }

    public String coordinateForX(double xValue){
        String coordinate = "(" + xValue + ", ";
        coordinate+= xValue*slope() + yIntercept();
        coordinate+= ")";
        return coordinate;
    }

    public String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 +
                ") and (" + x2 + ", " + y2 + ")" + "\n" +
                "The equation of the line between these two points is: " +
                equation() + "\n" + "The slope of the line is: " + slope() + "\n" +
                "The y-intercept of the line is: " + yIntercept() +  "\n" +
                "The distance between the two points is: " + distance();
    }

}
