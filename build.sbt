name := "et002"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq (
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % "1.9.10",
  "com.badlogicgames.gdx" % "gdx-platform" % "1.9.10" classifier "natives-desktop",
  "com.badlogicgames.gdx" % "gdx-freetype" % "1.9.10",
  "com.badlogicgames.gdx" % "gdx-freetype-platform" % "1.9.10" classifier "natives-desktop",
  "io.monix" %% "monix" % "3.1.0",
)