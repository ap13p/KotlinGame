package com.apiep.kotlingame.core.system

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.ashley.core.Entity
import kotlin.properties.Delegates
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Family
import com.apiep.kotlingame.core.component.PositionComponent
import com.apiep.kotlingame.core.component.VelocityComponent
import com.badlogic.ashley.core.ComponentMapper

/**
 * Created by apiep
 * on 2/23/2015.
 */
class MovementSystem: EntitySystem() {
    var entities: ImmutableArray<Entity> by Delegates.notNull()
    val pm = ComponentMapper.getFor(javaClass<PositionComponent>())
    val vm = ComponentMapper.getFor(javaClass<VelocityComponent>())

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.getFor(
                javaClass<PositionComponent>(),
                javaClass<VelocityComponent>()
        ))
    }
    override fun update(delta: Float) {
        for (i in 0..entities.size() -1) {
            val pc = pm.get(entities[i])
            val vc = vm.get(entities[i])

            pc.pos.x += vc.vel.x * delta
            pc.pos.y += vc.vel.y * delta
        }
    }
}
