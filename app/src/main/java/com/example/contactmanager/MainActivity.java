package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Contact Nina = new Contact();
        Nina.setName("Nina");
        Nina.setPhoneNumber("123456789");

        db.addContact(Nina);

        Contact kevina = new Contact();
        kevina.setName("kevina");
        kevina.setPhoneNumber("678");

        db.addContact(kevina);

        List<Contact> contacts = db.getAllContacts();

        //get 1 contact

//        Contact c = db.getContact(kevina.getId());
//        c.setName("Kevina Vuong");
//        c.setPhoneNumber("911");
//
//        int updateRow = db.updateContact(c);

        //db.deleteContact(c);

        //Log.d("Contact", "onCreate: " + updateRow);

        for (Contact contact : contacts) {
            Log.d("Contact", "onCreate: " + contact.getName());
        }
        Log.d("Contact", "number of contacts: " + db.getCount());

    }
}
