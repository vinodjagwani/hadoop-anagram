Necessary steps to build and run your program.

1. use mvn package command on root of project to generate the artifact jar file.

2. use the follwoing command to execute the project.

mvn exec:java -Dexec.args="/home/vinodjagwani/Desktop/sample.txt /home/vinodjagwani/Desktop/anagram-test"

Note: 
"/home/vinodjagwani/Desktop/sample.txt" is the path of given file.

"/home/vinodjagwani/Desktop/anagram-test" is the output directory where file will be stored and after running it you can verify
the results. The output file names like this "part-00000"



Note:
Since there are different ways to run the project. This is simplest and quick way to run and for running this
you also must have hadoop installed at least namenode.



Consider aspects such as Maintainability, Scalability, Performance, etc.

1. Design decisions:
This task designed based on map reduce algorithm which is running on hadoop under 2 nodes.
Map Reduced algorithm which is efficient algorithm for processing of large set of data, It works
differently than using any ordinary algorithm. we will see below how it works and it has following structure.
It contains 3 parts.
1. A Main java class (Anagram.java) which define a job and input files which are going to be process and also format of input and output.
Input is split into nodes (currently 2 nodes) into same block size and blocks are replicated on both nodes
2. A Mapper Class (AnagramMapper.java)
Takes K,V inputs, writes K,V outputs in our case K is key as sorted word from the given text file and V is the all values of Anagram.
so basically mapper will split your data into key value pair for later stage processing.
3. A Reducer Class (AnagramReducer.java)
Takes K, Iterator[V] inputs, and writes K,V outputs K is key as sorted word and inputs are values of anagram which actually further can process, and combine the all results.
2. Maintainability
This project created in maven so it's easy to add or remove dependencies and also easy to extend the code using TDD design principle and add more functionality.
Since this piece of code running on hadoop so it has excellent maintainability and integration capabilities. of course a person who is maintaining the cluster he should aware of linux/unix administration. for instance SSH, what it is, how to set up authorized_keys, how to use ssh and scp ifconfig, nslookup and other network config/diagnostics tools How your platform keeps itself up to date What the various log files your machine generates, and what they mean How to set up native file systems and mount them Since Due to replication of data in the cluster, data is reliably stored on the different machines even
though machine failures. If your machine goes down, then also your data will be stored reliably and then you can easily fix dead node and replicate data again. It has nice web interface which can gives you all the information regarding nodes.
3. Scalability
Since Hadoop is highly distribute system and it scale very easily by just increasing number in configuration file and giving machine name and we are done. so it actually scale horizontally, so that you can add machine/node on the fly you don't need to shutdown the whole system, and also it runs on cheap server you don't required very high machines. As much as you increase the nodes you can perform map reduce parallel on all nodes.
4. Performance
Performance is very high because data is highly available and accessible despite hardware failure due to multiple copies of data on different nodes If a machine or few hardware crashes, then data will be accessed from other nodes. and of course as we discuss map reduce perform on different nodes parallel so the processing of data will be much faster and it produce faster results.


How will your application cope with larger datasets, say 10 Million Words, and 100 Billion
Words? If you wanted to cover these cases, how would you scale your application?
No problem if data is 10 million or 10 billion, let say we want to calculate sqaur(x) for 1, 2, 3 on one node and for 4 and 5 on another node, technically the file will be converted into blocks, so similarly you can break down large data set into blocks on different nodes and just run the map reduce job parallel on all node where you distributed your data, and if you think data is increasing than as I mentioned in scalability you just horizontally scale it and schedule the map task for newly created machine and process the data