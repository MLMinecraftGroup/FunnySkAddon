package pl.funnyskaddon.skript.expressions.guild

import ch.njol.skript.Skript
import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.ExpressionType
import ch.njol.skript.lang.SkriptParser
import ch.njol.skript.lang.util.SimpleExpression
import ch.njol.util.Kleenean
import net.dzikoysk.funnyguilds.basic.guild.GuildUtils
import org.bukkit.event.Event

class GuildNameFromTagExpression : SimpleExpression<String>() {

    var tag: Expression<String>? = null

    companion object {
        init {
            Skript.registerExpression(
                GuildNameFromTagExpression::class.java,
                String::class.javaObjectType,
                ExpressionType.PROPERTY,
                "guild name from tag %string%"
            )
        }
    }

    override fun init(
        expression: Array<Expression<*>>,
        matchedPattern: Int,
        isDelayed: Kleenean,
        parseResult: SkriptParser.ParseResult
    ): Boolean {
        tag = expression[0] as Expression<String>
        return true
    }

    override fun get(event: Event): Array<String> {
        return arrayOf(GuildUtils.getByTag(tag?.getSingle(event)).name)
    }

    override fun isSingle(): Boolean {
       return true
    }

    override fun toString(event: Event?, debug: Boolean): String? {
        return null
    }


    override fun getReturnType(): Class<out String> {
        return String::class.javaObjectType
    }

}