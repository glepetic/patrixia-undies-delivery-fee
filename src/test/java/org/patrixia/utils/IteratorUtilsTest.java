package org.patrixia.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorUtilsTest {

    @Test
    public void foldLTest() {
        String text = "example";
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        assertEquals(text.concat("123456"), IteratorUtils.foldL((x,y) -> x.concat(y.toString()), text, numbers));
    }

}
