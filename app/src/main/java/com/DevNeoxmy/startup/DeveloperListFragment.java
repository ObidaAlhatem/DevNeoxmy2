package com.DevNeoxmy.startup;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperListFragment extends Fragment {
    ArrayList<TeamMemberInfo> TeamMembersList;
    ListView lv;
    TeamMemberAdapter adapter;

    public DeveloperListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_developer_list, container, false);


        TeamMembersList = new ArrayList<TeamMemberInfo>();
        lv = (ListView) rootView.findViewById(R.id.linearv1);

        int j[]={R.array.dev1,R.array.dev2,R.array.dev3,R.array.dev4,R.array.dev5,R.array.dev6};
        for( int i : j) {
            String[] teamMember = getResources().getStringArray(i);
            TeamMembersList.add(new TeamMemberInfo(teamMember[0],teamMember[1],teamMember[2],teamMember[3],teamMember[4]));
        }
        adapter = new TeamMemberAdapter(getActivity(), TeamMembersList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeamMemberInfo developer=TeamMembersList.get(position);

                Intent intent = new Intent(getActivity(), TeamMemberActivity.class);
                intent.putExtra("developer",developer);
                startActivity(intent);
            }
        });






        return rootView;
    }

}
