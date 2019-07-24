package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phonecallingproject.R;

import java.util.List;
import java.util.zip.Inflater;

import fragment.HistoryFragment;
import modelclass.CallHistory;

import static android.os.Build.VERSION_CODES.M;

public class CallHistoryAdapter extends RecyclerView.Adapter<CallHistoryAdapter.MyViewHolder> {
    Context context;
    List<CallHistory>callHistories;

    public CallHistoryAdapter(Context context,List<CallHistory> callHistories){
        this.context = context;
        this.callHistories = callHistories;
    }


    @NonNull
    @Override
    public CallHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_receive_call_history_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallHistoryAdapter.MyViewHolder myViewHolder, int i) {

         CallHistory callHistory = callHistories.get(i);


        if (!TextUtils.isEmpty(callHistory.getReceived_image())&& callHistory.getReceived_image().equalsIgnoreCase("true")){
          // myViewHolder.mobile_no.setText(callHistories.get(i).getMobile_no());
           myViewHolder.mobile_no.setText(callHistory.getMobile_no());
           myViewHolder.contacts_Name.setText(callHistory.getContacs_Name());
           myViewHolder.call_duration.setText(callHistory.getCall_duration());
           myViewHolder.call_date.setText(callHistory.getCall_date());

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

          private TextView contacts_Name, mobile_no,call_duration,call_date;
          private ImageView favorite_Image, calling_image,outgoing_image,received_image, missedcall_image,caller_profile_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            contacts_Name = itemView.findViewById(R.id.title_Contacs_Name);
            mobile_no = itemView.findViewById(R.id.title_Mobile_no);
            call_duration = itemView.findViewById(R.id.title_call_duration);
            call_date = itemView.findViewById(R.id.title_call_date);

            /*  favorite_Image = itemView.findViewById(R.id.favorite_Image_icon);
            calling_image = itemView.findViewById(R.id.call_image_Icon);
            outgoing_image = itemView.findViewById(R.id.outgoing_image_Icon);
            received_image = itemView.findViewById(R.id.received_image_Icon);
            missedcall_image = itemView.findViewById(R.id.missedcall_image_Icon);
            caller_profile_image = itemView.findViewById(R.id.caller_profile_image); */

        }
    }
}
