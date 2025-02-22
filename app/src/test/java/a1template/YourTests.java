// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {

    @Test
    public void encodeTestNonAlphabetic(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("lzak ak kwujwl ewkksyw #2", classUnderTest.encode("this is secret message #2"));
        
        classUnderTest = new CaesarCipher(3);
        assertEquals("f exsb 2 aldp xka 3 zxqp.", classUnderTest.encode("i have 2 dogs and 3 cats."));
    }

    @Test
    public void encodeTestCaps(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("Lzak ak s kwujwl ewkksyw.", classUnderTest.encode("This is a secret message."));
        classUnderTest = new CaesarCipher(3);
        assertEquals("Qefp fpk'q sbov pbzobq.", classUnderTest.encode("This isn't very secret."));
    }

    @Test
    public void decodeTestNonAlphabetic(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("this is secret message #2", classUnderTest.decode("lzak ak kwujwl ewkksyw #2"));
        
        classUnderTest = new CaesarCipher(3);
        assertEquals("i have 2 dogs and 3 cats.", classUnderTest.decode("f exsb 2 aldp xka 3 zxqp."));
    }

    @Test
    public void decodeTestCaps(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("This is a secret message.", classUnderTest.decode("Lzak ak s kwujwl ewkksyw."));
        
        classUnderTest = new CaesarCipher(3);
        assertEquals("This isn't very secret.", classUnderTest.decode("Qefp fpk'q sbov pbzobq."));
    }



}