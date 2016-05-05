package com.zc741.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Title");

        //返回键的设置与监听
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(ScrollingActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });

        //menu的设置与监听
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(ScrollingActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(ScrollingActivity.this, "notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(ScrollingActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(ScrollingActivity.this, "模式", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                startActivity(new Intent(ScrollingActivity.this, TabLayoutActivity.class));
            }
        });


    }
}
