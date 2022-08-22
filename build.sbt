ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "3.1.3"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    // "-explain",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    // "-Yexplicit-nulls",   // experimental (I've seen it cause issues with circe)
    // "-Ykind-projector",
    // "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) //++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val zioVersion = "2.0.0"

lazy val dependencies = Seq(
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-test" % zioVersion,
    "dev.zio" %% "zio-test-sbt" % zioVersion,
    "dev.zio" %% "zio-streams" % zioVersion,
    "dev.zio" %% "zio-test-junit" % zioVersion,
    "joda-time" % "joda-time" % "2.11.0"
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

lazy val `root` =
  project
    .in(file("."))
    .settings(
        name := "faid",
        libraryDependencies ++= dependencies
    )

