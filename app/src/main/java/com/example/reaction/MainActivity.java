package com.example.reaction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    ImageView like = null;
    ImageView haha = null;
    ImageView wow = null;
    ImageView angry = null;
    ImageView love = null;
    ImageView sad = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        like = (ImageView)findViewById(R.id.like);
        haha = (ImageView)findViewById(R.id.haha);
        wow = (ImageView)findViewById(R.id.wow);
        love = (ImageView)findViewById(R.id.love);
        angry = (ImageView)findViewById(R.id.angry);
        sad = (ImageView)findViewById(R.id.sad);


        like.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volley("like");
            }
        });

        haha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               volley("haha");

            }
        });

        wow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volley("wow");

            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volley("love");

            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               volley("angry");

            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volley("sad");

            }
        });
    }

    public void volley(String reaction) {
        final TextView textView = (TextView) findViewById(R.id.text);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        System.out.println(queue);
        String url ="http://172.16.11.3:3000/reaction/" + reaction;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println(response);
                        textView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
