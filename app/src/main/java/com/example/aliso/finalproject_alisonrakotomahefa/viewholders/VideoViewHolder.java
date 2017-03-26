package com.example.aliso.finalproject_alisonrakotomahefa.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aliso.finalproject_alisonrakotomahefa.R;
import com.example.aliso.finalproject_alisonrakotomahefa.interfaces.OnVideoSelectedListener;
import com.example.aliso.finalproject_alisonrakotomahefa.models.Item;
import com.squareup.picasso.Picasso;


public class VideoViewHolder extends RecyclerView.ViewHolder {

	private TextView name;
	private TextView contract_name;
	private OnVideoSelectedListener onVideoSelectedListener;

	public VideoViewHolder(View itemView) {
		super(itemView);
		name = (TextView) itemView.findViewById(R.id.name);
		contract_name = (TextView) itemView.findViewById(R.id.contract_name);

        /*Picasso.with(itemView.getContext())
                .load(item.getSnippet().getThumbnails().getMedium().getUrl())
                .into(image);*/
	}

	public void bind(final Item item) {
		name.setText(item.getSnippet().getChannelTitle());
		contract_name.setText(item.getId().getVideoId());
		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onVideoSelectedListener == null) {
					return;
				}
				//onVideoSelectedListener.onContractSelected(item);
			}
		});
	}

	public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
		this.onVideoSelectedListener = onVideoSelectedListener;
	}

}
