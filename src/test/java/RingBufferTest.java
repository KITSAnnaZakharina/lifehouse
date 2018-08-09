import org.junit.Assert;
import org.junit.Test;

public class RingBufferTest {

    @Test
    public void testWriteFunction(){
        RingBuffer buffer = new RingBuffer(5);
        Assert.assertEquals(3, buffer.write(new int[]{1, 2, 3}));
        Assert.assertEquals(2, buffer.write(new int[]{4, 5, 6}));
    }

    @Test
    public void testReadFunction() {
        RingBuffer buffer = new RingBuffer(5);
        buffer.write(new int[]{1, 2, 3});
        buffer.write(new int[]{4, 5, 6});
        Assert.assertEquals(1, buffer.read());
        Assert.assertEquals(2, buffer.read());
        Assert.assertEquals(3, buffer.read());
        Assert.assertEquals(4, buffer.read());
        Assert.assertEquals(5, buffer.read());
    }

}
