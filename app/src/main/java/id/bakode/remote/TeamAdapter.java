package id.bakode.remote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by A. A. Sumitro on 6/21/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
public class TeamAdapter extends
        RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

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
        Picasso.get()
                .load(mTeams.get(position).getLogoUrl())
                .placeholder(R.drawable.ic_cloud_download_gray_24dp)
                .error(R.drawable.ic_broken_image_gray_24dp)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.mTeamLogo);
        holder.mTeamName.setText(mTeams.get(position).getName());
        holder.mTeamContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTeamClicked(mTeams.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mTeams != null) ? mTeams.size() : 0;
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {
        private CardView mTeamContainer;
        private ImageView mTeamLogo;
        private TextView mTeamName;
        TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            mTeamContainer = itemView.findViewById(R.id.item_team_container);
            mTeamLogo = itemView.findViewById(R.id.item_team_logo);
            mTeamName = itemView.findViewById(R.id.item_team_name);
        }
    }

    interface TeamListener {
        void onTeamClicked(Team team);
    }
}
