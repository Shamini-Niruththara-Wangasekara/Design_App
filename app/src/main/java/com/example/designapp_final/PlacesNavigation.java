package com.example.designapp_final;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.designapp_final.databinding.ActivityPlacesNavigationBinding;

public class PlacesNavigation extends DrawerBaseActivity {
    private Button move;
    private ActivityPlacesNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlacesNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Navigate Location");

        EditText editTextSource = findViewById(R.id.sourceNav);
        EditText editTextDestination = findViewById(R.id.destinationNav);
        Button button = findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = editTextSource.getText().toString();
                String destination = editTextDestination.getText().toString();
                if (source.equals("") && destination.equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Enter both source and destination",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/"
                            +source +"/" +destination);
                    Intent intent =new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}