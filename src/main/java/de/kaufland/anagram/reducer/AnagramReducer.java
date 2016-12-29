package de.kaufland.anagram.reducer;


import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * @author vinodjagwani
 *
 * Reducer class for combining the result and generating output
 */
public class AnagramReducer extends MapReduceBase implements
		Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, Text> outputCollector, Reporter reporter)
			throws IOException {

		final StringBuilder builder = new StringBuilder();
		final Set<Text> unique = new HashSet<Text>();
		int size = 0;
		while (values.hasNext()) {
			final Text value = values.next();
			if (unique.add(value)) {
				size++;
				builder.append(value.toString());
				builder.append(" ");
			}
		}
		if (size > 1) {
			key.set(StringUtils.EMPTY);
			outputCollector.collect(key, new Text(builder.toString()));
		}
	}

}
