package com.apiep.kotlingame.core.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Engine
import com.apiep.kotlingame.core.component.PositionComponent
import com.apiep.kotlingame.core.component.RenderableComponent
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Sprite
import com.apiep.kotlingame.core.Main
import com.badlogic.gdx.graphics.Texture

class BackgroundEntity(val engine: Engine) : Entity() {
    {
        this.add(PositionComponent())
        this.add(RenderableComponent(Sprite(Main.assetManager.get<Texture>("badlogic.jpg"))))
        engine.addEntity(this)
    }
}
