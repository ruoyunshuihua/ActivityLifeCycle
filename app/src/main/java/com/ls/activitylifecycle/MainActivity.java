package com.ls.activitylifecycle;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private final String TAG= "MainActivity" ;
    private static final String TAG = "MainActivity";
    public static final String Book_NAME_OF_CATEGORY_PHYSICAL = "bookNameOfCategoryPhysical";
    private Button mButton;
    private EditText mEditText;
    private Button mThirdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        mButton = (Button) findViewById(R.id.activity_main_button);
        final EditText editText = (EditText) findViewById(R.id.activity_main_edit_text);
        //final String inforContent =editText.getText().toString();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
                //intent.putExtra("name", "xxxxxxxxxxxxxxx");
                intent.putExtra(Book_NAME_OF_CATEGORY_PHYSICAL, mEditText.getText().toString());
                //intent.putExtra("name", "xxxxxxxxxxxxxxx");
                //intent.putExtra("name",editText.getText().toString());
                startActivityForResult(intent, 1);
                //Toast.makeText(MainActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
            }


        });
        mThirdButton = (Button) findViewById(R.id.activity_main_third_button);
        mThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //String name = data.getStringExtra("back");
        String name = "";
        switch (requestCode) {
            case 0:
                name = data.getStringExtra("back");
                break;
            case 1:
                name = data.getStringExtra("backThird");
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
