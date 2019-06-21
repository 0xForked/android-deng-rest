package id.bakode.remote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TEAM = "extra_person";

    private Team mTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTeam = getIntent().getParcelableExtra(EXTRA_TEAM);
        setData();
    }

    public void initView() {}

    public void setData() {
        Log.d(DetailActivity.class.getSimpleName(), mTeam.getName());
    }
}
