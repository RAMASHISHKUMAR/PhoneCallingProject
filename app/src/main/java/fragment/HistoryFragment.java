package fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.phonecallingproject.R;

import java.util.ArrayList;
import java.util.List;

import adapter.CallHistoryAdapter;
import databasehelper.RealmDatabaseHelper;
import modelclass.CallHistory;

import static android.support.v7.widget.LinearLayoutManager.*;

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    CardView cardView;

    List<CallHistory> callHistoryList;

    private CallHistoryAdapter callHistoryAdapter;

    List<CallHistory> callHistories = new ArrayList<>();



    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
      recyclerView =  view.findViewById(R.id.history_RecyclerView);
      return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onResume() {
        super.onResume();

      showCallHistoryDetails();   // Implements recycler

    }
    public void showCallHistoryDetails(){
        callHistories = RealmDatabaseHelper.getAllCallHistorey();
        if (callHistories!=null && callHistories.size()>0){
            Log.d("Data Size ",""+callHistoryList.size());
            callHistoryAdapter = new CallHistoryAdapter(getActivity(),callHistoryList);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(callHistoryAdapter);
        }

    }


}
