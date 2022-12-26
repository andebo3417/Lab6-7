import java.util.Scanner;

public class Average_marks {
    private int physics;
    private int math;
    private int economics;

    private Scanner reader = new Scanner(System.in);

    public Average_marks() {
        this.math = 0;
        this.economics = 0;
        this.physics = 0;
    }

    public Average_marks(Average_marks unit) {
        this.set_physics(unit.get_physics());
        this.set_math(unit.get_math());
        this.set_economics(unit.get_economics());
    }

    public int set_physics(int mark) {
        this.physics = mark;
        return 0;
    }

    public int set_math(int mark) {
        this.math = mark;
        return 0;
    }

    public int set_economics(int mark) {
        this.economics = mark;
        return 0;
    }

    public int get_physics() {
        return this.physics;
    }


    public int get_math() {
        return this.math;
    }

    public int get_economics() {
        return this.economics;
    }

    public int get_average_rating() {
        return (this.economics + this.math + this.physics) / 3;
    }

    public int input_average_marks() {
        boolean flag = false;
        String input;

        System.out.print("\nInput average marks of a student.\n\n");
        do {
            flag = true;
            System.out.print("Input average physics mark (0 to 100): \n>>");
            input = reader.next();
            try {
                if (this.set_physics(Integer.parseInt(input)) != 0) {
                    System.out.print("\nMark must be between 0 and 100.\n\n");
                    flag = false;
                }
            }
            catch (NumberFormatException ex) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);

        do {
            flag = true;
            System.out.print("\nInput average physics mark (0 to 100): \n>>");
            input = reader.next();
            try {
                if (this.set_math(Integer.parseInt(input)) != 0) {
                    System.out.print("\nMark must be between 0 and 100.\n\n");
                    flag = false;
                }
            }
            catch (NumberFormatException ex) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);

        do {
            flag = true;
            System.out.print("\nInput average physics mark (0 to 100): \n>>");
            input = reader.next();
            try {
                if (this.set_economics(Integer.parseInt(input)) != 0) {
                    System.out.print("\nMark must be between 0 and 100.\n\n");
                    flag = false;
                }
            }
            catch (NumberFormatException ex) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);
        return 0;
    }

}
