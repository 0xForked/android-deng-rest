package id.bakode.remote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static id.bakode.remote.DetailActivity.EXTRA_TEAM;

public class MainActivity extends
        AppCompatActivity implements TeamAdapter.TeamListener {

    private ApiClient mApiClient;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressbar;
    private ConstraintLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApiClient = new ApiClient();
        initView();
        getData();
    }

    private void initView() {
        mContainer = findViewById(R.id.main_container);
        mRecyclerView = findViewById(R.id.recycler_view_team);
        mProgressbar = findViewById(R.id.progress_dialog);
    }


    private void getData() {
        mProgressbar.setVisibility(View.VISIBLE);
        mApiClient
                .ApiServices()
                .getData()
                .enqueue(new Callback<List<Team>>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<List<Team>> call,
                            @NonNull Response<List<Team>> response
                    ) {
                        List<Team> mTeams = response.body();
                        initRecyclerView(mTeams);
                        mProgressbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<List<Team>> call,
                            @NonNull Throwable t
                    ) {
                        t.printStackTrace();
                        Log.e(MainActivity.class.getSimpleName(), "Error: "+t.getMessage());
                        mProgressbar.setVisibility(View.GONE);
                    }
                });
    }

    private void initRecyclerView(List<Team> teams) {
        TeamAdapter mAdapter = new TeamAdapter(teams, this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTeamClicked(Team team) {
        Intent mDetail = new Intent(MainActivity.this, DetailActivity.class);
        mDetail.putExtra(EXTRA_TEAM, team);
        startActivity(mDetail);
        Toast.makeText(this, "clicked: "+team.getName(), Toast.LENGTH_LONG).show();
    }

}
