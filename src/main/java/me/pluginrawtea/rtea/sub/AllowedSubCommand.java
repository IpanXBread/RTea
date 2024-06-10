package me.pluginrawtea.rtea.sub;
import java.util.List;

public class AllowedSubCommand {
    private List<String> arguments;
    private String playerName;

    public AllowedSubCommand(List<String> arguments, String playerName) {
        this.arguments = arguments;
        this.playerName = playerName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public String getPlayerName() {
        return playerName;
    }
}