import enums.AsciiTypeEnum;
import exception.WrongInputException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by yong on 2018-05-10.
 *
 * @author yong
 */
public class InputSortingTest {

    private InputSorting inputSorting;

    @Before
    public void setUp() {
        inputSorting = new InputSorting();
    }

    @Test
    public void should_return_1_when_1_was_sorting() throws WrongInputException {
        assertThat(inputSorting.sorting("1"), is("1"));
    }

    @Test
    public void should_return_a_when_a_was_sorting() throws WrongInputException {
        assertThat(inputSorting.sorting("a"), is("a"));
    }

    @Test
    public void should_return_a1_when_1a_was_sorting() throws WrongInputException {
        assertThat(inputSorting.sorting("1a"), is("a1"));
    }

    @Test(expected = WrongInputException.class)
    public void should_throw_WrongInputException_when_wrongInput_was_sorting() throws WrongInputException {
        inputSorting.sorting("%");
    }

    private boolean checkAsciiTypeEnum(int start, int end, AsciiTypeEnum asciiTypeEnum) throws WrongInputException {
        boolean valid = true;
        for(int i = start; i < end; i++){
            if(asciiTypeEnum != inputSorting.checkAsciiType(i)){
                valid = false;
                break;
            }
        }
        return valid;
    }

    @Test
    public void should_return_AsciiTypeEnum_number_when_number_ascii_was_checkAsciiType() throws WrongInputException {
        assertTrue(checkAsciiTypeEnum(48, 57, AsciiTypeEnum.NUMBER));
    }

    @Test
    public void should_return_AsciiTypeEnum_upper_when_number_ascii_was_checkAsciiType() throws WrongInputException {
        assertTrue(checkAsciiTypeEnum(65, 90, AsciiTypeEnum.UPPER));
    }

    @Test
    public void should_return_AsciiTypeEnum_lower_when_number_ascii_was_checkAsciiType() throws WrongInputException {
        assertTrue(checkAsciiTypeEnum(97, 122, AsciiTypeEnum.LOWER));
    }

    @Test
    public void checkTest() throws WrongInputException {
        assertThat(inputSorting.sorting("aa11199b"), is("a1a1b199"));
        assertThat(inputSorting.sorting("aaazbc"), is("aaabcz"));
        assertThat(inputSorting.sorting("999001"), is("001999"));
        assertThat(inputSorting.sorting("aa11199b"), is("a1a1b199"));
        assertThat(inputSorting.sorting("aa8cb012"), is("a0a1b2c8"));
        assertThat(inputSorting.sorting("aa8cbA012"), is("Aa0a1b2c8"));
        assertThat(inputSorting.sorting("aa8cbC012"), is("Ca0a1b2c8"));
        assertThat(inputSorting.sorting("aa8cbA0T12"), is("Aa0Ta1b2c8"));
    }

    @Test
    public void checkTest2() throws WrongInputException {
        System.out.println(inputSorting.sorting("aa11199 b"));
    }

}
