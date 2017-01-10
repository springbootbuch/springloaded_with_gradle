# Demo that uses SpringLoaded with Gradle

## How to run

In one terminal, run 

```
./gradlew build --continuous   
```

and in a second:

```
./gradlew bootRun
```

You can change any class, constructor or method signature. Changed class will be automatically reloaded.

## Using from inside IntelliJ IDEA

IntelliJ IDEA compiles classes from Gradle projects to a different location than Gradle itself, so SpringLoaded won't see them. You take care of this with the following snippet inside `build.gradle`:

```
apply plugin: 'idea'
idea {
    module {
        inheritOutputDirs = false
        outputDir = file("$buildDir/classes/main/")
    }
}
```

## Restrictions

Some restrictions may apply, though. Even if method signatures are changed, the MVC handler doesn't notice that for example.

What works for example is changing the signature of `MessageGenerator#getMessage` for example.

Spring Boot devtools may be a better fit if restarts are ok, otherwise you may want to look for JRebel or similar.