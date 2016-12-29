package de.kaufland.anagram.reducer;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinodjagwani on 12/29/16.
 */
public class AnagramReducerTest {

    private AnagramReducer anagramReducer;
    private ReduceDriver<Text, Text, Text, Text> driver;

    @Before
    public void init(){
        anagramReducer = new AnagramReducer();
        driver = new ReduceDriver(anagramReducer);
    }

    @Test
    public void angaramReducerTest() throws Exception {
        List values = new ArrayList();
        values.add(new Text("bac"));
        values.add(new Text("cab"));
        driver.withInput(new Text(), values)
                .withOutput(new Text(StringUtils.EMPTY), new Text("bac cab "))
                .runTest();
    }
}
