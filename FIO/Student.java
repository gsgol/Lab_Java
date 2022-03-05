import javax.naming.Name;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Student
{
    private String Name;

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }
    private String Surname;

    public String getSurname()
    {
        return this.Surname;
    }

    public void setSurname(String surname)
    {
        this.Surname = surname;
    }

    private String Patronymic;

    public String getPatronymic()
    {
        return this.Patronymic;
    }

    public void setPatronymic(String patronymic)
    {
        this.Patronymic = patronymic;
    }

    private LocalDate Birthday;

    public LocalDate getBirthday()
    {
        return this.Birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.Birthday = birthday;
    }
    public Student (String surname, String name, String patronymic, LocalDate birthday)
    {
        this.Name = name;
        this.Surname = surname;
        this.Patronymic = patronymic;
        this.Birthday = birthday;
    }

    public int GetAge()
    {
        return Period.between(this.Birthday, LocalDate.now()).getYears();
    }

    public String GetFio()
    {
        return   this.Surname.charAt(0) + "." + this.Name.charAt(0) + "." + this.Patronymic.charAt(0) + "." + " ";
    }

    public String GetSex()
    {
        if (this.Patronymic.charAt(this.Patronymic.length() - 1) == 'ч')
        {
            return "Муж ";
        }
        else
        {
            return "Жен ";
        }
    }

    public void Describe()
    {
        String suffix = " лет";
        int age = this.GetAge();
        if (age % 10 == 1 & (int)((age % 100)/10) != 1)
        {
            suffix = " год";
        }
        else if (age % 10 >= 2 & age % 10 < 5 & (int)((age % 100)/10) != 1)
        {
            suffix = " года";
        }


        System.out.println("ФИО: " + this.GetFio() + "Пол: " + this.GetSex() + "Возраст: " + age + suffix);
    }


}

