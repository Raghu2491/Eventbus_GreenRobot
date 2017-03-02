package com.example.raghu_gowda.eventbus_greenrobot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main2Activity extends AppCompatActivity {

    private EditText _editText;
    private Button _button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        _editText=(EditText) findViewById(R.id.text2);
        _button=(Button) findViewById(R.id.button2);


        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _event=_editText.getText().toString();

                CustomMessageEvent customMessageEvent=new CustomMessageEvent();
                customMessageEvent.setCustomMessage(_event);
                EventBus.getDefault().post(customMessageEvent);
                finish();
            }
        });


    }

}
