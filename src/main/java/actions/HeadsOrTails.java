package actions;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;

public class HeadsOrTails {

    GuildMessageReceivedEvent event;
    final String defaultResponse = "idk";

    public HeadsOrTails() {
        this.event = event;
    }

    /**
     * Returns a 50/50 headsortails back in a message
     *
     * @return
     */
    public String getResponse() {
        Random random = new Random();
        String reponse = defaultResponse;

        if (random.nextBoolean()) {
            reponse = "heads bitch";
        } else {
            reponse = "tails loser";
        }
        return reponse;
    }
}
