package com.codepath.apps.mysimpletweets.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.models.User;

public class ComposeActivity extends ActionBarActivity {
    private EditText etNewTweet;
    private MenuItem miCounter;
    private Menu menu;
    private final int maxLength = 140;

    private TextView tvComposeScreenName;
    private TextView tvComposeUserName;
    private ImageView ivComposeUserIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        etNewTweet = (EditText) findViewById(R.id.etNewTweet);
        etNewTweet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int count = etNewTweet.getText().toString().length();
                //Toast.makeText(ComposeActivity.this, Integer.toString(count), Toast.LENGTH_SHORT).show();

                MenuItem mi = ComposeActivity.this.menu.findItem(R.id.miCounter);
                mi.setTitle(Integer.toString(maxLength - count));
            }
        });


        tvComposeScreenName = (TextView) findViewById(R.id.tvComposeScreenName);
        tvComposeUserName = (TextView) findViewById(R.id.tvComposeUserName);
        ivComposeUserIcon = (ImageView) findViewById(R.id.ivComposeProfileImage);

        User user = (User) getIntent().getSerializableExtra("user");
        /*
        tvComposeUserName.setText(user.getName());
        tvComposeScreenName.setText(user.getScreenName());

        Picasso.with(this).load(user.getProfileImageUrl()).into(ivComposeUserIcon);
        */
    }

    private void onTweet() {
        Intent data = new Intent();
        data.putExtra("tweet", etNewTweet.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compose, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_tweet:
                onTweet();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
