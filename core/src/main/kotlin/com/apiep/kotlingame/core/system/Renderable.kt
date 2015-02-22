package com.apiep.kotlingame.core.system

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.ashley.core.Entity
import kotlin.properties.Delegates
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Family
import com.apiep.kotlingame.core.component.RenderableComponent
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.ashley.core.ComponentMapper
import com.apiep.kotlingame.core.component.PositionComponent

/**
 * Created by apiep
 * on 2/23/2015.
 */
class RenderableSystem(val batch: SpriteBatch): EntitySystem() {
    var entities: ImmutableArray<Entity> by Delegates.notNull()
    val rm = ComponentMapper.getFor(javaClass<RenderableComponent>())
    val pm = ComponentMapper.getFor(javaClass<PositionComponent>())

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.getFor(
                javaClass<RenderableComponent>()
        ))
    }
    override fun update(delta: Float) {
        Gdx.gl20.glClearColor(0f,0f,0f,1f)
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        for (i in 0..entities.size() -1) {
            val rc = rm.get(entities[i])
            val pc = pm.get(entities[i])
            batch.draw(rc.textureRegion, pc.pos.x, pc.pos.y)
        }
        batch.end()
    }
}
