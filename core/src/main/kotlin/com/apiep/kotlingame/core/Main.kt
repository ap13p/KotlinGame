package com.apiep.kotlingame.core

import com.badlogic.gdx.ApplicationListener
import com.badlogic.ashley.core.Engine
import kotlin.properties.Delegates
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Gdx
import com.apiep.kotlingame.core.entity.BackgroundEntity
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.apiep.kotlingame.core.system.MovementSystem
import com.apiep.kotlingame.core.system.RenderableSystem

/**
 * Created by apiep
 * on 2/23/2015.
 */
class Main : ApplicationListener {
    var engine: Engine by Delegates.notNull()
    var batch: SpriteBatch by Delegates.notNull()
    class object {
        var assetManager: AssetManager by Delegates.notNull()
    }

    override fun create() {
        engine = Engine()
        batch = SpriteBatch()
        assetManager = AssetManager()

        assetManager.load("badlogic.jpg", javaClass<Texture>())
        while(!assetManager.update()) {}

        setupEngine()
        addEntity()
    }

    override fun render() {
        engine.update(Gdx.graphics.getDeltaTime())
    }

    override fun dispose() {
        batch.dispose()
        assetManager.dispose()
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    fun setupEngine() {
        engine.addSystem(MovementSystem())
        engine.addSystem(RenderableSystem(batch))
    }

    fun addEntity() {
        BackgroundEntity(engine)
    }
}
