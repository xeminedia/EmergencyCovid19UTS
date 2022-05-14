package com.example.intanfadila.emergencycovid19.view1.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.intanfadila.emergencycovid19.view.fragment.HospitalCFragment;
import com.example.intanfadila.emergencycovid19.view.fragment.HospitalNCFragment;

/**
 * Created by INTAN FADILA on 5/13/2022.
 */
public class HospitalsPagerAdapter {
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        @Override
        protected void getItem(Int position) Fragment {
            var fragment: Fragment? = null;
            when (position) {
                0 -> fragment = HospitalCFragment();
                1 -> fragment = HospitalNCFragment();
            }
            return fragment!!;
        }

        override fun getCount(): Int {
            return 2;
        }

        override fun getPageTitle(position: Int): CharSequence {
            var strTitleTabs = "";
            when (position) {
                0 -> strTitleTabs = "Covid-19";
                1 -> strTitleTabs = "Non Covid-19";
            }
            return strTitleTabs;
        }
}
