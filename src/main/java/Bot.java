import listeners.EventHandler;
import listeners.NewbieJoinsEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        String token = "Nzk0NzI0MDg0NjA0NDY5MjU4.X---ew.xbXU9SXNkw5IYONTl9XMfX7yxs4";
        JDA jda = JDABuilder.createDefault(token).build();

        jda.addEventListener(new EventHandler(), new NewbieJoinsEvent());
    }
}
