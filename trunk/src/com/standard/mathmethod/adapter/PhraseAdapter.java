package com.standard.mathmethod.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.standard.englishconversation.R;
import com.standard.mathmethod.entities.WordEntity;

public class PhraseAdapter extends ArrayAdapter<WordEntity> {
	private LayoutInflater inflater;
	private Context context;
	public PhraseAdapter(Context context, ArrayList<WordEntity> listWords) {
		super(context, 0, listWords);
		inflater = LayoutInflater.from(getContext());
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.fragment_phrase_item, parent, false);
			viewHolder.tvWord = (TextView) convertView.findViewById(R.id.phrase_tv);
			viewHolder.tvTranslate = (TextView) convertView.findViewById(R.id.translate_tv);
			viewHolder.tvPhonetic = (TextView) convertView.findViewById(R.id.phonetic_tv);
			viewHolder.tvCatoloryWord = (TextView) convertView.findViewById(R.id.catelogy_word_tv);
			viewHolder.btnSound =(ImageButton)convertView.findViewById(R.id.sound_btn);
			viewHolder.btnEnjoy =(ImageButton)convertView.findViewById(R.id.enjoy_btn);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.tvWord.setText(getItem(position).getWord());
		viewHolder.tvTranslate.setText(getItem(position).getTranslate());
		viewHolder.tvCatoloryWord.setText(getItem(position).getCatelogyWord());
		viewHolder.tvPhonetic.setText(getItem(position).getPhonetic());
		if(getItem(position).getEnjoy() == 1)
		{
			viewHolder.btnEnjoy.setBackgroundResource(R.drawable.star_full);
		}
		
		viewHolder.btnSound.setOnClickListener(btnSoundOnClick);
		viewHolder.btnEnjoy.setOnClickListener(btnEnjoyOnClick);
		return convertView;
	}

	private static class ViewHolder {
		TextView tvWord;
		TextView tvTranslate;
		TextView tvPhonetic;
		TextView tvCatoloryWord;
		ImageButton btnSound;
		ImageButton btnEnjoy;
	}

	private OnClickListener btnSoundOnClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		}
	};
	
	
	private OnClickListener btnEnjoyOnClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
	};
}
