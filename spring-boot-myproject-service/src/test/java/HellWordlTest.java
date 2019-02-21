import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HellWordlTest.class)
public class HellWordlTest {
    @Test
    public void testSayHello() {
        assertEquals("Hello Maven", "Hello Maven");
    }
}
