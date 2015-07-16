name := "sbt-jaxws"

organization := "net.koofr"

version := "0.2"

sbtPlugin := true

crossBuildingSettings

CrossBuilding.crossSbtVersions := Seq("0.12", "0.13")

libraryDependencies += "org.glassfish.ha" % "ha-api" % "3.1.8" artifacts( 
  Artifact("ha-api", "jar", "jar") 
) 

libraryDependencies += "com.sun.xml.ws" % "jaxws-tools" % "2.2.7-promoted-b24"

publishMavenStyle := true

publishArtifact in Test := false

publishTo <<= isSnapshot { isSnapshot =>
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot) Some("snapshots" at nexus + "content/repositories/snapshots")
  else            Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
    <inceptionYear>2012</inceptionYear>
    <url>http://github.com/koofr/sbt-jaxws</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:koofr/sbt-jaxws.git</url>
      <connection>scm:git:git@github.com:koofr/sbt-jaxws</connection>
    </scm>
    <developers>
      <developer>
        <id>mdr</id>
        <name>Matt Russell</name>
        <url>https://github.com/mdr/</url>
      </developer>
      <developer>
        <id>edofic</id>
        <name>Andraz Bajt</name>
        <url>https://github.com/edofic</url>
      </developer>
      <developer>
        <id>bancek</id>
        <name>Luka Zakrajšek</name>
        <url>https://github.com/bancek</url>
      </developer>
    </developers>
  }

