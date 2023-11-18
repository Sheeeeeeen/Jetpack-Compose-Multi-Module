package ph.com.sheen.jetpackcomposemultimodule

import android.animation.ObjectAnimator
import android.os.Build
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.window.SplashScreen
import android.window.SplashScreenView
import androidx.core.animation.doOnEnd

/**
 * Use this function to customized the animation of splash screen
 * **/
fun SplashScreen.addSplashScreenEffect(startAnimation: (ObjectAnimator) -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        this.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 2000L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
//            slideUp.start()
            startAnimation(slideUp)
        }
    }
}

