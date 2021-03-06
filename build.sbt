import com.typesafe.tools.mima.core._
import com.typesafe.tools.mima.plugin.MimaKeys._

scodecModule := "scodec-core"

scodecPrimaryModule

contributors ++= Seq(Contributor("mpilquist", "Michael Pilquist"), Contributor("pchiusano", "Paul Chiusano"))

rootPackage := "scodec"

libraryDependencies ++= Seq(
  "org.scodec" %% "scodec-bits" % "1.0.7-SNAPSHOT",
  "com.chuusai" %% "shapeless" % "2.2.2",
  "org.scalatest" %% "scalatest" % "3.0.0-M1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.3" % "test",
  "org.bouncycastle" % "bcpkix-jdk15on" % "1.50" % "test"
)

// Shapeless 2.1.0 on Scala 2.10 requires macro paradise
libraryDependencies ++= {
  if (scalaBinaryVersion.value startsWith "2.10") Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)) else Nil
}

OsgiKeys.exportPackage := Seq("!scodec.bits,scodec.*;version=${Bundle-Version}")

binaryIssueFilters ++= Seq(
)

enablePlugins(BuildInfoPlugin)
