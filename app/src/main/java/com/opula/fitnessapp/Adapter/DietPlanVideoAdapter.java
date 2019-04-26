package com.opula.fitnessapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.opula.fitnessapp.POJOClasses.FitnessVideoListModel.Info;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DietPlanVideoAdapter extends RecyclerView.Adapter<DietPlanVideoAdapter.ViewHolder> {


    Context context;
    LayoutInflater inflater;
    List<Info> data ;

    MediaController mediaControls;


    public DietPlanVideoAdapter(Context context, List<Info> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int positon) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.diet_planlist2, viewGroup, false);
        return new ViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.desc.setText(data.get(position).getName());

        Picasso.with(context)
                .load(data.get(position).getThumbnailImage())
                .into(viewHolder.video);

        viewHolder.linearLayoutDietPlanVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_show_video_player, null);
                alertDialogBuilder.setView(dialogView);
                alertDialogBuilder.setCancelable(true);

                // initialize the VideoView
                final VideoView mVideoView = (VideoView) dialogView.findViewById(R.id.videoView);
                final ImageView imageViewBackButton = dialogView.findViewById(R.id.imageViewBackButton);
                //         final LinearLayout relativeLayoutVideoPlayerMain=dialogView.findViewById(R.id.linearLayoutVideoPlayerMain);
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                imageViewBackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                //
//                    relativeLayoutVideoPlayerMain.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Blurry.with(mContext)
//                                    .radius(25)
//                                    .sampling(2)
//                                    .animate(500)
//                                    .onto(relativeLayoutVideoPlayerMain);
//                        }
//                    });

                mVideoView.setVideoURI(Uri.parse(data.get(position).getVideo()));
                mVideoView.start();
                mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaControls = new MediaController(context) {
                            @Override
                            public void hide() {
                                this.show();
                            }
                        };
                        mVideoView.start();
                        mVideoView.setMediaController(mediaControls);

                        /*mV

                         * and set its position on screen
                         */

                        mediaControls.setAnchorView(mVideoView);
                        ((ViewGroup) mediaControls.getParent()).removeView(mediaControls);

                        ((FrameLayout) dialogView.findViewById(R.id.videoViewWrapper))
                                .addView(mediaControls);
                        mediaControls.setVisibility(View.VISIBLE);

                        if (position == 0) {
                            mVideoView.start();

                        } else {
                            // if we come from a resumed activity, video playback will
                            // be paused
                            mVideoView.pause();
                        }
                    }

                });
            }});

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView video;
        TextView desc;
        LinearLayout linearLayoutDietPlanVideo;

        public ViewHolder( View itemView) {

            super(itemView);

            desc = (TextView)itemView.findViewById(R.id.desc);

            video = (ImageView)itemView.findViewById(R.id.video);
            linearLayoutDietPlanVideo=itemView.findViewById(R.id.linearLayoutDietPlanVideo);
        }
    }

}
