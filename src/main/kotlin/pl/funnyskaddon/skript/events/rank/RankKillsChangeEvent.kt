package pl.funnyskaddon.skript.events.rank

import ch.njol.skript.Skript
import ch.njol.skript.lang.util.SimpleEvent
import net.dzikoysk.funnyguilds.event.rank.KillsChangeEvent

class RankKillsChangeEvent : SimpleEvent() {

    companion object {
        init {
            Skript.registerEvent(
                "Kills Change",
                RankKillsChangeEvent::class.java,
                KillsChangeEvent::class.java,
                "kills change"
            )
        }
    }

}