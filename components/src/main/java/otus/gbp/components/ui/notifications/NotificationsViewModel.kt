package otus.gbp.components.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import otus.gbp.components.MainActivityData
import otus.gbp.components.ObservableStorage
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel@Inject constructor(
    private val commonData: @JvmSuppressWildcards ObservableStorage<MainActivityData>
) : ViewModel() {
    val homeText: LiveData<String> = commonData.state.map { it.homeData }
    val dashboardText: LiveData<String> = commonData.state.map { it.dashboardData }
    val notificationsText: LiveData<String> = commonData.state.map { it.notificationsData }
}