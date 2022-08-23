package com.example.umairfyp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.MatchDetailActivity;
import com.example.umairfyp.MatchSummaryActivity;
import com.example.umairfyp.PlayersListActivity;
import com.example.umairfyp.R;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Data;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    //variables

    Model_Batsman score_model;


    //List<Data> from model class to get the data
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

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_match, viewGroup , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //this will bind the data to view holder from where it'll be shown in other groups
        Data model= modelList.get(position);

        match_id = model.getId();
        holder.team1tv.setText(model.getTeams().get(0));
        holder.team2tv.setText(model.getTeams().get(1));

        if(model.getTeams().get(0).contains("Pakistan") || model.getTeams().get(1).contains("Pakistan"))
            holder.mainLayout.setBackgroundColor(Color.GREEN);

        holder.matchtypetv.setText(model.getMatchType());
        holder.matchstatustv.setText(model.getStatus());
        holder.datetv.setText(model.getDate());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Show dialog on click with options of "Match Details" and "PLayers Details"

                String match_id = model.getId();
                String  date= model.getDate();

                //options to Display in dialog
                String[] options= {"Match Details","Squads","Match Summary"};

                //Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
            //    builder.setTitle("Choose Option");//Title

                //set options to dialog box
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int inning_size=model.getScore().size();

                        if (which ==0){
                            //Match details is clicked
                            Intent intent = new Intent(context, MatchDetailActivity.class);
                            intent.putExtra("match_id",match_id);

                            intent.putExtra("date",date);
                            intent.putExtra("Team1",model.getTeams().get(0));
                            intent.putExtra("Team2",model.getTeams().get(1));
                            intent.putExtra("MatchStatus",model.getStatus());
                            intent.putExtra("innings_size",model.getScore().size());


                            if(inning_size >0) {
                                intent.putExtra("Score1", model.getScore().get(0).getR().toString());
                                intent.putExtra("Wickets1", model.getScore().get(0).getW().toString());
                                intent.putExtra("Overs1", model.getScore().get(0).getO().toString());
                            }



                            if( inning_size >1 ) {
                                intent.putExtra("Score2", model.getScore().get(1).getR().toString());
                                intent.putExtra("Wickets2", model.getScore().get(1).getW().toString());
                                intent.putExtra("Overs2", model.getScore().get(1).getO().toString());
                            }


                            if(inning_size >2) {
                                intent.putExtra("Score3", model.getScore().get(2).getR().toString());
                                intent.putExtra("Wickets3", model.getScore().get(2).getW().toString());
                                intent.putExtra("Overs3", model.getScore().get(2).getO().toString());
                            }



                            if( inning_size >3 ) {
                                intent.putExtra("Score4", model.getScore().get(3).getR().toString());
                                intent.putExtra("Wickets4", model.getScore().get(3).getW().toString());
                                intent.putExtra("Overs4", model.getScore().get(3).getO().toString());
                            }

                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);


                        }

                        if (which ==1){
                            //Players list is clicked

                            Intent intent = new Intent(context, PlayersListActivity.class);
                            intent.putExtra("match_id",match_id);
                            intent.putExtra("Team1",model.getTeams().get(0));
                            intent.putExtra("Team2",model.getTeams().get(1));


                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                        if (which ==2){
                            //MatchSummary is clicked

                            Intent intent = new Intent(context, MatchSummaryActivity.class);
                            intent.putExtra("match_id",match_id);

                            if(inning_size >0) {
                                intent.putExtra("Score1", model.getScore().get(0).getR().toString());
                                intent.putExtra("Wickets1", model.getScore().get(0).getW().toString());
                                intent.putExtra("Overs1", model.getScore().get(0).getO().toString());
                            }



                            if( inning_size >1 ) {
                                intent.putExtra("Score2", model.getScore().get(1).getR().toString());
                                intent.putExtra("Wickets2", model.getScore().get(1).getW().toString());
                                intent.putExtra("Overs2", model.getScore().get(1).getO().toString());
                            }


                            if(inning_size >2) {
                                intent.putExtra("Score3", model.getScore().get(2).getR().toString());
                                intent.putExtra("Wickets3", model.getScore().get(2).getW().toString());
                                intent.putExtra("Overs3", model.getScore().get(2).getO().toString());
                            }



                            if( inning_size >3 ) {
                                intent.putExtra("Score4", model.getScore().get(3).getR().toString());
                                intent.putExtra("Wickets4", model.getScore().get(3).getW().toString());
                                intent.putExtra("Overs4", model.getScore().get(3).getO().toString());
                            }

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

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //define view objects

        TextView team1tv, team2tv, matchtypetv, matchstatustv, datetv,teamscore1,teamscore2;
        CardView cardView;
        TableLayout mainLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            team1tv = itemView.findViewById(R.id.team1tv);
            teamscore1 = itemView.findViewById(R.id.score1Tv);
            team2tv =itemView.findViewById(R.id.team2tv);
            teamscore2 = itemView.findViewById(R.id.score2Tv);
            matchtypetv =itemView.findViewById(R.id.matchtypetv);
            matchstatustv =itemView.findViewById(R.id.matchstatustv);
            datetv =itemView.findViewById(R.id.datetv);
            cardView =itemView.findViewById(R.id.cardview);
            mainLayout = itemView.findViewById(R.id.tl_main_layout);

        }
    }

}
