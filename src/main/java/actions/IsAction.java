package actions;

import java.util.Random;

/**
 * IsAction does the following
 * "is Justin gay?" - input
 * "Yeah, justin is gay" - output
 */
public class IsAction {
    String message;

    //CONSTRUCTOR
    public IsAction(String message) {
        this.message = message;
    }

    public String getResponse() {
        String defaultResponse = "";
        String response = defaultResponse;

        StringBuilder stringBuilder = new StringBuilder();

        //get name
        String name = whosRetarded(message);
        //IS or IS not
        String isOrIsNot = isOrIsNot();
        //adjective
        String adjective = whatIsTheAdjective(message, whosRetarded(message));

        //put those all together in a nice string
        stringBuilder.append(name);
        stringBuilder.append(" ");
        stringBuilder.append(isOrIsNot);
        stringBuilder.append(" ");
        stringBuilder.append(adjective);
        //return
        return stringBuilder.toString();
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

    private String isOrIsNot() {
        String isOrIsNot = null;

        if (fiftyfifty()) {
            isOrIsNot = "IS";
        } else {
            isOrIsNot = "is NOT";
        }
        return isOrIsNot;
    }

    private boolean fiftyfifty() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
