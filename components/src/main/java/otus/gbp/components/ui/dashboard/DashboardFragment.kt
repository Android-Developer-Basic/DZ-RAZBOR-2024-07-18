package otus.gbp.components.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import otus.gbp.components.databinding.FragmentDashboardBinding

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bindHomeText()
        bindDashboardText()
        bindNotificationText()

        return root
    }

    private fun bindHomeText() {
        val textView: TextView = binding.textHome
        dashboardViewModel.homeText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    private fun bindDashboardText() {
        val textView: TextInputEditText = binding.textDashboardInput
        textView.addTextChangedListener {
            dashboardViewModel.setDashboardText(it.toString())
        }
        dashboardViewModel.dashboardText.observe(viewLifecycleOwner) {
            textView.setTextKeepState(it)
        }
    }

    private fun bindNotificationText() {
        val textView: TextView = binding.textNotifications
        dashboardViewModel.notificationsText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}