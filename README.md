# Android - Coroutine Livedate architecture
## An Android architecture using Retrofit, Coroutines, dependency inversion, LiveData,  ViewModel, LCE, Activity, Last Adapter.

To demonstrate this architecture it uses the publicaly available SpaceX API to list SpaceX rockets and landing pads.

<img src="spaceXdemo.gif" width="250" align="middle" alt="Space X demo">

The flow of data in this Android architecture from top to bottom can be summarized as:

###### Top

- **Retrofit** - https://square.github.io/retrofit/
The Libary used for making HTTP API calls to the SpaceX API

:arrow_down:

- **Coroutines** - To make the above API calls they must be run asynchronously off the main thread. This is done by running a `Deferred` task created by Retrofit within a coroutineScope

:arrow_down:

- **Dependency Inversion** - Dependency Inversion is used for the service that supplies the `LiveDataApiModels`. This should help to make the ViewModels easier to test.

:arrow_down:

- **LiveData** - LiveData objects can be created in the concrete Service class that implements interface for Inversion.  

:arrow_down:

- **ViewModel** - The project uses the `ViewModel` class (part of the Android Jetpack suite of libraries) to store and manage UI - related data in a lifecycle conscious way. The relevant service using Inversion is injected into `ViewModel` 

:arrow_down:

- **LCE** - In most cases when an apps UI is working with HTTP data, it needs to know about 3 different states (Loading, Content, Error). The LCE is a wrapper for the SpaceX content and reflects the states that this data could be in. 

:arrow_down:

- **Activity** - Observers a `LiveData` object in the `ViewModel` called `show` of type `LCE`. The Activity uses the emited object from the `LiveData` to update relevant UI views.

- **LastAdapter** - The app then need to display lists of either rockets or Landing pads. To do so the app uses a `RecyclerView`. To create the adapters for these `RecyclerViews` the app uses a libary called `LastAdapter` for a simpler approach 

###### Bottom
