public class GroupName<T> {
    private T name;

    public GroupName(T name) {
        this.name = name;
    };
    public T getName() {
        return this.name;
    };
    public void setName(T name) {
        this.name = name;
    };
}
