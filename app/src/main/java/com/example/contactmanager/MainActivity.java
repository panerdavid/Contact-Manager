package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactmanager.adaptor.RecyclerViewAdaptor;
import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contactArrayList;
    private RecyclerView recyclerView;
    private RecyclerViewAdaptor arrayAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactArrayList = new ArrayList<>();

        DatabaseHandler db = new DatabaseHandler(this);

        List<Contact> contactList = db.getAllContacts();
        contactArrayList.addAll(contactList);

        //set up recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set up adapter
        arrayAdaptor = new RecyclerViewAdaptor(this, contactArrayList);

        recyclerView.setAdapter(arrayAdaptor);


//        Contact a = new Contact("Greg", "91645");
//        db.addContact(a);
//
//        db.addContact(new Contact("a","1"));
//        db.addContact(new Contact("b","2"));
//        db.addContact(new Contact("c","3"));
//        db.addContact(new Contact("d","4"));
//
//        db.addContact(new Contact("e","5"));
//        db.addContact(new Contact("f","6"));
//        db.addContact(new Contact("g","8"));
//        db.addContact(new Contact("h","7"));
//        db.addContact(new Contact("j","0"));
//        db.addContact(new Contact("c","10"));
//
//        Contact Nina = new Contact();
//        Nina.setName("Nina");
//        Nina.setPhoneNumber("123456789");
//
//        db.addContact(Nina);
//
//        Contact kevina = new Contact();
//        kevina.setName("kevina");
//        kevina.setPhoneNumber("678");
//
//        db.addContact(kevina);
//
        List<Contact> contacts = db.getAllContacts();

        //get 1 contact

//        Contact c = db.getContact(kevina.getId());
//        c.setName("Kevina Vuong");
//        c.setPhoneNumber("911");
//
//        int updateRow = db.updateContact(c);

        //db.deleteContact(c);

        //Log.d("Contact", "onCreate: " + updateRow);


    }
}
