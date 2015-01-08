package me.ryandowling.twitchnotifier.data.twitch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TwitchUser {
    private long _id;
    private String name;
    private String created_at;
    private String updated_at;

    private long created_at_timestamp;
    private long updated_at_timestamp;

    private String display_name;
    private String type;

    public long getID() {
        return this._id;
    }

    public String getName() {
        return this.name;
    }

    public String getCreatedAt() {
        return this.created_at;
    }

    public String getUpdatedAt() {
        return this.updated_at;
    }

    public long getCreatedAtTimestamp() {
        return this.created_at_timestamp;
    }

    public long getUpdatedAtTimestamp() {
        return this.updated_at_timestamp;
    }

    public String getDisplayName() {
        return this.display_name;
    }

    public String getType() {
        return this.type;
    }

    public void addTimestamps() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date;

        try {
            date = df.parse(this.created_at);
            this.created_at_timestamp = date.getTime();

            date = df.parse(this.updated_at);
            this.updated_at_timestamp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
