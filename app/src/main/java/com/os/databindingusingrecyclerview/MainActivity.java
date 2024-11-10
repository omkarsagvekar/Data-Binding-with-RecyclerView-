package com.os.databindingusingrecyclerview;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.os.databindingusingrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnDialogDismissListener {

    ActivityMainBinding binding;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        binding.rvForItem.setLayoutManager(new LinearLayoutManager(this));

        List<InfoModel> list = new ArrayList<>();
        list.add(new InfoModel("Nikki", "Seth", "42"));
        list.add(new InfoModel("Sherilyn", "Ford", "22"));
        list.add(new InfoModel("Piyush", "Mishra", "31"));
        list.add(new InfoModel("Brandon", "Lee", "32"));
        list.add(new InfoModel("kaylie", "Josef", "18"));
        list.add(new InfoModel("Ben", "Tenison", "52"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MainActivity.this, list, this::onDialogDismissed);
        binding.rvForItem.setAdapter(recyclerAdapter);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    @Override
    public void onDialogDismissed(String name, String sirName, String age) {
        Log.d("ParentFragment", "Dialog was dismissed and fragment was notified");
        //Toast.makeText(this, name +"\n"+sirName+"\n"+age, Toast.LENGTH_SHORT).show();
        Snackbar.make(view, name +"  "+sirName+"  "+age, Snackbar.LENGTH_SHORT).show();
    }
}