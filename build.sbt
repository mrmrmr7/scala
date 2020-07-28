import sbt.Keys.libraryDependencies

val app = (project in file("."))
    .settings(
      name := "SbtTestProject",
      version := "0.1",
      scalaVersion := "2.11.12",
      mainClass in assembly := Some("epam.mrmrmr.PersonReader.PersonPrinter"),
      assemblyJarName in assembly := "app.jar",
      assemblyMergeStrategy in assembly := {
            case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
            case _ => MergeStrategy.last
      },
      libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"
    )



