package com.apiep.kotlingame.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.apiep.kotlingame.core.Main
import com.badlogic.gdx.backends.lwjgl.LwjglApplication

/**
 * Created by apiep
 * on 2/23/2015.
 */
public fun main(args: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 800
    config.height = 600
    config.resizable = false
    config.useHDPI = true
    config.title = "KotlinGameku"

    LwjglApplication(Main(), config)
}
