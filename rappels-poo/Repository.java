import java.util.List;

public interface Repository<T, ID> {

    public List<T> findAll();
    public T findById(ID id);
    public T save(T element);


    public default T demo() {
        return null;
    }


}
