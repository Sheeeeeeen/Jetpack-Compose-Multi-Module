pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Jetpack Compose Multi Module"
include(":app")
include(":core")
include(":feature")
include(":core:designsystem")
include(":core:network")
include(":core:database")
include(":core:analytics")
include(":feature:login")
include(":core:datastore")
include(":feature:dashboard")
include(":data")
include(":feature:notification")
include(":feature:profile")
