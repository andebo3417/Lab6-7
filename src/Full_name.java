import java.util.Scanner;

public class Full_name implements Printable
{

    private String name;
    private String surname;
    private String fathername;

    private Scanner reader = new Scanner(System.in);

    public Full_name(String name, String surname, String fathername) {
        set_name(name);
        set_surname(surname);
        set_fathername(fathername);
    }

    public Full_name() {
        this.set_name("N/A");
        this.set_surname("N/A");
        this.set_fathername("N/A");
    }
    public Full_name(Full_name unit) {
        this.set_name(unit.get_name());
        this.set_surname(unit.get_surname());
        this.set_fathername(unit.get_fathername());
    }

    public int set_name(String name) {
        if (name.length() > 0) this.name = name;
    else {
            return -1;
        }
        return 0;
    }

    public int set_surname(String surname) {
        if (surname.length() > 0) this.surname = surname;
    else {
            return -1;
        }
        return 0;
    }

    public int set_fathername(String fathername) {
        if (fathername.length() > 0) this.fathername = fathername;
    else {
            return -1;
        }
        return 0;
    }

    public String get_name() {
        return this.name;
    }

    public String get_surname() {
        return this.surname;
    }

    public  String get_fathername() {
        return this.fathername;
    }

    public String get_full_name() {
        return  this.surname + " " + this.name + " " + this.fathername;
    }

    int input_full_name() {
        boolean flag = false;
        String input;

        do {
            flag = true;
            System.out.print("\nInput name: \n>>");
            input = reader.next();
            if (this.set_name(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);

        do {
            flag = true;
            System.out.print("\nInput surname: \n>>");
            input = reader.next();
            if (this.set_surname(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);

        do {
            flag = true;
            System.out.print("\nInput fathername: \n>>");
            input = reader.next();
            if (this.set_fathername(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);

        return 0;
    }

    public void print() {
        System.out.print("\nName: " + this.get_full_name() + "\n");
    }
}
