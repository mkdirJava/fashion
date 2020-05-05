# Fashion

Word search:
Build on SOLID:
	Correctness of solution
		Two areas of concern
		
			1. Tokenise: extendable with using interfaces in using components, would be better to batch sections of string from a source
			 
			2. Word Counter / Rank words: Single JVM divide and conquer with recursion, would be better to use ExecutorService or RecursiveTask to take advantage of multiple cores 
				a. Large inputs: Would be good to tokenize subparts of data sources and use the "Word Counter / Rank words" as a service, handling
			actions in this manner requires handling state.
		
Java 11 JDK used.
		
Maven plugins:
	
	spot-bugs
	
	java-doc
	
	jacoco

After building this project: 
	Jar can be ran with:
	
	java -jar job-0.0.1-SNAPSHOT-jar-with-dependencies.jar 