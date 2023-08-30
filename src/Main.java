import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Controller controller = new Controller();
        while (true) {
            System.out.println("--1-- hien thi du lieu");
            System.out.println("--2-- add ");
            System.out.println("--3-- delete");
            System.out.println("--4-- search");
            System.out.println("--5-- edit");
            System.out.println("--6-- exit");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Chon chuc nang: ");
            int chooseControll = scanner.nextInt();
            if (chooseControll == 6){
                break;
            }
            switch (chooseControll){
                case 1:
                    controller.getAllData();
                    break;
                case 2:
                    Student newStudent = addStudent();
                    controller.insertData(newStudent);
                    System.out.println("Them thanh cong");
                    break;
                case 3:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Nhap id muon xoa: ");
                    String idDelete = scanner1.nextLine();
                    controller.deleteData(idDelete);
                    System.out.println("da xoa thanh cong");
                    break;
                case 4:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Nhap ten muon tim: ");
                    String nameSearch = scanner2.nextLine();
                    controller.searchData(nameSearch);
                    break;
                case 5:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("nhap id muon thay doi: ");
                    String id = scanner3.nextLine();
                    System.out.println("Nhap name muon thay doi");
                    String newValuesName = scanner3.nextLine();
                    System.out.println("Nhap tuoi muon thay doi");
                    int newValuesAge= scanner3.nextInt();
                    controller.updateData(id,newValuesName,newValuesAge);
                    System.out.println("da cap nhat thanh cong");
                    break;
            }

        }
    }


    public static Student addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id: ");
        String id = scanner.nextLine();

        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();

        System.out.println("Nhap tuoi: ");
        int age = scanner.nextInt();

        Student newStudent = new Student(id,name,age);

        return newStudent;
    }
}
