package listeners;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class HelloEvent extends ListenerAdapter {

    static Logger LOGGER = LoggerFactory.getLogger(HelloEvent.class);

    final String KEYWORD1 = "!lonerbot";
    final String KEYWORD2 = "!llonerbot";
    final String KEYWORD3 = "!lb";
    final String KEYWORD4 = "!lbot";
    final String KEYWORD5 = "!lonarbot";
    final String KEYWORD6 = "!lonabutt";
    final String KEYWORD7 = "!lonerboner";

    String lastUsedKeyword = "";


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //handy variables for saving
        String username;
        String channelName;


        String messageSent = event.getMessage().getContentRaw();

        //discord bot is now awake and decides how to respond
        if (messageContainsKeyword(messageSent)) {
            //initial touches
            messageSent = messageInitialTouches(event, messageSent);


            //analyze
            //What is being asked?
            //Based on input, what should I respond with?
            //am I x, is x v,

            //process
            String message = processMessage();

            //output
            sendMessage(event, message);
        }
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
    private String messageInitialTouches(GuildMessageReceivedEvent event, String messageSent) {
        String username;
        TextChannel channel;
        //initial touches
        removeKeywordFromMessage(messageSent);
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

    private void removeKeywordFromMessage(String message) {
        message = message.replace(lastUsedKeyword, "");
    }

    private String processMessage() {
        return "yes";
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

    //todo
    private void sendMessage(GuildMessageReceivedEvent event, String message) {
        event.getChannel().sendMessage(message);
    }

    private String whosRetarded(String message) {
        String name = "they're";
        //find char position of "is"
        int charPosofIs = message.indexOf("is");
        int startingCharPosOfName = charPosofIs + 3;
        //go until space
        boolean haventEncounteredSpace = true;

        int indexChar = startingCharPosOfName;
        StringBuilder collectedLetters = new StringBuilder();
        while (haventEncounteredSpace) {
            //check to see if the integer is a " " or not.
            if (message.charAt(indexChar) == ' ') {
                haventEncounteredSpace = false;
                name = collectedLetters.toString();
            } else {
                collectedLetters.append(message.charAt(indexChar));
                indexChar++;
            }
        }
        return name;
    }

    private String whatIsTheAdjective(String message, String person) {
        StringBuilder stringBuilder = new StringBuilder();
        String finalName;
        int index = message.indexOf(person);
        int adjectiveIndex = index + person.length() + 1;
        boolean active = true;

        int indexChar = adjectiveIndex;

        StringBuilder collectedLetters = new StringBuilder();
        try {
            while (active) {
                //check to see if the integer is a " " or not.
                if (indexChar == ' ') {
                    active = false;
                    finalName = collectedLetters.toString();
                } else {
                    collectedLetters.append(message.charAt(indexChar));
                    indexChar++;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            return collectedLetters.toString();
        }
        return stringBuilder.toString();
    }

    private String isOrIsNot() {
        String isOrIsNot = "";
        Random random = new Random();
        if (random.nextBoolean()) {
            isOrIsNot = "IS";
        } else {
            isOrIsNot = "is NOT";
        }
        return isOrIsNot;
    }

    private String headsOrTails() {
        Random random = new Random();
        String headsOrTails = "idk";

        if (random.nextBoolean()) {
            headsOrTails = "heads bitch";
        } else {
            headsOrTails = "tails loser";
        }
        return headsOrTails;
    }

    private boolean fiftyfifty() {
        Random random = new Random();
        return random.nextBoolean();
    }
}