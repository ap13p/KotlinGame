package com.apiep.kotlingame.core.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import kotlin.properties.Delegates

/**
 * Created by apiep
 * on 2/23/2015.
 */

data class RenderableComponent(
    var textureRegion: TextureRegion?
): Component()

