import java.util.Comparator;

public class Comp implements Comparator<List> {
    public int compare(List list1, List list2)
    {
        if (list1.length() == list2.length())
            return 0;
        else if (list1.length() < list2.length())
            return 1;
        else
            return -1;
    }
}
