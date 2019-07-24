package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import modelclass.Contacts;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    Context context;
    List<Contacts>contactsList;

    public ContactsAdapter(List<Contacts>contactsList , Context context){
        this.context = context;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
