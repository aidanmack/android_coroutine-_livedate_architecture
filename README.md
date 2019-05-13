# Android - coroutine livedate architecture
## An Android architecture using Retrofit, Coroutines, dependency inversion (Api Service), LiveData,  ViewModel, LCE, Activity, Last Adapter.

To demonstrate this architecture it uses the publicaly available SpaceX API to list SpaceX rockets and landing pads.




The flow of data in this Android architecture from top to bottom can be summarized as:

###### Top

- **Retrofit** - https://square.github.io/retrofit/
The Libary used for making HTTP API calls to the SpaceX API

- **Coroutines** - To make the above API calls they must be run Asynchronously off the main thread. This is done by running a `Deffered` task created by Retrofit within a coroutineScope

- **Dependency Inversion** - To be continued





