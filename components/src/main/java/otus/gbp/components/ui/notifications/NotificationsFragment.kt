package otus.gbp.components.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import otus.gbp.components.databinding.FragmentNotificationsBinding

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val notificationsViewModel: NotificationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bindHomeText()
        bindDashboardText()
        bindNotificationText()

        return root
    }

    private fun bindHomeText() {
        val textView: TextView = binding.textHome
        notificationsViewModel.homeText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    private fun bindDashboardText() {
        val textView: TextView = binding.textDashboard
        notificationsViewModel.dashboardText.observe(viewLifecycleOwner) {
            textView.setTextKeepState(it)
        }
    }

    private fun bindNotificationText() {
        val textView: TextView = binding.textNotifications
        notificationsViewModel.notificationsText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}