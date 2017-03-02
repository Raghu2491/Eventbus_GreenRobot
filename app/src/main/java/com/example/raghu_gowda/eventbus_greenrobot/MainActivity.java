package com.example.raghu_gowda.eventbus_greenrobot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    CustomMessageEvent customMessageEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        button=(Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.text);

        customMessageEvent=new CustomMessageEvent();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });

    }
    @Subscribe
    public void onEvent(CustomMessageEvent event){
        editText.setText(event.getCustomMessage());
    }
}
