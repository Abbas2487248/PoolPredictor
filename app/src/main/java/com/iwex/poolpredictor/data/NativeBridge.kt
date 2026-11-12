package com.iwex.poolpredictor.data

import com.iwex.poolpredictor.domain.repository.NativeRepository

@Suppress("KotlinJniMissingFunction")
class NativeBridge {
    companion object {
        init {
            System.loadLibrary("poolpredictor")
        }

        /**
         * Runs the physics engine using ball centers detected from a screenshot.
         * ballData format: [ballCount, cueX, cueY, ball1X, ball1Y, ...],
         * where each coordinate is normalized to the detected table rectangle.
         * shotAngle is in radians in the engine's coordinate system.
         */
        @JvmStatic
        external fun predictFromVision(
            ballData: FloatArray,
            shotAngle: Float,
            shotPower: Float,
            spinX: Float,
            spinY: Float
        ): FloatArray

        @JvmStatic
        external fun updateAimSettings(
            drawLinesEnabled: Boolean,
            drawShotStateEnabled: Boolean,
            drawOpponentsLinesEnabled: Boolean,
            preciseTrajectoriesEnabled: Boolean,
            cuePower: Int,
            cueSpin: Int
        )

        @JvmStatic
        external fun exitThread()

        @JvmStatic
        external fun setNativeRepository(nativeRepository: NativeRepository)

        @JvmStatic
        external fun setTablePosition(left: Float, top: Float, right: Float, bottom: Float)
    }
}
