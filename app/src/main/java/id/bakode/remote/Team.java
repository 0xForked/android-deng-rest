package id.bakode.remote;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by A. A. Sumitro on 6/21/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
public class Team implements Parcelable {

    private long team_id;
    private float rating;
    private int wins;
    private int losses;
    private long last_match_time;
    private String name;
    private String tag;
    private String logo_url;

    public long getTeamId() {
        return team_id;
    }

    public void setTeamId(long team_id) {
        this.team_id = team_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public long getLastMatchTime() {
        return last_match_time;
    }

    public void setLastMatchTime(long last_match_time) {
        this.last_match_time = last_match_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLogoUrl() {
        return logo_url;
    }

    public void setLogoUrl(String logo_url) {
        this.logo_url = logo_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.team_id);
        dest.writeFloat(this.rating);
        dest.writeInt(this.wins);
        dest.writeInt(this.losses);
        dest.writeLong(this.last_match_time);
        dest.writeString(this.name);
        dest.writeString(this.tag);
        dest.writeString(this.logo_url);
    }

    public Team() {
    }

    protected Team(Parcel in) {
        this.team_id = in.readLong();
        this.rating = in.readFloat();
        this.wins = in.readInt();
        this.losses = in.readInt();
        this.last_match_time = in.readLong();
        this.name = in.readString();
        this.tag = in.readString();
        this.logo_url = in.readString();
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
