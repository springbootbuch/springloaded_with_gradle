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

## Using from inside 

## Restrictions

Some restrictions may apply, though. Even if method signatures are changed, the MVC handler doesn't notice that for example.

What works for example is changing the signature of `MessageGenerator#getMessage` for example.

Spring Boot devtools may be a better fit if restarts are ok, otherwise you may want to look for JRebel or similar.