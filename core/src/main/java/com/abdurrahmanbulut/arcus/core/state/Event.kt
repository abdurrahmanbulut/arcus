package com.abdurrahmanbulut.arcus.core.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

data class EventState<T>(
    val data: T? = null,
)

fun createEvent(): MutableState<EventState<Unit>> = mutableStateOf(EventState())

fun <T> createEvent(initialData: T? = null): MutableState<EventState<T>> = mutableStateOf(EventState(data = initialData))

fun <T, U> createEventWith2Data(): MutableState<EventState<Pair<T?, U?>>> = mutableStateOf(EventState(data = null to null))

fun <T, U, V> createEventWith3Data(): MutableState<EventState<Triple<T?, U?, V?>>> =
    mutableStateOf(EventState(data = Triple(null, null, null)))

fun <T, U, V, W> createEventWith4Data(): MutableState<EventState<Data4<T?, U?, V?, W?>>> =
    mutableStateOf(EventState(data = Data4(null, null, null, null)))

data class Data4<T, U, V, W>(
    val first: T,
    val second: U,
    val third: V,
    val fourth: W,
)

fun MutableState<EventState<Unit>>.trigger() {
    value = EventState(Unit)
}

fun <T> MutableState<EventState<T>>.trigger(data: T) {
    value = EventState(data)
}

fun <T, U> MutableState<EventState<Pair<T?, U?>>>.trigger(
    data1: T,
    data2: U,
) {
    value = EventState(data1 to data2)
}

fun <T, U, V> MutableState<EventState<Triple<T?, U?, V?>>>.trigger(
    data1: T,
    data2: U,
    data3: V,
) {
    value = EventState(Triple(data1, data2, data3))
}

fun <T, U, V, W> MutableState<EventState<Data4<T?, U?, V?, W?>>>.trigger(
    data1: T,
    data2: U,
    data3: V,
    data4: W,
) {
    value = EventState(Data4(data1, data2, data3, data4))
}

@Composable
fun ObserveEvent(
    eventState: State<EventState<Unit>>,
    onTriggered: () -> Unit,
) {
    LaunchedEffect(eventState.value) {
        eventState.value.data?.let {
            onTriggered()
        }
    }
}

@Composable
fun <T> ObserveEvent(
    eventState: State<EventState<T>>,
    onTriggered: (T) -> Unit,
) {
    LaunchedEffect(eventState.value) {
        eventState.value.data?.let { data ->
            onTriggered(data)
        }
    }
}

@Composable
fun <T, U> ObserveEvent(
    eventState: State<EventState<Pair<T?, U?>>>,
    onTriggered: (T?, U?) -> Unit,
) {
    LaunchedEffect(eventState.value) {
        eventState.value.data?.let { (data1, data2) ->
            onTriggered(data1, data2)
        }
    }
}

@Composable
fun <T, U, V> ObserveEvent(
    eventState: State<EventState<Triple<T?, U?, V?>>>,
    onTriggered: (T?, U?, V?) -> Unit,
) {
    LaunchedEffect(eventState.value) {
        eventState.value.data?.let { (data1, data2, data3) ->
            onTriggered(data1, data2, data3)
        }
    }
}

@Composable
fun <T, U, V, W> ObserveEvent(
    eventState: State<EventState<Data4<T?, U?, V?, W?>>>,
    onTriggered: (T?, U?, V?, W?) -> Unit,
) {
    LaunchedEffect(eventState.value) {
        eventState.value.data?.let { data ->
            onTriggered(data.first, data.second, data.third, data.fourth)
        }
    }
}
