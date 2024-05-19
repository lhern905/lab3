import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class ListTests {
    
    @Test
    public void testFilter1(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");
        list.add("elderberry");
        list.add("fig");
        list.add("grape");
        StringChecker sc = new StringChecker() {
            public boolean checkString(String s) {
                return s.length() == 4;
            }
        };
        List<String> result = ListExamples.filter(list, sc);
        assertEquals("date", result.get(0));
        assertEquals(1, result.size());
    }

    @Test
    public void testFilter2(){
        List<String> list = new ArrayList<>();
        list.add("penny");
        list.add("nickel");
        list.add("dime");
        list.add("quarter");
        list.add("dollar");
        StringChecker sc = new StringChecker() {
            public boolean checkString(String s) {
                return s.contains("e");
            }
        };
        List<String> result = ListExamples.filter(list, sc);
        List<String> expected = new ArrayList<>();
        expected.add("penny");
        expected.add("nickel");
        expected.add("dime");
        expected.add("quarter");
        // assertEquals(expected, result);
    }

    @Test
    public void testMerge1(){
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("banana");
        list1.add("cherry");
        list1.add("date");
        list1.add("elderberry");
        list1.add("fig");
        list1.add("grape");
        List<String> list2 = new ArrayList<>();
        list2.add("penny");
        list2.add("nickel");
        list2.add("dime");
        list2.add("quarter");
        List<String> result = ListExamples.merge(list1, list2);
        List<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("cherry");
        expected.add("date");
        expected.add("dime");
        expected.add("elderberry");
        expected.add("fig");
        expected.add("grape");
        expected.add("nickel");
        expected.add("penny");
        expected.add("quarter");
        assertEquals(expected, result);
    }
}
