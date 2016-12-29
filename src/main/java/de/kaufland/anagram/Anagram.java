package de.kaufland.anagram;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import de.kaufland.anagram.mapper.AnagramMapper;
import de.kaufland.anagram.reducer.AnagramReducer;

/**
 * @author vinodjagwani
 *
 * Main class for configuring and running job
 */
public class Anagram {

	public static void main(String[] args) {
		try {
			JobConf conf = new JobConf(Anagram.class);
			conf.setJobName("AnagramJob");
			conf.setOutputKeyClass(Text.class);
			conf.setOutputValueClass(Text.class);
			conf.setMapperClass(AnagramMapper.class);
			conf.setReducerClass(AnagramReducer.class);
			conf.setInputFormat(TextInputFormat.class);
			conf.setOutputFormat(TextOutputFormat.class);
			FileInputFormat.setInputPaths(conf, new Path(args[0]));
			FileOutputFormat.setOutputPath(conf, new Path(args[1]));
			JobClient.runJob(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
