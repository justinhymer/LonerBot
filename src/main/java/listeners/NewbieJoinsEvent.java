package listeners;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * For if a newbie joins the welcome channel.
 * This will trigger automatically
 * Greet them with some different responses.
 */
public class NewbieJoinsEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildJoinEvent event) {
        //greet with a different response everytime.
        //Greet them by name, but maybe spongebob mock them.

        String response = formulateResponse(event);

        //sendResponse(response);

    }

    private String formulateResponse(GuildJoinEvent event) {
        StringBuilder responseBuilder = new StringBuilder();

        //say something like "xxxx {name} !?..,

        //greeting
        //todo
        //   responseBuilder.append(addGreeting());
        //todo
        String response = "";
        return response;
    }

    private void sendResponse() {

    }

//    private String addGreeting() {
//        //dive into a text file and pick one at random.
//    }

}
