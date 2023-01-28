public class Circle2 {
    private double radius;
    private String color;

    public Circle2(){
        this.radius=1.0;
        this.color="red";
    }
    public Circle2(double radius){
        this.radius=radius;
    }
    public Circle2(double radius,String color){
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "Circle[radius="+radius+",color="+color+"]";
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
}
