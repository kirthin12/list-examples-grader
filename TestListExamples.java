import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestListExamples {
  @Test(timeout = 100)
  public void testTimeout() {
    while(true) {}
  }
  // Write your grading tests here!

  @Test
  public void testFilterMethod()
  {
    List <String> test = new ArrayList<String>();
    List <String> expected = new ArrayList<String>();
    StringChecker sc = new StringChecker(){
      public boolean checkString(String word) {
        if(word.length() > 5)
        {
          return true;
        }
        return false;
      }
    };

    test.add ("hello");
    test.add ("computer");
    test.add ("mouse");
    test.add ("water");
    expected.add ("computer");
    assertEquals(expected, ListExamples.filter(test, sc));
  } 

  @Test
  public void testMerge()
  {
    List <String> test1 = new ArrayList<String>();
    List <String> test2 = new ArrayList<String>();
    List <String> expected = new ArrayList<String>();
    

    test1.add ("hello");
    test1.add ("computer");
    test1.add ("mouse");
    test1.add ("water");
    test2.add ("phone");
    test2.add ("cable");
    test2.add ("lights");
    test2.add ("earphone");

    for (int i = 0; i < test1.size(); i++)
    {
      expected.add(test1.get(i));
      expected.add(test2.get(i));
    }

    Collections.sort(expected);

    assertEquals(expected, ListExamples.merger(test1, test2));
  }
}
