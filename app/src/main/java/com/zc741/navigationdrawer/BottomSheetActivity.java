package com.zc741.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class BottomSheetActivity extends BaseActivity {

    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bottom_sheet);
    }

    //用途不够广泛
    public void intro(View view) {
        BottomSheetBehavior behavior = BottomSheetBehavior.from(findViewById(R.id.scroll));
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                System.out.println("1");
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                System.out.println("2");
            }
        });
    }

    //使用这个
    public void select(View view) {
        dialog = new BottomSheetDialog(BottomSheetActivity.this);
        dialog.setContentView(R.layout.bottom_sheet_dialog_layout);
        dialog.show();



    }

    public void photo(View view) {
        Toast.makeText(this, "你选择了 相册", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    public void camera(View view) {
        Toast.makeText(this, "你选择了 相机", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    public void cancel(View view) {
        dialog.dismiss();
    }

}
