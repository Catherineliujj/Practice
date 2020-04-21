package com.catherineliu.practice.main_code.about_viewpager_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.catherineliu.practice.R;

import androidx.fragment.app.Fragment;

/**
 * @author Catherine Liu
 * ViewPager + TabLayout + Fragment   第四个Fragment
 * 08/04/2019
 */
public class ForthFragment extends Fragment {

    public ForthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forth, container, false);
    }

}
