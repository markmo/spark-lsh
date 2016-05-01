name := "spark-lsh"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" %% "spark-sql" % "1.6.1",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "com.google.protobuf" % "protobuf-java" % "2.6.1"
)