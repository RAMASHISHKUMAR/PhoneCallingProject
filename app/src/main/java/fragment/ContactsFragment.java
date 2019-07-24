package fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phonecallingproject.R;

import java.util.List;

import adapter.CallHistoryAdapter;
import adapter.ContactsAdapter;
import databasehelper.RealmDatabaseHelper;
import io.realm.Realm;
import io.realm.RealmResults;
import modelclass.CallHistory;
import modelclass.Contacts;

public class ContactsFragment extends Fragment {


    private View recyclerView;
    private Object realm;

    List<Contacts>contectslist;
    private ContactsAdapter contactsAdapter;

    public ContactsFragment() {
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
     View view = inflater.inflate(R.layout.fragment_contacts, container, false);
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
         showContactsCall();  //implements recyclerview
    }
public void showContactsCall(){

        if (contectslist!=null && contectslist.size()>0){
            contactsAdapter = new ContactsAdapter(contectslist, getActivity());

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
   //         recyclerView.setAdapter(contactsAdapter);


        }

}
}