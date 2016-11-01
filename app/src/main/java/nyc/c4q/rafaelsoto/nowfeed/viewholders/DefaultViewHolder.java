package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rafaelsoto.nowfeed.R;

/**
 * Created by dannylui on 10/31/16.
 */
public class DefaultViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    public DefaultViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.default_card_layout, parent, false);
    }

    public void bind(Object data) {

    }
}

