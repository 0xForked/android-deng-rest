package id.bakode.remote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by A. A. Sumitro on 6/21/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
public class TeamAdapter extends
        RecyclerView.Adapter<TeamViewHolder> {

    private List<Team> mTeams;
    private TeamListener mListener;

    TeamAdapter(
            List<Team> team,
            TeamListener listener
    ) {
        this.mTeams = team;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(
                R.layout.item_team,
                parent,
                false
        );
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull TeamViewHolder holder,
            final int position
    ) {
        holder.onBind(mTeams.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return (mTeams != null) ? mTeams.size() : 0;
    }

}
