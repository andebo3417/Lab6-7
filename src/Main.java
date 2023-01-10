import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<List> lists = new ArrayList<List>();
        Teacher teacher = new Teacher();
        String number = "";
        String answer = "";
        Full_name desiredName = new Full_name();
        boolean flag = false;
        boolean leave = false;
        int curList = 0;
        int found = -1;
        Scanner reader = new Scanner(System.in);
        lists.add(new List(0));

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
                System.out.print("[7] - Create New list\n");
                System.out.print("[8] - Switch list\n");
                System.out.print("[9] - Found student by name\n");
                System.out.print("[10] - Sort lists of students by size in descending order\n");
                System.out.print("[0] - Exit\n\n>");
                answer = reader.next();
                try {
                    if (Integer.parseInt(answer) >= 0 && Integer.parseInt(answer) < 11) {
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

            switch (Integer.parseInt(answer)) {
                case 1:
                    lists.get(curList).append();
                    break;
                case 2:
                    try {
                        lists.get(curList).print();
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                        break;
                    }
                    System.out.print("\nInput number of a student you want to delete:\n>");
                    number = reader.next();
                    try {
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= lists.get(curList).length())
                            if (lists.get(curList).remove(Integer.parseInt(number) - 1) == 0)
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
                case 3:
                    try {
                        lists.get(curList).print();
                    }
                    catch (LengthException ex) {
                        System.out.print(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        lists.get(curList).print();
                        System.out.print("\nInput number of a student:\n>");
                        number = reader.next();
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= lists.get(curList).length())
                            System.out.print("\nAverage rating of a student is: " + lists.get(curList).list[Integer.parseInt(number) - 1].average_marks.get_average_rating() + "\n");
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
                case 5:
                    try {
                        lists.get(curList).print();
                        System.out.print("\nInput number of a student you want to change:\n>");
                        number = reader.next();
                        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= lists.get(curList).length()) {
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
                                        if (lists.get(curList).list[Integer.parseInt(number) - 1].full_name.input_full_name() == 0) flag = true;
                                        break;
                                    case '2':
                                        if (lists.get(curList).list[Integer.parseInt(number) - 1].input_gender() == 0) flag = true;
                                        break;
                                    case '3':
                                        if (lists.get(curList).list[Integer.parseInt(number) - 1].average_marks.input_average_marks() == 0) flag = true;
                                        break;
                                    case '4':
                                        if (lists.get(curList).list[Integer.parseInt(number) - 1].adress.input_adress() == 0) flag = true;
                                        break;
                                    case '5':
                                        if (lists.get(curList).list[Integer.parseInt(number) - 1].contacts.input_contacts() == 0) flag = true;
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
                case 6:
                    if (lists.get(curList).length() > 0) {
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
                                lists.set(curList, new Group<Integer>(lists.get(curList), Integer.parseInt(answer), teacher));
                                System.out.print("\nGroup was created with template int.\n\n");
                            }
                            catch (NumberFormatException ex) {
                                lists.set(curList, new Group<String>(lists.get(curList), answer, teacher));
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
                case 7:
                    lists.add(new List(0));
                    curList++;
                    System.out.print("\nNew List was created and is currently selected.\n\n");
                    break;
                case 8:
                    try {
                        System.out.print("Enter number of list (1 - " + lists.size() + ")\n>");
                        number = reader.next();
                        if (Integer.parseInt(number) - 1 == curList) {
                            System.out.print("\nThis list is already selected.\n\n");
                        }
                        else if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= lists.size()) {
                            curList = Integer.parseInt(number) - 1;
                        }
                        else {
                            System.out.print("\nNumber of list is out of range.\n\n");
                        }
                    }
                    catch (NumberFormatException ex) {
                        System.out.print("\nIncorrect input.\n\n");
                    }
                    break;
                case 9:
                    desiredName.input_full_name();
                    found = List.findByName(lists, desiredName.get_full_name());
                    if (found == -1) {
                        System.out.print("\nDesired student was not found.\n\n");
                    }
                    else System.out.print("\nDesired student is in list " + (found + 1) + "\n\n");
                    break;
                case 10:
                    Collections.sort(lists, new Comp());
                    System.out.print("\nLists were sorted.\n\n");
                    break;
                default:
                    leave = true;
                    break;
            }

        }
    }
}
