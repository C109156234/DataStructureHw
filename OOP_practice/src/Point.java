public class Point {
    private int x;
    private int y;

    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }

    public int[] getXY(){
        int[]  xy={x,y};
        return  xy;
    }
    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }
    public double distance(int x,int y){
        return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }
    public double distance(Point another){
        int[] ano_xy=another.getXY();
        return Math.sqrt(Math.pow(x-ano_xy[0],2)+Math.pow(y-ano_xy[1],2));
    }
    public double distance(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
}
