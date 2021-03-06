package cache;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author @muratovv
 * @date 30.10.16
 */
public class ValueTest {

    private Value<Integer> value;


    @Test
    public void normalGet() throws Exception {
        value = new Value<>(() -> 1 + 1);
        Assert.assertEquals(2, ((int) value.get()));
    }

    @Test(expected = NullPointerException.class)
    public void nullValue() throws Exception {
        value = new Value<>(() -> null);
        Assert.assertEquals(null, value.get());

    }

    @Test(expected = NullPointerException.class)
    public void nullLambda() throws Exception {
        value = new Value<>(null);
    }

    @Test
    public void checkLaziness() throws Exception {
        final int[] counter = {0};
        value = new Value<>(() -> {
            counter[0]++;
            return 0;
        });

        value.get();
        value.get();
        Assert.assertEquals(1, counter[0]);
    }
}