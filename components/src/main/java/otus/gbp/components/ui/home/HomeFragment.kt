package otus.gbp.components.ui.home

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
import otus.gbp.components.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bindHomeText()
        bindDashboardText()
        bindNotificationText()

        return root
    }

    private fun bindHomeText() {
        val textView: TextView = binding.textHome
        homeViewModel.homeText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    private fun bindDashboardText() {
        val textView: TextView = binding.textDashboard
        homeViewModel.dashboardText.observe(viewLifecycleOwner) {
            textView.setTextKeepState(it)
        }
    }

    private fun bindNotificationText() {
        val textView: TextView = binding.textNotifications
        homeViewModel.notificationsText.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}