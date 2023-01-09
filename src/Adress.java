import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Adress implements  Printable{
    private String city;
    private String street;
    private int house_number;
    private int flat_number;

    private Scanner reader = new Scanner(System.in);



    public Adress(String city, String street, int house_humber, int flat_number) {
        set_city(city);
        set_street(street);
        set_house_number(house_humber);
        set_flat_number(flat_number);
    }

    public Adress() {
        city = "N/A";
        street = "N/A";
        house_number = 0;
        flat_number = 0;
    }
    public Adress(Adress unit) {
        this.set_city(unit.get_city());
        this.set_street(unit.get_street());
        this.set_house_number(unit.get_house_number());
        this.set_flat_number(unit.get_house_number());
    }
    public int set_city(String city) {
        if (city.length() != 0) this.city = city;
    else {
            return -1;
        }
        return 0;
    }

    public  int set_street(String street) {
        if (street.length() != 0) this.street = street;
    else {
            return -1;
        }
        return 0;
    }

    public int set_house_number(int house_number) {
        if (house_number > 0) this.house_number = house_number;
    else {
            return -1;
        }
        return 0;
    }

    public int set_flat_number(int flat_number) {
        if (flat_number > 0) this.flat_number = flat_number;
    else {
            return -1;
        }
        return 0;
    }


    public String get_city() {
        return this.city;
    }

    public String get_street() {
        return this.street;
    }

    public int get_house_number() {
        return this.house_number;
    }

    public int get_flat_number() {
        return this.flat_number;
    }

    public String get_full_adress() {
        return this.city + ", " + this.street + " " + Integer.toString(this.house_number) + ", " + Integer.toString(this.flat_number);
    }

    public  int input_adress() {
        boolean flag = true;
        String input;

        System.out.print("\nInput adress of a student.\n\n");
        do {
            flag = true;
            System.out.print("Input city: \n>>");
            input = reader.next();
            if (this.set_city(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);


        do {
            flag = true;
            System.out.print("\nInput street: \n>>");
            input = reader.next();
            if (this.set_street(input) != 0) flag = false;
            if (flag == false) System.out.print("\nIncorrect input.\n\n");
        } while (flag == false);


        do {
            flag = true;
            System.out.print("\nInput house number: \n>>");
            input = reader.next();
            try {
                this.set_house_number(Integer.parseInt(input));
            }
            catch (NumberFormatException ex) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);


        do {
            flag = true;
            System.out.print("\nInput flat number: \n>>");
            input = reader.next();
            try {
                this.set_flat_number(Integer.parseInt(input));
            }
            catch (NumberFormatException ex) {
                System.out.print("\nIncorrect input.\n\n");
                flag = false;
            }
        } while (flag == false);
        return 0;
    }

    public void print() {
        System.out.print("Adress: " + this.get_full_adress() + "\n");
    }
}
