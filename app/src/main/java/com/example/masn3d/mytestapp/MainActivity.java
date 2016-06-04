package com.example.masn3d.mytestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button myTestButton;
    private TextView myTestText;
    private RequestQueue requestQueue;
    private String jsonURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTestButton = (Button) findViewById(R.id.testButton);
        myTestText = (TextView) findViewById(R.id.testText);
        requestQueue = Volley.newRequestQueue(this);
        //jsonURL = "http://mysafeinfo.com/api/data?list=englishmonarchs&format=json"; //Sample test JSON file.
        jsonURL = "http://0983e120.ngrok.io/posts"; //Sample test JSON file.

        myTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonArrayRequest jsonArrayRequest = ServerFacade.getAllPosts(requestQueue,"http://af74c625.ngrok.io/posts");
                requestQueue.add(jsonArrayRequest);
            }
        });
    }
}
