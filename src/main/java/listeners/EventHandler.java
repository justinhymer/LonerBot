package listeners;

import actions.CallSomeoneAName;
import actions.HeadsOrTails;
import actions.IsAction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler extends ListenerAdapter {

    static Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    final String KEYWORD1 = "!lonerbot";
    final String KEYWORD2 = "!llonerbot";
    final String KEYWORD3 = "!lb";
    final String KEYWORD4 = "!lbot";
    final String KEYWORD5 = "!lonarbot";
    final String KEYWORD6 = "!lonerbutt";
    final String KEYWORD7 = "!lonerboner";
    String lastUsedKeyword = "";


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //handy variables for saving
        String username;
        String channelName;
        String messageSent = event.getMessage().getContentRaw();

        //discord bot is now awake and decides how to respond
        if (messageContainsKeyword(messageSent)) {
            String response = formulateMessage(event, performInitialOperations(event, messageSent));
            sendMessage(event, response);
        }
    }

    private String formulateMessage(GuildMessageReceivedEvent event, String messageSent) {
        String formulatedMessage = "";

        switch (determineAction(messageSent)) {
            //Is
            case 1:
                IsAction isAction = new IsAction(messageSent);
                formulatedMessage = isAction.getResponse();
                break;
            //headsortails
            case 2:
                HeadsOrTails headsOrTails = new HeadsOrTails();
                formulatedMessage = headsOrTails.getResponse();
                break;
            //call
            case 3:
                CallSomeoneAName callSomeoneAName = new CallSomeoneAName(messageSent);
                formulatedMessage = callSomeoneAName.callSomeoneAName();
                break;
            //nf error
            case 4:
                break;
        }
        return formulatedMessage;
    }

    /**
     * This will determine which action to take. Gives back int based on code below:
     * <p>
     * 1. IS justin ugly? "justin IS/is NOT ugly"
     * 2. headsortails "Tails"
     * 3. Call Justin ugly "justin is ugly || "no ur ugly 25%"
     * 4. not found error
     */
    private int determineAction(String messageSent) {
        int rc = 4;
        String keywordUsed = "";

        //process//look for keywords
        //look into messageSent,
        //see if the message contains any of the keywords

        String[] actionKeywords = {"is", "headsortails", "call"};
        for (int i = 0; i < actionKeywords.length; i++) {
            if (messageSent.contains(actionKeywords[i])) {
                keywordUsed = actionKeywords[i];
                if ("is".equals(keywordUsed)) {
                    rc = 1;
                } else if ("headsortails".equals(keywordUsed)) {
                    rc = 2;
                } else if ("call".equals(keywordUsed)) {
                    rc = 3;
                } else {
                    rc = 4;
                }
            }
        }
        //if no keywords found - tell em to fuck off
        return rc;
    }

    /**
     * Cleanup before message is further processed
     * <p>
     * 1. remove keyword from the message "!lonerbot"
     * 2. convert message to lowercase
     * 3. saves some neat variables for us to use later.
     *
     * @param event
     */
    private String performInitialOperations(GuildMessageReceivedEvent event, String messageSent) {
        String username;
        TextChannel channel;


        messageSent = messageSent.replace(lastUsedKeyword, "");
        //todo: maybe check for punctuation after !lonerbot,
        messageSent = messageSent.toLowerCase();

        //we'll save some quick variables for easy use later like name, channel, etc
        channel = event.getChannel();
        try {
            username = event.getMember().getEffectiveName();
        } catch (NullPointerException nullException) {
            LOGGER.error(nullException.getMessage());
            LOGGER.error(nullException.getCause().toString());
            //todo: if error, maybe supplement with random insult name
            username = "bitch";
        }
        return messageSent;
    }

    //can we also make this remember the keyword that was used?
    public boolean messageContainsKeyword(String message) {
        String[] keywordArray = {KEYWORD1, KEYWORD2, KEYWORD3, KEYWORD4, KEYWORD5, KEYWORD6, KEYWORD7};
        for (int i = 0; i < keywordArray.length; i++) {
            if (message.toLowerCase().contains(keywordArray[i])) {
                //save the keyword to a local variable so we know what keyword to remove later
                lastUsedKeyword = keywordArray[i];
                return true;
            }
        }
        return false;
    }

    private void sendMessage(GuildMessageReceivedEvent event, String message) {
        event.getChannel().sendMessage(message).queue();
    }




}