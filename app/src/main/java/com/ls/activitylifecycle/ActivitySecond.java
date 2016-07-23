package com.ls.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lsx on 2016/7/22.
 */
public class ActivitySecond extends AppCompatActivity {
    private TextView mtextView;
    private Button mSendbackButton;
    private EditText mNameEditText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        String inforContent = getIntent().getStringExtra(MainActivity.Book_NAME_OF_CATEGORY_PHYSICAL);
        //Toast.makeText(ActivitySecond.this, inforContent, Toast.LENGTH_SHORT).show();
        mtextView = (TextView) findViewById(R.id.second_activity_text_view);
        mtextView.setText(inforContent);
        mNameEditText = (EditText) findViewById(R.id.second_activity_edit_text);
        mSendbackButton = (Button) findViewById(R.id.second_activity_button);

        mSendbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("back", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}