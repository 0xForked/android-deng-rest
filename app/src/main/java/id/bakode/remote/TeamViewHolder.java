package id.bakode.remote;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by A. A. Sumitro on 6/27/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

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

    void onBind(Team team, TeamListener listener) {
        Picasso.get()
                .load(team.getLogoUrl())
                .placeholder(R.drawable.ic_cloud_download_gray_24dp)
                .error(R.drawable.ic_broken_image_gray_24dp)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(mTeamLogo);
        mTeamName.setText(team.getName());
        mTeamContainer.setOnClickListener(v -> listener.onTeamClicked(team));
    }

}
