# LiveData-CombineUtil-Java

LiveData-CombineUtil-Java contains helper functions for LiveData, to combine their latest emissions.

``` java
import static com.zhuinden.livedatacombineutiljava.LiveDataCombineUtil.*;

combine(liveData1, liveData2, liveData3, (t1, t2, t3) -> {
    // map to something
}).observe(viewLifecycleOwner, (mapped) -> {
    // do something with mapped values
});
```

## Why?

It's useful when you want to combine multiple reactive streams together and get a combined object of the latest values.

## Using LiveData-CombineUtil-Java

In order to use LiveData-CombineUtil-Java, you need to add `jitpack` to your project root `build.gradle.kts`
(or `build.gradle`):

``` kotlin
// build.gradle.kts
allprojects {
    repositories {
        // ...
        maven { setUrl("https://jitpack.io") }
    }
    // ...
}
```

or

``` groovy
// build.gradle
allprojects {
    repositories {
        // ...
        maven { url "https://jitpack.io" }
    }
    // ...
}
```

and then, add the dependency to your module's `build.gradle.kts` (or `build.gradle`):

``` kotlin
// build.gradle.kts
implementation("com.github.Zhuinden:livedata-combineutil-java:1.0.0")
```

or

``` groovy
// build.gradle
implementation 'com.github.Zhuinden:livedata-combineutil-java:1.0.0'
```

## License

    Copyright 2021 Gabor Varadi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
