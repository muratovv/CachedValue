package cache;

/**
 * Functional interface for wrapping lambda in {@link Value#Value(Computable)}
 * @author @muratovv
 * @date 30.10.16
 */
public interface Computable<T> {
    T compute();
}
