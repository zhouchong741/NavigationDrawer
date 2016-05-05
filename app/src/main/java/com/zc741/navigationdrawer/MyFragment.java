package com.zc741.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jiae on 2016/5/5.
 */
public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);
        TextView textView = (TextView) view.findViewById(R.id.text1);
        Bundle bundle = getArguments();
        if (bundle!=null){
            textView.setText(bundle.getString("content","default"));
        }
        return view;
    }

    public static MyFragment newInstance(String content){
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        myFragment.setArguments(bundle);
        return myFragment;
    }
}
