package scala.meta
package config

import scala.meta.internal.config.core.BuildInfo

private[meta] trait Api {
  private def ensureVersion(key: String, value: String): Version = {
    def fail = sys.error(s"fatal error reading BuildInfo: $key $value is not a valid version")
    Version.parse(value).getOrElse(fail)
  }
  lazy val scalaVersion: Version = ensureVersion("scalaVersion", BuildInfo.scalaVersion)
  lazy val coreVersion: Version = ensureVersion("version", BuildInfo.scalaVersion)
}