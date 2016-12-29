package de.kaufland.anagram.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vinodjagwani on 12/29/16.
 */
public class AnagramMapperTest {

    private AnagramMapper anagramMapper;
    private MapDriver<LongWritable, Text, Text, Text> driver;

    @Before
    public void init() {
        anagramMapper = new AnagramMapper();
        driver = new MapDriver<>(anagramMapper);
    }

    @Test
    public void anagramMapperTest() throws Exception {
        String line = "vinod";
        driver.withInput(new LongWritable(), new Text(line))
                .withOutput(new Text("dinov"), new Text("vinod"))
                .runTest();
    }
}
