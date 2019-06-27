package id.bakode.remote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TEAM = "extra_team";

    private Team mTeam;
    private ImageView mTeamLogo;
    private TextView mTeamName, mTeamRating, mTeamLoses, mTeamWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        mTeam = getIntent().getParcelableExtra(EXTRA_TEAM);
        initView();
        setData(mTeam);
    }

    public void initView() {
        mTeamLogo = findViewById(R.id.team_logo);
        mTeamName = findViewById(R.id.team_name);
        mTeamRating = findViewById(R.id.team_rating);
        mTeamLoses = findViewById(R.id.team_loses);
        mTeamWins = findViewById(R.id.team_wins);
    }

    public void setData(Team team) {
        Picasso.get()
                .load(mTeam.getLogoUrl())
                .placeholder(R.drawable.ic_cloud_download_gray_24dp)
                .error(R.drawable.ic_broken_image_gray_24dp)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(mTeamLogo);
        mTeamName.setText(team.getName());
        mTeamRating.setText(String.valueOf(team.getRating()));
        mTeamWins.setText(String.valueOf(team.getWins()));
        mTeamLoses.setText(String.valueOf(team.getLosses()));
    }

}
