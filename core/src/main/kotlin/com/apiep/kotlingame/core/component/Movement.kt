package com.apiep.kotlingame.core.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

/**
 * Created by apiep
 * on 2/23/2015.
 */

data class PositionComponent(
        val pos: Vector2 = Vector2(0f, 0f)
): Component()

data class VelocityComponent(
        val vel: Vector2 = Vector2()
): Component()
