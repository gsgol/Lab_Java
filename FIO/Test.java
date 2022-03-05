import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Test
{
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Введите имя");
                String name  = sc.next("[а-яА-Я]+");
                System.out.println("Введите фамилию");
                String surname = sc.next("[а-яА-Я]+");
                System.out.println("Введите отчество");
                String patronym = sc.next("[а-яА-Я]+");
                System.out.println("Введите год рождеия");
                int year = sc.nextInt();
                System.out.println("Введите день рождения");
                int day = sc.nextInt();
                System.out.println("Введите месяц рождения");
                int month = sc.nextInt();
                Student stud = new Student(name,surname,patronym,LocalDate.of(year,month,day));
                stud.Describe();
                flag = false;
            } catch (InputMismatchException | DateTimeException | PatternSyntaxException ex) {
                System.out.println("Неверное значение");
            }
        }



    }
}
