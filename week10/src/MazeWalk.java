public class MazeWalk {
    public  static void main(String[] args){
        int[][] mazeMap={
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println("初始地圖：");
        displayMaze(mazeMap);

        System.out.println("迷宮路徑圖(從右下到左上角):");
        findPath(mazeMap,5,8);
        displayMaze(mazeMap);
        System.out.println("數字 1: 牆壁");
        System.out.println("數字 2: 走過的路徑");
    }

    static boolean findPath(int[][] maze,int x,int y){
        if (maze[1][1]==2){
            return true;
        }else {
            if (maze[x][y]==0){
                maze[x][y]=2;
//                右下左上
                if (findPath(maze,x+1,y) ||
                    findPath(maze,x,y+1) ||
                    findPath(maze,x-1,y) ||
                    findPath(maze,x,y-1)
                ){return true;}
                else {
                    maze[x][y]=0;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    static void displayMaze(int[][] maze){
        for (int i=0;i<maze.length;i++){
            for (int j=0;j<maze[i].length;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
}
