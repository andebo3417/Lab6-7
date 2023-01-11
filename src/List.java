import java.util.*;

public class List implements Cloneable{
    protected int size;
    public Student[] list;

    public List(int list_size){

        Student[] list = new Student[list_size];

        for (int i = 0; i < list_size; i++) {
            list[i].full_name.set_name(Integer.toString(i));
        }

        this.size = list_size;
        this.list = list;
    }

    public List(List unit) {
        this.size = unit.length();
        this.list = new Student[unit.length()];
        for (int i = 0; i < unit.length(); i++) {
            this.list[i] = unit.list[i];
        }
    }

    public int length() {
        return this.size;
    }

    public int append() {
        this.extend();

        System.out.print("\nPlease input student data:\n");

        if (this.list[this.length() - 1].input_data() == 0) {
            System.out.print("\nStudent added to list.\n");
            return 0;
        }
        else {
            System.out.print("\nSomething went wrong.\n");
            return -1;
        }
    }

    public int remove(int index) throws LengthException{
        Student[] new_list = new Student[this.length() - 1];
        int counter = 0;

        if (this.length() < 1) throw new LengthException("\nList is empty.\n\n");

        if (index < 0) return -1;
        if (index > this.length() - 1) return -1;

        for (int i = 0; i < this.length(); i++) {
            if (i != index) {
                new_list[counter] = this.list[i];
                counter++;
            }
        }

        this.list = new_list;
        this.size--;

        return 0;
    }

    public void print() throws LengthException{
        if (this.length() > 0) {
            System.out.print("\nList of students:\n\n");
            for (int i = 0; i < this.length(); i++) {
                System.out.print("#" + Integer.toString(i + 1));
                this.list[i].print();
                System.out.print("\n");
            }
            System.out.print("\nEnd of list.\n\n");
        }
    else
        throw new LengthException("\nList is empty.\n\n");
    }

    public void NonVirtualPrint() throws LengthException {
        this.print();
    }

    protected void extend() {
        Student[] new_list = new Student[this.length() + 1];

        if (this.length() >= 0) System.arraycopy(this.list, 0, new_list, 0, this.length());
        new_list[size] = new Student();

        this.list = new_list;
        this.size++;
    }

    @Override
    public List clone() throws CloneNotSupportedException{
        return (List) super.clone();
    }

    public static int findByName(ArrayList<List> lists, String desiredName) {
        for (int i = 0; i <lists.size(); i++) {
            for (Student unit : lists.get(i).list) {
                if (unit.full_name.get_full_name().equals(desiredName)) return i;
            }
        }
        return -1;
    }
}
