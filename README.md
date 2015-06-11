The sbt equivalent of the [JAX-WS Maven plug-in][1]. It's a bit of a poor relation at the moment, supporting `wsimport` only (to generate Java from WSDL).

You should also consider using [scalaxb][2].

Compatible with sbt 0.12.x and 0.13.x.

Configuration
-------------

Put this in your `project/plugins.sbt`:

    addSbtPlugin("net.koofr" % "sbt-jaxws" % "0.1")

Light configuration example (in `build.sbt`):

    sbtJaxWsSettings

    SbtJaxWsKeys.wsdlFiles <+= baseDirectory(_ / "service.wsdl")

    SbtJaxWsKeys.bindingFiles <+= baseDirectory(_ / "message.xsd")

    SbtJaxWsKeys.targetVersion := "2.1"

Full configuration example:

    import sbtjaxws.Plugin.{ SbtJaxWsKeys, sbtJaxWsSettings }

    class MyBuild extends Build {
         lazy val myProject = Project("Mine", file("."), settings = Defaults.defaultSettings ++ sbtJaxWsSettings ++ Seq(
             SbtJaxWsKeys.wsdlFiles <+= baseDirectory(_ / "service.wsdl"),
             SbtJaxWsKeys.bindingFiles <+= baseDirectory(_ / "message.xsd"),
             SbtJaxWsKeys.targetVersion := "2.1"))
    }

There is an `SbtJaxWsKeys.otherArgs` for other `wsimport` arguments -- if you use this,
please consider adding a new setting to the plug-in and sending a pull request ;-)

  [1]: http://jax-ws-commons.java.net/jaxws-maven-plugin/
  [2]: http://scalaxb.org/sbt-scalaxb
