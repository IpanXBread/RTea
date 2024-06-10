package me.pluginrawtea.rtea.sub;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class RaceTrack {
    private String trackName;
    private String creator;
    private List<String> checkpoints;
    private int totalCheckpoints;
    private double playerReward;
    private double creatorReward;
    private Map<UUID, Map<String, Boolean>> playerCommandStates;
    private Map<UUID, Integer> playerRaceSteps;

    public RaceTrack(String trackName, List<String> checkpoints, String creator, double playerReward, double creatorReward) {
        this.trackName = trackName;
        this.creator = creator;
        this.checkpoints = checkpoints;
        this.totalCheckpoints = checkpoints.size();
        this.playerReward = playerReward;
        this.creatorReward = creatorReward;
        this.playerCommandStates = new HashMap<>();
        this.playerRaceSteps = new HashMap<>();
    }

    public String getTrackName() {
        return trackName;
    }

    public List<String> getCheckpoints() {
        return checkpoints;
    }

    public int getTotalCheckpoints() {
        return totalCheckpoints;
    }

    public String getCreator() {
        return creator;
    }

    public double getPlayerReward() {
        return playerReward;
    }

    public double getCreatorReward() {
        return creatorReward;
    }

    public Map<UUID, Map<String, Boolean>> getPlayerCommandStates() {
        return playerCommandStates;
    }

    public Map<UUID, Integer> getPlayerRaceSteps() {
        return playerRaceSteps;
    }
}
