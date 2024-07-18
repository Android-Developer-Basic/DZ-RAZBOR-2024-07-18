package otus.gbp.components.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import otus.gbp.components.MainActivityData
import otus.gbp.components.ObservableStorage
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val commonData: @JvmSuppressWildcards ObservableStorage<MainActivityData>
) : ViewModel() {
    val homeText: LiveData<String> = commonData.state.map { it.homeData }
    val dashboardText: LiveData<String> = commonData.state.map { it.dashboardData }
    val notificationsText: LiveData<String> = commonData.state.map { it.notificationsData }
    fun setDashboardText(value: String) {
        commonData.update { copy(dashboardData = value) }
    }
}