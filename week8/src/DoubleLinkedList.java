import java.util.InputMismatchException;
import java.util.Scanner;

class Student{
    public String name;
    public int score;
    public Student next;
    public Student previous;
}

public class DoubleLinkedList {
    static Student head,ptr,prev,current; //ptr=>指針;
    static Scanner keyboard=new Scanner(System.in);

    DoubleLinkedList(){
        head=new Student();
        head.previous=head;
        head.next=null;
    }
//    加入函數，依分數高低排序
    public static void insert(){
        ptr=new Student();
        ptr.next=null;
        System.out.print("\n Student name：");
        ptr.name= keyboard.next();

        System.out.print("\n Student score：");
        ptr.score= keyboard.nextInt();

        System.out.println("");
        prev=head;
        current=head.next;
        while ((current!=null)&&(current.score >= ptr.score)){
            prev=current;
            current=current.next;
        }
        prev.next=ptr;
        ptr.previous=prev;
        ptr.next=current;
        if (current!=null){
            current.previous=ptr;
        }

    }
//    刪除函數
    public static void delete(){
        String del_name="";
        if (head.next==null){
            System.out.print("No Student record");
        }
        else{
            System.out.print("Delete student name：");
            del_name=keyboard.next();
            prev=head;
            current=head.next;
            while ((current!=null)&&(!(del_name.equals(current.name)))){
                prev=current;
                current=current.next;
            }
            if (current==null){
                System.out.printf("Student %s not found",del_name);
            }else {
                prev.next=current.next;
                current.next.previous=prev;

                System.out.printf("Student %s has been deleted", del_name);
            }
        }
    }
//    顯示
    public static void display(){
        int count=0;
        if (head.next==null){
            System.out.println("\n No student record !!\n");
        }
        else{
            System.out.printf("\n%-15s %-10s\n", "NAME", "SCORE");
            System.out.print("---------------------------\n");
            current=head.next;
            while (current!=null){
                System.out.printf("%-15s %-3d\n", current.name, current.score);
                count++;
                current=current.next;
            }
            System.out.println("There is(are) " + count + " record(s) found !!\n");
        }
    }
//    主程式
        public static void main(String args[]){
            int option=0;
            DoubleLinkedList obj = new DoubleLinkedList();
            do {
                System.out.println("******  Double Linked list operation *****");
                System.out.println("          <1> Insert               ");
                System.out.println("          <2> Delete               ");
                System.out.println("          <3> Display              ");
                System.out.println("          <4> Exit                 ");
                System.out.println("***********************************");
                System.out.print("             Choice : ");

                try {
                    option = keyboard.nextInt();
                } catch(InputMismatchException e) {
                    keyboard.nextLine();
                    System.out.printf("Not a correctly number.\n");
                    System.out.printf("Try again\n\n");
                }
                System.out.println("");
                switch (option) {
                    case 1 :
                        obj.insert(); // 新增函數
                        break;
                    case 2 :
                        obj.delete(); // 刪除函數
                        break;
                    case 3 :
                        obj.display();  // 輸出函數
                        break;
                    case 4 :
                        System.exit(0);
                }
            } while (true);
        }
}
