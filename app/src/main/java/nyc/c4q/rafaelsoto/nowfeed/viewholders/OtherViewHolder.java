package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.User;

/**
 * Created by dannylui on 10/31/16.
 */
public class OtherViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private TextView infoView;
    public OtherViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        infoView = (TextView) mView.findViewById(R.id.info_text);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.other_card_layout, parent, false);
    }

    public void bind(Object data) {
        User user_name = (User) data;
        String name = user_name.getName();
        infoView.setText(name);
    }
}

