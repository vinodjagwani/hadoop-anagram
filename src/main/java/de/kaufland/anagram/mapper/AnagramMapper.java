package de.kaufland.anagram.mapper;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import static de.kaufland.anagram.AnagramUtils.sort;

/**
 * @author vinodjagwani
 *
 * Mapper class for spliting data into key value pair
 */

public class AnagramMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

	private Text sortedWord = new Text();
	private Text orginalWord = new Text();
	
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> outputCollector, Reporter reporter) throws IOException {
		String word = value.toString();
		sortedWord.set(sort(word));
		orginalWord.set(word);
		outputCollector.collect(sortedWord, orginalWord);		
	}

}
