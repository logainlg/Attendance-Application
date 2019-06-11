package com.project.sairam;



import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adap extends RecyclerView.Adapter<adap.ViewHolder> {

    private List<Model1> listItems;
    private Context context;
    private ProgressDialog dialog;


    public adap(List<Model1> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView profilename;
        public TextView time;
        public TextView imagepath;
        public CardView card_view;
        public ViewHolder(View itemView ) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            profilename = (TextView) itemView.findViewById(R.id.name1);
            time = (TextView) itemView.findViewById(R.id.time1);
            imagepath = (TextView) itemView.findViewById(R.id.photo1);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout1, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Model1 listItem = listItems.get(position);
        holder.id.setText(listItem.getId());

        holder.profilename.setText(listItem.getProfileName());
        holder.time.setText(listItem.getTime());
        holder.imagepath.setText(listItem.getImagePath());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                final ProgressDialog dialog = new ProgressDialog(view.getContext());
                dialog.setMessage("Loading Delete Data");
                final CharSequence[] dialogitem = {"Edit Data"};
                builder.setTitle(listItem.getProfileName());
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){

                            case 0 :

                                Intent intent = new Intent(view.getContext(), Edit.class);
                                intent.putExtra("id", listItem.getId());
                                intent.putExtra("name",listItem.getProfileName());
                                intent.putExtra("time",listItem.getTime());
                                intent.putExtra("photo", listItem.getImagePath());
                                view.getContext().startActivity(intent);
                                break;

                        }
                    }
                });

                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}