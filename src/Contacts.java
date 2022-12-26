import java.util.Scanner;

public class Contacts {
    private Phone_number student;
    private Phone_number parent;

    private Scanner reader = new Scanner(System.in);

    public Contacts(String student_number, String parent_number) {
        set_student_number(student_number);
        set_parent_number(parent_number);
    }

    public  Contacts() {
        String number = "+00000000000";
        set_student_number(number);
        set_parent_number(number);
    }

    public Contacts(Contacts unit) {
        this.student.set_number(unit.get_student_number());
        this.parent.set_number(unit.get_parent_number());
    }

    public int set_student_number(String number) {
        if (this.student.set_number(number) == 0) return 0;
        return -1;
    }

    public int set_parent_number(String number) {
        if (this.parent.set_number(number) == 0) return 0;
        return -1;
    }

    public String get_student_number() {
        return this.student.get_number();
    }

    public String get_parent_number() {
        return this.parent.get_number();
    }

    public int input_contacts() {
        boolean flag = false;
        String input;

        System.out.print("\nInput contacts of a student.\n\n");

        do {
            flag = true;
            System.out.print("Input student's phone number: \n>>");
            input = reader.next();
            if (this.set_student_number(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);

        do {
            flag = true;
            System.out.print("Input student's parent phone number: \n>>");
            input = reader.next();
            if (this.set_parent_number(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);


        return 0;
    }
}
