package com.example.contactmanager.adaptor;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanager.DetailsActivity;
import com.example.contactmanager.R;
import com.example.contactmanager.model.Contact;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {
    private Context context;
    private List<Contact> contactList;


    public RecyclerViewAdaptor(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //turn our contactrow.xml into an actual view for recyclerview
        View view = LayoutInflater.from(this.context).inflate(R.layout.contact_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.phoneNumber.setText(contact.getPhoneNumber());
        holder.contactName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
    //fill out our views
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView phoneNumber;
        public TextView contactName;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.number);
            iconButton = itemView.findViewById(R.id.icon_button);

            iconButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Contact contact = contactList.get(position);

            //context from MainAcivity.onStart()
            Intent intent =  new Intent(context, DetailsActivity.class);
            intent.putExtra("name", contact.getName());
            intent.putExtra("number", contact.getPhoneNumber());
            context.startActivity(intent);



            }
        }
    }

