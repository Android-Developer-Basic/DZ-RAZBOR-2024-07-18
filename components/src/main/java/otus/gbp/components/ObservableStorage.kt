package otus.gbp.components

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ObservableStorage<T>(value: T) {
    private val _state = MutableLiveData(value)

    val state: LiveData<T> get() = _state

    fun update(block: T.() -> T) {
        val currentValue = requireNotNull(_state.value) { "Misconfiguration. Value expected!" }
        val newValue = currentValue.block()
        if (newValue != currentValue) {
            _state.postValue(newValue)
        }
    }
}