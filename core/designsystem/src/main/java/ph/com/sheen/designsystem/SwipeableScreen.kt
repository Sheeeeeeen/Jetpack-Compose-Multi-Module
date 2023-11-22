@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.designsystem

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import ph.com.sheen.designsystem.swipe.DragAnchors
import kotlin.math.roundToInt

@Composable
fun SwipeableContainer(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(Modifier) -> Unit,
) {
    val density = LocalDensity.current

    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Default,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = {
                with(density) {
                    100.dp.toPx()
                }
            },
            animationSpec = tween()
        )
    }

    Box(
        modifier = modifier
            .onSizeChanged { layoutSize ->
                val dragEndPoint = layoutSize.width / 7
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors
                            .values()
                            .forEach { anchor ->
                                anchor at dragEndPoint * anchor.fraction
                            }
                    }
                )
            },
        contentAlignment = Alignment.CenterStart
    ) {
        content(
            Modifier
                .offset { IntOffset(x = state.requireOffset().roundToInt(), y = 0) }
                .anchoredDraggable(state = state, orientation = Orientation.Horizontal)
        )
    }
}