package com.example.umairfyp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.model.Data;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    //variables

    private List<Data> modelList;
    private Context context;
    String match_id;
    //constructor


    public Adapter(List<Data> modelList, Context context) {

        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int position) {

        //this method will be called whenever our view holder will be created
        //inflate the layout row.xml

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_match, viewGroup , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //this will bind the data to view holder from where it'll be shown in other groups
        Data model= modelList.get(position);
        match_id = model.getId();
        holder.team1tv.setText(model.getTeams().get(0));
        holder.teamscore1.setText(model.getScore().get(0).getInning());
        holder.team2tv.setText(model.getTeams().get(1));
        holder.teamscore2.setText(model.getScore().get(1).getInning());

        if(model.getTeams().get(0).contains("Pakistan") || model.getTeams().get(1).contains("Pakistan"))
            holder.mainLayout.setBackgroundColor(Color.GREEN);
        holder.matchtypetv.setText(model.getMatchType());
        holder.matchstatustv.setText(model.getStatus());
        holder.datetv.setText(model.getDate());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Show dialog on click with options of "Match Details" and "PLayers Details"

                String matchid = model.getId();
                String  date= model.getDate();

                //options to Display in dialog
                String[] options= {"Match Details","Players List","Match Summary"};

                //Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                builder.setTitle("Choose Option");//Title

                //set options to dialog box
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which ==0){
                            //Match details is clicked
                            Intent intent = new Intent(context, MatchDetailActivity.class);
                            intent.putExtra("match_id",match_id);
                            intent.putExtra("date",date);
                            intent.putExtra("Team1",model.getTeams().get(0));
                            intent.putExtra("Score1", model.getScore().get(0).getO());
                            intent.putExtra("Team2",model.getTeams().get(1));
                            intent.putExtra("Score2", model.getScore().get(1).getR());
                            intent.putExtra("MatchStatus",model.getStatus());



                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);


                        }

                        if (which ==1){
                            //Players list is clicked

                            Intent intent = new Intent(context, PlayersActivity.class);
                            intent.putExtra("match_id",matchid);

                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                        if (which ==2){
                            //MatchSummary is clicked

                            Intent intent = new Intent(context, MatchSummaryActivity.class);
                            intent.putExtra("match_id",matchid);
                            //intent.putExtra("")

                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                    }
                });
                builder.create().show();


            }
        });

    }

    @Override
    public int getItemCount() {

        return modelList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //define view objects

        TextView team1tv, team2tv, matchtypetv, matchstatustv, datetv,teamscore1,teamscore2;
        CardView cardView;
        TableLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            team1tv = itemView.findViewById(R.id.team1tv);
            teamscore1 = itemView.findViewById(R.id.TeamScore1tv);
            team2tv =itemView.findViewById(R.id.team2tv);
            teamscore2 = itemView.findViewById(R.id.TeamScore2tv);
            matchtypetv =itemView.findViewById(R.id.matchtypetv);
            matchstatustv =itemView.findViewById(R.id.matchstatustv);
            datetv =itemView.findViewById(R.id.datetv);
            cardView =itemView.findViewById(R.id.cardview);
            mainLayout = itemView.findViewById(R.id.tl_main_layout);

        }
    }

}
