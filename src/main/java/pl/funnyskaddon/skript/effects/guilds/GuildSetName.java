package pl.funnyskaddon.skript.effects.guilds;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.dzikoysk.funnyguilds.basic.guild.Guild;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.event.Event;
import pl.funnyskaddon.util.GuildUtil;

public class GuildSetName extends Effect {

    private Expression<Object> guild;
    private Expression<String> name;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
        guild = (Expression<Object>) expr[1];
        name = (Expression<String>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return null;
    }

    @Override
    protected void execute(Event e) {
        try {
            Guild g = GuildUtil.Companion.getGuild(guild.getSingle(e));
            String n = name.getSingle(e);
            try {
                g.setName(n);
            } catch (Exception ex) {
                return;
            }
        } catch (Exception ex) {
            return;
        }
    }
}
