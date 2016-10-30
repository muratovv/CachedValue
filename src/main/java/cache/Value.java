package cache;

/**
 * Class provide lazy initialization for {@link T} variable
 * @author @muratovv
 * @date 30.10.16
 */
public class Value<T> {

    private T             value;
    private Computable<T> lambda;

    public Value(Computable<T> lambda) {
        if (lambda == null) {
            throw new NullPointerException("null lambda");
        }
        this.lambda = lambda;
    }

    public T get() {
        if (value == null) {
            T compute = lambda.compute();
            if (compute == null) {
                throw new NullPointerException("Computable object return null");
            }
            value = compute;
        }
        return value;
    }
}
