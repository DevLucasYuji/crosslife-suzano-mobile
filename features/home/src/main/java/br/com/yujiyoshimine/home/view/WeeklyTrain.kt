package br.com.yujiyoshimine.home.view

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.yujiyoshimine.commons.R
import br.com.yujiyoshimine.commons.components.Loading
import br.com.yujiyoshimine.commons.components.error.Error
import br.com.yujiyoshimine.commons.components.weeklytrain.WeeklyTrainItem
import br.com.yujiyoshimine.commons.extensions.capitalize
import br.com.yujiyoshimine.commons.theme.Space
import br.com.yujiyoshimine.commons.utils.OnWeeklyTrainClick
import br.com.yujiyoshimine.commons.utils.Saver.getPagerState
import br.com.yujiyoshimine.domain.model.Result
import br.com.yujiyoshimine.domain.model.WeeklyTrain
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@Composable
@ExperimentalPagerApi
fun WeeklyTrain(
    state: Result<List<WeeklyTrain>>,
    onRetryClick: () -> Unit,
    onWeeklyTrainClick: OnWeeklyTrainClick,
) {
    Text(
        modifier = Modifier
            .padding(top = Space.XS)
            .padding(horizontal = Space.BORDER),
        text = stringResource(id = R.string.weekly_train).capitalize(),
        style = MaterialTheme.typography.h3,
    )

    when (state) {
        Result.Initial, Result.Loading -> Loading()
        is Result.Error -> Error { onRetryClick() }
        is Result.Success -> WeeklyTrainUI(state.data, onWeeklyTrainClick)
    }
}

@ExperimentalPagerApi
@Composable
private fun WeeklyTrainUI(
    weeklyTrains: List<WeeklyTrain>,
    onWeeklyTrainClick: OnWeeklyTrainClick,
) {
    val pagerState = rememberSaveable(saver = getPagerState(7, true)) {
        PagerState(
            pageCount = weeklyTrains.size,
            infiniteLoop = true,
            currentPage = br.com.yujiyoshimine.commons.utils.DayOfWeek.getCurrentDay(),
            offscreenLimit = 7,
        )
    }
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Space.XXS),
        horizontalAlignment = Alignment.Start,
        state = pagerState,
    ) { page ->
        val weeklyTrain = weeklyTrains[page]
        WeeklyTrainItem(
            Modifier
                .padding(start = Space.BORDER)
                .align(Alignment.CenterStart)
                .fillMaxWidth(0.8F)
                .defaultMinSize(minHeight = 200.dp)
                .aspectRatio(1.5F),
            weeklyTrain,
            onWeeklyTrainClick = onWeeklyTrainClick
        )
    }
}
