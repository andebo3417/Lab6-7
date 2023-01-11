import java.util.Scanner;

public class Student extends Person_data implements Cloneable{

    public Average_marks average_marks;
    public Adress adress;
    public Contacts contacts;

    private Scanner reader = new Scanner(System.in);

    public Student(Full_name name, String gender, Average_marks marks, Adress adress, Contacts contacts) {
        this.full_name = new Full_name(name);
        set_gender(gender);
        this.adress = new Adress(adress);
        this.contacts = new Contacts(contacts);
        this.average_marks = new Average_marks(marks);
    }

    public Student(Full_name name) {
        this.full_name = new Full_name(name);
        set_gender(true);
        this.adress = new Adress();
        this.contacts = new Contacts();
        this.average_marks = new Average_marks();
    }

    public Student(String gender) {
        this.full_name = new Full_name();
        set_gender(gender);
        this.adress = new Adress();
        this.contacts = new Contacts();
        this.average_marks = new Average_marks();
    }

    public Student(Adress adress)  {
        this.full_name = new Full_name();
        set_gender(true);
        this.adress = new Adress(adress);
        this.contacts = new Contacts();
        this.average_marks = new Average_marks();
    }

    public Student(Contacts contacts) {
        this.full_name = new Full_name();
        set_gender(true);
        this.adress = new Adress();
        this.contacts = new Contacts(contacts);
        this.average_marks = new Average_marks();
    }

    public Student(Average_marks marks) {
        this.full_name = new Full_name();
        set_gender(true);
        this.adress = new Adress();
        this.contacts = new Contacts();
        this.average_marks = new Average_marks(marks);
    }

    public Student(Student unit) {
        this.full_name = unit.full_name;
        this.set_gender(unit.get_gender());
        this.adress = unit.adress;
        this.average_marks = unit.average_marks;
        this.contacts = unit.contacts;
    }

    public Student() {
        this.full_name = new Full_name();
        this.set_gender(true);
        this.average_marks = new Average_marks();
        this.adress = new Adress();
        this.contacts = new Contacts();
    }

    @Override
    public int input_data()  {
        boolean flag = true;

        System.out.print("\nInput info about student.\n\n");

        if (this.full_name.input_full_name() != 0) flag = false;

        if (this.input_gender() != 0) flag = false;

        if (this.average_marks.input_average_marks() != 0) flag = false;

        if (this.adress.input_adress() != 0) flag = false;

        if (this.contacts.input_contacts() != 0) flag = false;

        if (flag == true) {
            System.out.print("\nInput successful.\n\n");
            return 0;
        }
        else {
            System.out.print("\nSomething went wrong\n\n");
            return -1;
        }
    }

    public void print() {
        this.full_name.print();
        System.out.print("Gender: " + this.get_gender() + "\n");
        this.average_marks.print();
        this.adress.print();
        this.contacts.print();
    }
    @Override
    public Student clone() throws CloneNotSupportedException{
       Student NewStudent = new Student();
        NewStudent.full_name = new Full_name(this.full_name);
        NewStudent.set_gender(this.get_gender());
        NewStudent.average_marks = new Average_marks(this.average_marks);
        NewStudent.adress = new Adress(this.adress);
        NewStudent.contacts = new Contacts(this.contacts);
        return NewStudent;
    }
}
