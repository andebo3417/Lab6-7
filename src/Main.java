import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List list = new List(0);
        Teacher teacher = new Teacher();
        String number = "";
        String answer = "";
        boolean flag = false;
        boolean leave = false;
        Scanner reader = new Scanner(System.in);

        while (leave == false) {
            do {
                flag = false;
                System.out.print("\nChoose one option:\n");
                System.out.print("[1] - Add student to the list\n");
                System.out.print("[2] - Delete student from list\n");
                System.out.print("[3] - Print list of students\n");
                System.out.print("[4] - Calculate overall rating of a student\n");
                System.out.print("[5] - Change info about student\n");
                System.out.print("[6] - Create new group from this list/group\n");
                System.out.print("[0] - Exit\n\n>");
                answer = reader.next();
                try {
                    if (Integer.parseInt(answer) >= 0 && Integer.parseInt(answer) < 7) {
                        flag = true;
                    }
                    else {
                        System.out.print("\nChosen number is out of range.\n\n");
                    }
                }
                catch (NumberFormatException ex) {
                    flag = false;
                    System.out.print("\nIncorrect input.\n\n");
                }
            } while (flag == false);

            switch (answer.charAt(0)) {
                case '1':
                    list.append();
                    break;
                case '2':
                    try {
                        list.print();
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                        break;
                    }
                    System.out.print("\nInput number of a student you want to delete:\n>");
                    number = reader.next();
                    try {
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= list.length())
                            if (list.remove(Integer.parseInt(number) - 1) == 0)
                                System.out.print("\nStudent was deleted.\n\n");
                            else
                                System.out.print("\nNumber of student is out of range.\n");
                    }
                    catch (NumberFormatException ex) {
                        System.out.print("\nIncorrect input.\n\n");
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case '3':
                    try {
                        list.print();
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case '4':
                    try {
                        list.print();
                        System.out.print("\nInput number of a student:\n>");
                        number = reader.next();
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= list.length())
                            System.out.print("\nAverage rating of a student is: " + list.list[Integer.parseInt(number) - 1].average_marks.get_average_rating() + "\n");
                else
                        System.out.print("\nNumber of student is out of range.\n");
                    }
                    catch (NumberFormatException ex) {
                        System.out.print("\nIncorrect input.\n\n");
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case '5':
                    try {
                        list.print();
                        System.out.print("\nInput number of a student you want to change:\n>");
                        number = reader.next();
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= list.length()) {
                            System.out.print("\n[1] - Name\n");
                            System.out.print("[2] - Gender\n");
                            System.out.print("[3] - Marks\n");
                            System.out.print("[4] - Adress\n");
                            System.out.print("[5] - Contacts\n");
                            System.out.print("[0] - Exit\n");
                            System.out.print("\nInput number of a field you want to change:\n>");
                            answer = reader.next();

                            flag = false;
                            if (Integer.parseInt(answer) >= 0 && Integer.parseInt(answer) <= 5) {
                                switch (answer.charAt(0))
                                {
                                    case '1':
                                        if (list.list[Integer.parseInt(number) - 1].full_name.input_full_name() == 0) flag = true;
                                        break;
                                    case '2':
                                        if (list.list[Integer.parseInt(number) - 1].input_gender() == 0) flag = true;
                                        break;
                                    case '3':
                                        if (list.list[Integer.parseInt(number) - 1].average_marks.input_average_marks() == 0) flag = true;
                                        break;
                                    case '4':
                                        if (list.list[Integer.parseInt(number) - 1].adress.input_adress() == 0) flag = true;
                                        break;
                                    case '5':
                                        if (list.list[Integer.parseInt(number) - 1].contacts.input_contacts() == 0) flag = true;
                                        break;
                                    default:
                                        flag = false;
                                        break;
                                }
                                if (flag == true) {
                                    System.out.print("\nData was changed.\n");
                                }
                                else {
                                    System.out.print("\nNothing was changed.\n");
                                }
                            }
                        }
                        else {
                            System.out.print("\nNumber of student is out of range.\n");
                        }
                    }
                    catch (NumberFormatException ex) {
                        System.out.print("\nIncorrect input.\n\n");
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case '6':
                    if (list.length() > 0) {
                        flag = true;
                        System.out.print("\nPlease input group name:\n>");
                        answer = reader.next();
                        if (answer.length() <= 0) {
                            flag = false;
                            System.out.print("\nIncrorrect input.\n\n");
                        }
                        if (teacher.input_data() != 0) flag = false;
                        if (flag == true) {
                            try {
                                list = new Group<Integer>(list, Integer.parseInt(answer), teacher);
                                System.out.print("\nGroup was created with template int.\n\n");
                            }
                            catch (NumberFormatException ex) {
                                list = new Group<String>(list, answer, teacher);
                                System.out.print("\nGroup was created with template String.\n\n");
                            }
                            catch (Exception ex) {
                                flag = false;
                            }
                        }
                        if (flag == false)
                            System.out.print("\nGroup was not created.\n\n");
                    }
                    else {
                        System.out.print("\nList is empty.\n\n");
                    }
                    break;
                default:
                    leave = true;
                    break;
            }

        }
    }
}
