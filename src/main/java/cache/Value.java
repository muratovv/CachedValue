package cache;

/**
 * Class provide lazy initialization for {@link T} variable
 * @author @muratovv
 * @date 30.10.16
 */
public class Value<T> {

    private T             value;
    private Computable<T> lambda;

    /**
     * Create {@link T} object with lazy initialization by {@link Computable} lambda
     * @param lambda function raised on initialization of object. Constraints: {@code lambda != null}
     *               and {@code lambda.compute() != null} otherwise will be thrown NPE.
     */
    public Value(Computable<T> lambda) {
        if (lambda == null) {
            throw new NullPointerException("null lambda");
        }
        this.lambda = lambda;
    }

    /**
     * getter for {@link T} value. If value not initialized, compute it.
     * @return computed value
     */
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
