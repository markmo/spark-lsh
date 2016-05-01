# spark-lsh

Implementation of Locality-Sensitive Hashing algorithm using Apache Spark.

Locality-Sensitive Hashing (LSH) is an algorithm for solving the approximate or exact Near Neighbor Search in high dimensional spaces.

This implementation uses shingling and Minhash signatures to find similar documents.
 
Minhashing is used to compress large documents into small signatures and preserve the expected similarity of any pair of documents/records. However, used alone, it may still be impossible to find the pairs with greatest similarity efficiently.

Suppose we have a million documents, and we use signatures of length 250. Then we use 1000 bytes per document for the signatures, and the entire data fits in a gigabyte – less than a typical main memory of a laptop. However, there are (1,000,000 choose 2) or half a trillion pairs of documents. If it takes a microsecond to compute the similarity of two signatures, then it takes almost six days to compute all the similarities on that laptop. (From Mining of Massive Datasets, 2nd Edition - Jure Leskovec, Anand Rajaraman, Jeff Ullman.)

See the above reference for a good treatment of the theory.

## Build

The current implementation uses the Stanford CoreNLP library for tokenization. You could do this yourself. Just replace the 'tokenize' method in the NLP class. (I have plans for further experimentation with CoreNLP in general.) 

You will need to get a copy of the [spark-corenlp](https://github.com/databricks/spark-corenlp) package from Databricks. It is not available as a package yet, so you will need to build from source and copy the built JAR into the 'lib' folder of this project.

This project uses SBT. Packages can be built in the normal way:

    sbt package

This builds a project JAR under 'target/scala-2.11/'.

### Dependencies

'spark-corenlp' requires Java 8 and CoreNLP 3.6.0 to run. You must also include the CoreNenLP models JAR to use any of the language models, e.g. to perform named entity recognition (NER).