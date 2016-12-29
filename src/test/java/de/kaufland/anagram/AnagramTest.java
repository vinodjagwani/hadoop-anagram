package de.kaufland.anagram;


import de.kaufland.anagram.mapper.AnagramMapper;
import de.kaufland.anagram.reducer.AnagramReducer;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vinod on 12/28/2016.
 */

public class AnagramTest {


    private AnagramMapper anagramMapper;
    private AnagramReducer anagramReducer;
    private MapReduceDriver<LongWritable, Text, Text, Text, Text, Text> driver;

    @Before
    public void init(){
        anagramMapper = new AnagramMapper();
        anagramReducer = new AnagramReducer();
        driver = new MapReduceDriver<>(anagramMapper,anagramReducer);
    }

    @Test
    public void anagramWordsTest() throws Exception {
        String line1 = "bca";
        String line2 = "cba";
        String line3 = "doc";
        String line4 = "cod";
        String line5 = "lee";
        String line6 = "uuu";
        driver.withInput(new LongWritable(),new Text(line1))
                .withInput(new LongWritable(), new Text(line2))
                .withInput(new LongWritable(), new Text(line3))
                .withInput(new LongWritable(), new Text(line4))
                .withInput(new LongWritable(), new Text(line5))
                .withInput(new LongWritable(), new Text(line6))
                .withOutput(new Text(StringUtils.EMPTY), new Text("bca cba "))
                .withOutput(new Text(StringUtils.EMPTY), new Text("doc cod "))
                .runTest();
    }

}
