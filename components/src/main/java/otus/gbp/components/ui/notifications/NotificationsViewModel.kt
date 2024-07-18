package otus.gbp.components.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import otus.gbp.components.MainActivityData
import otus.gbp.components.ObservableStorage
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel@Inject constructor(
    private val commonData: @JvmSuppressWildcards ObservableStorage<MainActivityData>
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}