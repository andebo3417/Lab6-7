import java.util.Scanner;

public abstract class Person_data implements Printable{

    private String gender;

    public Full_name full_name;

    private Scanner reader = new Scanner(System.in);

    public abstract int input_data();
    public int input_gender() {
        boolean flag = false;
        String temp;

        do {
            flag = true;
            System.out.print("\nInput gender (male or female): \n>>");
            temp = reader.next();
            if (set_gender(temp) != 0) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);
        return 0;
    }

    public int set_gender(String gender) {
        if (gender.equals("male") || gender.equals("female")) this.gender = gender;
    else {
            return -1;
        }
        return 0;
    }

    public int set_gender(boolean val) {
        if (val == true) this.gender = "male";
    else this.gender = "female";
        return 0;
    }

    public String get_gender() {
        return this.gender;
    }
}
