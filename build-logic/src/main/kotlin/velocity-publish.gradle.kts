plugins {
    java
    `maven-publish`
}

extensions.configure<PublishingExtension> {
    repositories {
        maven {
            credentials(PasswordCredentials::class.java)

            name = "SunnyInfra"
            val base = "https://repo.sunnyinfra.cloud"
            val releasesRepoUrl = "$base/releases/"
            val snapshotsRepoUrl = "$base/development/"
            setUrl(if (version.toString().contains("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("Velocity")
                description.set("The modern, next-generation Minecraft server proxy")
                url.set("https://papermc.io/software/velocity")
                scm {
                    url.set("https://github.com/PaperMC/Velocity")
                    connection.set("scm:git:https://github.com/PaperMC/Velocity.git")
                    developerConnection.set("scm:git:https://github.com/PaperMC/Velocity.git")
                }
            }
        }
    }
}
