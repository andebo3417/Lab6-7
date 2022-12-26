public class Phone_number {

    private String number;

    private boolean is_number(int c) {
        if (c >= '0' && c <= '9') return true;
        else return false;
    }

    public Phone_number() {
        number = "N/A";
    }

    public Phone_number(String number) {
        set_number(number);
    }

    public int set_number(String number) {
        if (number == "N/A") this.number = number;
        if (check_number(number) == true) {
            this.number = number;
            return 0;
        }
        else return -1;
    }

    public String get_number() {
        return this.number;
    }

    public static boolean check_number(String number) {
        if (number.length() != 12) return false;
        if (number.charAt(0) != '+') return false;
        for (int i = 1; i < 11; i++)
            if (number.charAt(i) < '0' || number.charAt(i) > '9') return false;
        return true;
    }
}
