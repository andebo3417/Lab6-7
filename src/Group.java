public class Group<T> extends List{
    public GroupName<T> name;

    Teacher teacher;

    public Group(T name, Teacher teacher) {
        super(0);
        this.name = new GroupName<T>(name);
        this.teacher = teacher;
    }

    public Group(List list, T name, Teacher teacher) {
        super(0);
        this.name = new GroupName<T>(name);
        this.teacher = teacher;
		this.size = list.size;
        this.list = list.list;
    };

    public int append(Student unit) {
        this.extend();

        this.list[this.length() - 1] = unit;

        return 0;
    };

    public int set_name(T name) {
        if (name.toString().length() > 0) {
            this.name.setName(name);
            return 0;
        }
        else return -1;
    };

    public T get_name() {
        return this.name.getName();
    };

    @Override
    public void print() throws LengthException{
        if (this.length() > 0) {
            System.out.print("\nGroup " + this.get_name() + ":\n\n");
            System.out.print("Teacher:\n");
            this.teacher.print();
            System.out.print("\nList of students:\n\n");
            for (int i = 0; i < this.size; i++) {
                System.out.print("#" + Integer.toString(i + 1));
                this.list[i].print();
                System.out.print("\n");
            }
            System.out.print("\nEnd of list.\n\n");
        }
		else
        throw new LengthException("\nList is empty.\n\n");
    };
}
