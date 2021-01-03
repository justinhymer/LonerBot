package actions;

import java.util.Random;

public class CallSomeoneAName {
    String message;

    public CallSomeoneAName(String updatedMessage) {
        this.message = updatedMessage;
    }

    //"call justin gay"
    //todo: account for tags coming in "@"
    public String callSomeoneAName() {
        String defaultResponse = "nah";
        String response = defaultResponse;

        StringBuilder stringBuilder = new StringBuilder();

        //get name
        String name = whosName(message);
        //IS or IS not
        String ur = "ur";
        //adjective
        String adjective = whatIsTheAdjective(message, whosName(message));

        /// 75/24 if it actually goes through or not. might turn back on them
        if (fiftyfifty()) {
            if (fiftyfifty()) {
                //generate alternate response
                //"no ur ADJECTIVE"
            }
        }

        //put those all together in a nice string
        stringBuilder.append(name);
        stringBuilder.append(" ");
        stringBuilder.append(ur);
        stringBuilder.append(" ");
        stringBuilder.append(adjective);
        //return
        return stringBuilder.toString();
    }

    private String whatIsTheAdjective(String message, String personsName) {
        StringBuilder stringBuilder = new StringBuilder();
        String finalName;

        int charIndexOfName = message.indexOf(personsName);
        //this gets us to the index of the adjective
        int adjectiveIndex = charIndexOfName + personsName.length() + 1;

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

    private String whosName(String message) {
        String name = "they're";
        //find char position of "is"
        int charPosofIs = message.indexOf("call");
        int startingCharPosOfName = charPosofIs + 5;
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
