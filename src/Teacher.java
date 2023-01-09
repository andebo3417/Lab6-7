import java.util.Scanner;

public class Teacher extends Person_data {
    private String mail;

    private Scanner reader = new Scanner(System.in);

    public Teacher(Full_name name, String gender, String mail) {
        this.full_name = new Full_name(name);
        this.set_gender(gender);
        this.set_mail(mail);
    }

    public Teacher(Full_name name) {
        this.full_name = new Full_name(name);
        this.set_gender(true);
        this.set_mail("N/A");
    }

    public Teacher() {
        this.full_name = new Full_name();
        this.set_gender(true);
        this.set_mail("N/A");
    }

    public Teacher(Teacher unit) {
        this.full_name = new Full_name(unit.full_name);
        this.set_gender(unit.get_gender());
        this.set_mail(unit.get_mail());
    }

    public int input_mail() {
        boolean flag = false;
        String temp;

        do {
            flag = true;
            System.out.print("\nInput mail: \n>>");
            temp = reader.next();
            if (set_mail(temp) != 0) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);
        return 0;
    }
    @Override
    public int input_data() {
        boolean flag = true;

        System.out.print("\nInput info about teacher.\n\n");

        if (this.full_name.input_full_name() != 0) flag = false;

        if (this.input_gender() != 0) flag = false;

        if (this.input_mail() != 0) flag = false;

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
        System.out.print("Mail: " + this.get_mail() + "\n");
    }

    public int set_mail(String mail) {
        if (!mail.contains("@") || !mail.contains(".")) return -1;
        if (mail.indexOf("@") > mail.indexOf(".")) return -1;
        this.mail = mail;
        return 0;
    }

    public  String get_mail() {
        return this.mail;
    }
}
