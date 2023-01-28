public class Cylinder extends Circle2{
    private double height;

    public Cylinder(){
        super();
        this.height=1.0;
    }
    public Cylinder(double height){
        super();
        this.height=height;
    }
    public  Cylinder(double height,double radius){
        super(radius);
        this.height=height;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public String toString(){
        return "Cylinder";
    }
    public double getVolume(){
        return getArea()*this.height;
    }
}
