package listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class HelloEvent extends ListenerAdapter {
    final String KEYWORD1 = "!lonerbot";
    final String KEYWORD2 = "!llonerbot";
    final String KEYWORD3 = "!lb";
    final String KEYWORD4 = "!lbot";
    final String KEYWORD5 = "!lonarbot";
    final String KEYWORD6 = "!lonabutt";
    final String KEYWORD7 = "!lonerboner";


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        if (messageContainsKeyword(messageSent)) {
            //analyze

            //process

            //output
            sendMessage(event);
        }
        //otherwise ignore it
        else {
            //do nothing
        }
    }

    public boolean messageContainsKeyword(String message) {
        String[] keywordArray = {KEYWORD1, KEYWORD2, KEYWORD3, KEYWORD4, KEYWORD5, KEYWORD6, KEYWORD7};
        for (int i = 0; i < keywordArray.length; i++) {
            //check if message contains keyword
            if (message.toLowerCase().contains(keywordArray[i])) {
                return true;
            } else {
                // do nothing
            }
        }
        return false;
    }

    //todo
    private void sendMessage(GuildMessageReceivedEvent event) {

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


//            switch (user.toLowerCase()) {
//                case "dumb":
//                    event.getChannel().sendMessage("You're clearly autistic. don't talk to me anh.").queue();
//                    break;
//                case "j-hymz":
//                    event.getChannel().sendMessage("anh is retarded").queue();
//                    break;
//                case "probably josi":
//                    event.getChannel().sendMessage("I'm still a bit hesitant with asians. Wanna race for street cred?").queue();
//                    break;
//                case "jerrid":
//                    event.getChannel().sendMessage("ur dick is small jerrid").queue();
//                    break;
//                default:
//                    event.getChannel().sendMessage("shut the fuck up anh").queue();
//                    break;
//            }