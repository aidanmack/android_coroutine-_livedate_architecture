# Android - Coroutine Livedate architecture
## An Android architecture using Retrofit, Coroutines, dependency inversion, LiveData,  ViewModel, LCE, Activity, Last Adapter.

To demonstrate this architecture it uses the publicaly available SpaceX API to list SpaceX rockets and landing pads.




The flow of data in this Android architecture from top to bottom can be summarized as:

###### Top

- **Retrofit** - https://square.github.io/retrofit/
The Libary used for making HTTP API calls to the SpaceX API

:arrow_down:

- **Coroutines** - To make the above API calls they must be run Asynchronously off the main thread. This is done by running a `Deferred` task created by Retrofit within a coroutineScope

:arrow_down:

- **Dependency Inversion** - Dependency Inversion is used for the service that supplies the SpaceX API `Deferred` task to be used in the `LiveData` objects

:arrow_down:

- **ViewModel** - The project uses the `ViewModel` class (part of the Android Jetpack suite of libraries) to store and manage UI - related data in a lifecycle conscious way







