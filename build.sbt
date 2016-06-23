name := """hospital"""

version := "1.0-SNAPSHOT"

playJavaSettings

ebeanEnabled := false

lazy val sqljdbc = project
  .in(file("modules/sqljdbc"))
  .settings(
    organization              := "com.hynnet",
    name                      := "sqljdbc-chs",
    version                   := "4.2-IDonKnow",
    crossPaths                := false,  //don't add scala version to this artifacts in repo
    publishMavenStyle         := true,
    autoScalaLibrary          := false,  //don't attach scala libs as dependencies
    description               := "sql server JDBC project for publishing dependency to maven repo, use 'sbt publishLocal' to install it",
    packageBin in Compile     := baseDirectory.value / s"${name.value}.jar"
    //packageDoc in Compile     := baseDirectory.value / s"${name.value}-javadoc.jar"
  )

lazy val ojdbc = project
  .in(file("modules/ojdbc"))
  .settings(
    organization              := "com.hynnet",
    name                      := "ojdbc6",
    version                   := "6.0.0",
    crossPaths                := false,  //don't add scala version to this artifacts in repo
    publishMavenStyle         := true,
    autoScalaLibrary          := false,  //don't attach scala libs as dependencies
    description               := "ORALCE JDBC project for publishing dependency to maven repo, use 'sbt publishLocal' to install it",
    packageBin in Compile     := baseDirectory.value / s"${name.value}.jar"
    //packageDoc in Compile     := baseDirectory.value / s"${name.value}-javadoc.jar"
  )

libraryDependencies ++= Seq(
    javaCore,
    javaJpa,
   "com.hynnet" % "sqljdbc-chs" % "4.2-IDonKnow",
	"com.hynnet" % "ojdbc6" % "6.0.0",
    //"mysql" % "mysql-connector-java" % "5.1.18",
    "org.springframework" % "spring-context" % "4.2.5.RELEASE",
    "javax.inject" % "javax.inject" % "1",
//    "javax.persistence" % "persistence-api" % "1.0",
    "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.0.Final",
    "org.springframework.data" % "spring-data-jpa" % "1.10.2.RELEASE",
    "org.springframework" % "spring-expression" % "3.2.2.RELEASE",
    "org.hibernate" % "hibernate-entitymanager" % "3.6.10.Final",
    "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

//fork in run := true