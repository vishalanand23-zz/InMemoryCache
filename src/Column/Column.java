package column;

/**
 * Created by anandv on 29/04/14.
 */
public abstract class Column<T> {

    public final String name;
    public final T value;

    public Column(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public boolean isNamed(String name) {
        return this.name.equals(name);
    }

    public boolean equalsTo(T t) {
        return value.equals(t);
    }

    public abstract boolean apply(Condition condition);
}
