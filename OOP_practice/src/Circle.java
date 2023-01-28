public class Circle {
    private Point center;
    private double radius;

    Circle(){
        center=new Point();
        radius=1.0;
    }
    Circle(int xCenter,int yCenter,double radius){
        center=new Point(xCenter,yCenter);
        this.radius=radius;
    }
    Circle(Point center,double radius){
        this.center=center;
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Point getCenter() {
        return center;
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public int getCenterX(){
        return center.getX();
    }
    public void setCenterX(int x) {
        this.center.setX(x);
    }
    public int getCenterY(){
        return center.getY();
    }
    public void setCenterY(int y){
        center.setY(y);
    }
    public int[] getCenterXY(){
        return center.getXY();
    }
    public void setCenterXY(int x,int y){
        this.center.setXY(x,y);
    }
    public String toString(){
        return "Circle[center="+center+",radius="+radius+"]";
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public double getCircumference(){
        return 2*radius*Math.PI;
    }
    public double distance(Circle another){
        return center.distance(another.center);
    }
}
