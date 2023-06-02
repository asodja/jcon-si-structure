# Project structure and sharing build logic

## Project structure

Our project is setup in a way that all scripts and build logic that are required to build the project and a business code are separated.
To do that we put all our business logic projects in to `projects` folder.
That setup is done through `settings.gradle(.kts)` file, where we set `projectDir` for every project to be in `projects` subfolder.

That kind of organization helps us navigate in our project.

## Sharing build logic

This demo shows how to structure a Gradle project so it can stay maintainable.
The idea is that we keep `build.gradle(.kts)` files as declarative as possible and move all complex or shared code to convention plugins.

Convention plugins are a simple plugin, that looks like a normal build scripts. 
Examples of these plugins can be seen in `buildSrc/src/main/kotlin`

There we can see "small building blocks" plugins prefixed with `common.*`.
These common plugins follow single-responsibility principle, for example to edit `Checkstyle` rules we have 
`common.checkstyle.gradle.kts`, to edit `java` settings we have `common.java.gradle.kts` and so on. 

These small plugins are then used in "project type" specific plugins, prefixed with `jcon.*`. 
For library projects we have `jcon.library-conventions.gradle.kts` and for app projects we have `jcon.app-conventions.gradle.kts`.
These two plugins are used then in library and web-app project and replace all logic that would normally be in the `build.gradle.kts`.

With that we get simple and declarative `build.gradle(.kts)` files, where we have mostly only `plugins` and `dependencies` block. 

# Other features presented in the demo

We also took a look at [toolchains](https://docs.gradle.org/current/userguide/toolchains.html), that help manage JDKs used by the project.
With toolchains we can avoid modifying `JAVA_HOME` for every project: Gradle takes care of picking up the right JDK for specified language version.

We also took a look at [Version Catalog](https://docs.gradle.org/current/userguide/platforms.html#sub:central-declaration-of-dependencies) that helps managing dependencies.
Version Catalog is also easy to update, e.g. with [littlerobots/version-catalog-update-plugin](https://github.com/littlerobots/version-catalog-update-plugin) or [Splitties/refreshVersions](https://github.com/Splitties/refreshVersions).
