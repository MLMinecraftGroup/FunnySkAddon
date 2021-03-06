package pl.funnyskaddon.skript.expressions.guild

import ch.njol.skript.Skript
import ch.njol.skript.doc.Description
import ch.njol.skript.doc.Examples
import ch.njol.skript.doc.Name
import ch.njol.skript.lang.ExpressionType
import org.bukkit.event.Event
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.skript.expressions.GuildExpression

@FunnyDoc
@Name("Guild PvP")
@Description("Zwraca czy pvp w gildii jest włączone czy wyłączone")
@Examples(
    "send \"%\"AC4U\" guild pvp%\"",
    "set {_pvpStatus} to \"AC4U\" guild pvp"
)
class GuildPvPExpression : GuildExpression<Boolean>() {

    companion object {
        init {
            Skript.registerExpression(
                GuildPvPExpression::class.java,
                Boolean::class.javaObjectType,
                ExpressionType.PROPERTY,
                "%object%(|'s) guild pvp [[is] enabled]"
            )
        }
    }

    override fun get(event: Event): Array<Boolean>? {
        val guild = getGuild(event)

        if (guild != null) {
            return arrayOf(guild.pvP)
        }

        return null
    }

    override fun getReturnType(): Class<Boolean> {
        return Boolean::class.javaObjectType
    }

}