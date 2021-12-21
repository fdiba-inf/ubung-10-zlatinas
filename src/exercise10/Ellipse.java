package exercise10;

public class Ellipse extends Figure {
    

    public Ellipse() {
      super(new Point(0, 0), 1, 1);
        
    }

    public Ellipse(Point startPoint, double a, double b) {
      super(new Point(startPoint), a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
      super(new Point(otherEllipse.startPoint), otherEllipse.side1,otherEllipse.side2);
        
    }

   

    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }

    public boolean equal(Figure otherFigure) {
        if (otherFigure instanceof Ellipse){
          return super.equal(otherFigure);
        } else {
          return false;
        }

       
    }
    @Override
    public boolean containsClick(Point click) {
        double clickX = click.getX();
        double clickY = click.getY();
        double centerX = startPoint.getX() + side1;
        double centerY = startPoint.getY() + side2;
        double part1 = Math.pow(clickX - centerX, 2) / Math.pow(side1, 2);
        double part2 = Math.pow(clickY - centerY, 2) / Math.pow(side2, 2);


        return part1 + part2 <= 1;
    }
}
