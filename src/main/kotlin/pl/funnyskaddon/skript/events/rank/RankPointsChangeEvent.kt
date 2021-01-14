package pl.funnyskaddon.skript.events.rank

import ch.njol.skript.Skript
import ch.njol.skript.lang.util.SimpleEvent
import net.dzikoysk.funnyguilds.event.rank.PointsChangeEvent

class RankPointsChangeEvent : SimpleEvent() {

    companion object {
        init {
            Skript.registerEvent(
                "Points Change",
                RankPointsChangeEvent::class.java,
                PointsChangeEvent::class.java,
                "points change"
            )
        }
    }

}