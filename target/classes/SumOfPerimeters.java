public class SumOfPerimeters {
    Square square;
    Circumference circumference;

    public SumOfPerimeters(Square square, Circumference circumference) {
        this.square = square;
        this.circumference = circumference;
    }
    public double PerimeterSum() {
        double perimeterSum;
        double circumfenrencePerimeter = 2 * 3.14 * circumference.getRadius();
        double dos = 2;
        double squarePerimeter = 0;
        squarePerimeter = squarePerimeter + square.getHeight() * dos;
        squarePerimeter = squarePerimeter +square.getWidth() * dos;
        perimeterSum = squarePerimeter + circumfenrencePerimeter;
        return perimeterSum;
    }
    public int Test1(int a, int b, int c){
        return a+b+c;
    }
    public int Test2(int d, int e, int f){
        return d-e-f;
    }
    public int Test3(int g, int h, int i){
        return a/b/c;
    }



}
