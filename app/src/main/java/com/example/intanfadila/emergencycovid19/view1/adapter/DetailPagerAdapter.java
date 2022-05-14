package com.example.intanfadila.emergencycovid19.view1.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.intanfadila.emergencycovid19.view.fragment.DetailCFragment;
import com.example.intanfadila.emergencycovid19.view.fragment.DetailNCFragment;

/**
 * Created by INTAN FADILA on 5/14/2022.
 */
public class DetailPagerAdapter {
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        @Override
        protected void getItem(Int position) Fragment {
            var fragment: Fragment? = null;
            when (position) {
                0 -> fragment = DetailCFragment();
                1 -> fragment = DetailNCFragment();
            }
            return fragment!!;
        }

        @Override
        protected void getCount() Int {
            return 2;
        }

        @Override
        protected void getPageTitle(Int position): CharSequence {
            var strTitleTabs = "";
            when (position) {
                0 -> strTitleTabs = "Covid-19";
                1 -> strTitleTabs = "Non Covid-19";
            }
            return strTitleTabs;
        }
}
