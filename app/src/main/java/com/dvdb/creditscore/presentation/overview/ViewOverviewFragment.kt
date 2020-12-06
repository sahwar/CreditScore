package com.dvdb.creditscore.presentation.overview

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dvdb.creditscore.databinding.OverviewLayoutBinding
import com.dvdb.creditscore.presentation.overview.model.UIModelOverview
import com.dvdb.creditscore.presentation.overview.viewmodel.ViewModelOverview
import com.dvdb.creditscore.presentation.util.FactoryTextSpan
import com.dvdb.creditscore.presentation.util.HelperResourceResolver
import com.dvdb.creditscore.presentation.util.impl.FactoryTextSpanImpl
import com.dvdb.creditscore.presentation.util.impl.HelperResourceResolverImpl
import com.dvdb.creditscore.presentation.util.model.UIModelDataState
import com.dvdb.creditscore.shared.extension.exhaustive
import dagger.hilt.android.AndroidEntryPoint

private const val SHOW_SCORE_DELAY_MS = 2000L

@AndroidEntryPoint
class ViewOverviewFragment : Fragment() {
    private val viewModel: ViewModelOverview by viewModels()

    private lateinit var resourceResolver: HelperResourceResolver
    private lateinit var textSpanFactory: FactoryTextSpan

    private var showScoreTimer: ShowScoreTimer? = null

    private var _binding: OverviewLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return OverviewLayoutBinding.inflate(inflater, container, false).also { binding ->
            _binding = binding
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        observeViewModel()
        fetchDataIfRequired()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        resourceResolver = HelperResourceResolverImpl(context)
        textSpanFactory = FactoryTextSpanImpl(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        showScoreTimer?.cancel()
        showScoreTimer = null
    }

    private fun initView() {
        binding.errorRetry.onErrorRetryClick = {
            viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)
        }
    }

    private fun observeViewModel() {
        viewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            when (dataState) {
                is UIModelDataState.Success -> {
                    setViewsVisibility(scoreGroupVisibility = View.VISIBLE)
                    renderScore(dataState.data)
                }
                is UIModelDataState.Error -> {
                    setViewsVisibility(errorRetryVisibility = View.VISIBLE)
                }
                UIModelDataState.Loading -> {
                    setViewsVisibility(progressBarVisibility = View.VISIBLE)
                }
            }.exhaustive
        })
    }

    private fun setViewsVisibility(
        scoreGroupVisibility: Int = View.GONE,
        progressBarVisibility: Int = View.GONE,
        errorRetryVisibility: Int = View.GONE
    ) {
        binding.scoreGroup.visibility = scoreGroupVisibility
        binding.progressBar.visibility = progressBarVisibility
        binding.errorRetry.visibility = errorRetryVisibility
    }

    private fun renderScore(model: UIModelOverview) {
        binding.scoreSummary.text = model.getScoreSummary(
            textSpanFactory = textSpanFactory,
            resourceResolver = resourceResolver
        )
        binding.scoreSummary.alpha = 0f

        resourceResolver.getColor(model.progressCircleColorRes)?.let { color ->
            binding.scoreCircleProgress.setProgressColor(color)
        }

        showScoreTimer = ShowScoreTimer(model, SHOW_SCORE_DELAY_MS).also {
            it.start()
        }
    }

    private fun fetchDataIfRequired() {
        if (viewModel.dataState.value == null) {
            viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)
        }
    }

    private inner class ShowScoreTimer(
        private val model: UIModelOverview,
        private val duration: Long
    ) : CountDownTimer(duration, 10) {

        override fun onTick(millisUntilFinished: Long) {
            val elapsedTime = (duration - millisUntilFinished).toFloat()
            val progress = (elapsedTime / duration).coerceAtMost(model.progressCirclePercentage)
            val alpha = elapsedTime / duration

            binding.scoreCircleProgress.setProgress(progress)
            binding.scoreSummary.alpha = alpha
        }

        override fun onFinish() {
            binding.scoreCircleProgress.setProgress(model.progressCirclePercentage)
            binding.scoreSummary.alpha = 1f
        }
    }

    companion object {
        fun newInstance() = ViewOverviewFragment()
    }
}