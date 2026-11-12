package com.iwex.poolpredictor.domain.repository

import androidx.lifecycle.LiveData
import com.iwex.poolpredictor.domain.model.AimSettings
import com.iwex.poolpredictor.domain.model.ShotResult
import com.iwex.poolpredictor.domain.model.TablePosition

interface NativeRepository {
    val shotResult: LiveData<ShotResult>

    fun updateAimSettings(aimSettings: AimSettings)

    fun setTablePosition(tablePosition: TablePosition)

    /** Submit detected ball centers and cue direction to the native physics engine. */
    fun predictFromVision(
        ballData: FloatArray,
        shotAngle: Float,
        shotPower: Float,
        spinX: Float = 0f,
        spinY: Float = 0f
    )

    fun updateShotResult(shotResultArray: FloatArray)

    fun exit()
}
