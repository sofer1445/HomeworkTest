import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsTest {

    @Test
    void checkingTheIntegrityOfAnEmail(){
        Tests tests = new Tests("sofer1445@gmail.com", "123456", "123456");
        assertTrue(tests.correctEmail());
}
    @Test
    void checksIfThePasswordIsStrongEnough(){
        Tests tests = new Tests("123456", "S1212ss", "S1212ss");
        assertTrue(tests.correctPassword());

    }
    @Test
    void checksIfThisPasswordIsStrongEnough(){
        Tests tests = new Tests("123456", "S1212ss1", "S1212ss");
        assertTrue(tests.strongPassword());

    }
    @Test
    void lowerCase(){
        Tests tests = new Tests("123456", "S1212ss1", "S1212ss");
        assertTrue(tests.lowerCase());

    }
    @Test
    void upperCase(){
        Tests tests = new Tests("123456", "S1212ss1", "S1212ss");
        assertTrue(tests.upperCase());

    }
    @Test
    void number(){
        Tests tests = new Tests("123456", "S1212ss", "S1212ss");
        assertTrue(tests.number());

    }
    @Test
    void specialCharacter(){
        Tests tests = new Tests("123456", "S1212s@1", "S1212ss");
        assertTrue(tests.specialCharacter());

    }

}