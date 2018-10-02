name := "AWSLambdaScalaEx"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-core" % "1.11.32"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-lambda" % "1.11.32"
libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
libraryDependencies += "com.amazonaws" % "jmespath-java" % "1.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.6"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.6"

lazy val commonSettings = Seq(
  organization := "com.sgx",
  version := "0.1.0-SNAPSHOT"
)


lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "AWS-Lambda"
  ).
  enablePlugins(AssemblyPlugin)

assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter { c => Set("asm-commons-6.0.jar", "asm-6.0.jar", "asm-tree-6.0.jar").contains(c.data.getName)}
}