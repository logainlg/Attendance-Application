package com.project.sairam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>{

    private List<Model> listItems;
    private Context context;
    private ProgressDialog dialog;


    public MyAdapter1(List<Model> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView uid;
        public TextView name;
        public TextView address;
        public TextView phone;
        public CardView card_view;
        public ViewHolder(View itemView ) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            uid = (TextView) itemView.findViewById(R.id.uid);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            phone = (TextView) itemView.findViewById(R.id.phone);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Model listItem = listItems.get(position);
        holder.id.setText(listItem.getId());
        holder.uid.setText(listItem.getUId());
        holder.name.setText(listItem.getName());
        holder.address.setText(listItem.getAddress());
        holder.phone.setText(listItem.getPhone());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                final ProgressDialog dialog = new ProgressDialog(view.getContext());
                dialog.setMessage("Loading Delete Data");
                final CharSequence[] dialogitem = {"View Class Information","Edit Class Information"};

                builder.setTitle(listItem.getUId());
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                               Intent intent = new Intent(view.getContext(), DetailDataClass.class);
                                //Intent intent = new Intent(view.getContext(), EditActivity.class);

                                intent.putExtra("id", listItem.getId());
                                intent.putExtra("uid", listItem.getUId());
                                intent.putExtra("name", listItem.getName());
                                intent.putExtra("address", listItem.getAddress());
                                intent.putExtra("phone", listItem.getPhone());
                                view.getContext().startActivity(intent);
                                break;
                            case 1:

                                Intent intent2 = new Intent(view.getContext(), EditActivityClass.class);
                                intent2.putExtra("id", listItem.getId());
                                intent2.putExtra("uid", listItem.getUId());
                                intent2.putExtra("name", listItem.getName());
                                intent2.putExtra("address", listItem.getAddress());
                                intent2.putExtra("phone", listItem.getPhone());
                                view.getContext().startActivity(intent2);
                                break;

                        }}
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