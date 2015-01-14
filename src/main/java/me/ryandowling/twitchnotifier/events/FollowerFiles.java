package me.ryandowling.twitchnotifier.events;

import me.ryandowling.twitchnotifier.App;
import me.ryandowling.twitchnotifier.data.interfaces.Follower;
import me.ryandowling.twitchnotifier.events.listeners.FollowerListener;
import me.ryandowling.twitchnotifier.events.managers.FollowerManager;
import me.ryandowling.twitchnotifier.utils.Utils;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class FollowerFiles implements FollowerListener {
    public FollowerFiles() {
        FollowerManager.addListener(this);
    }

    @Override
    public void onNewFollow(final Follower follower) {
        writeFiles();
    }

    public void writeFiles() {
        try {
            Follower latestFollower = App.NOTIFIER.getFollowers().entrySet().iterator().next().getValue();

            FileUtils.write(Utils.getLatestFollowerFile().toFile(), latestFollower.getDisplayName());
            FileUtils.write(Utils.getNumberOfFollowersFile().toFile(), "" + App.NOTIFIER.getFollowersTotal());
            FileUtils.write(Utils.getFollowersTallyFile().toFile(), "" + App.NOTIFIER.getFollowersTally());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
