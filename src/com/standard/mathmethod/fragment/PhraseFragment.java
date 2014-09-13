
package com.standard.mathmethod.fragment;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.standard.englishconversation.R;
import com.standard.mathmethod.adapter.PhraseAdapter;
import com.standard.mathmethod.business.WordEnjoyBUS;
import com.standard.mathmethod.common.Constants;
import com.standard.mathmethod.entities.WordEntity;

public class PhraseFragment extends Fragment {

    private ListView lvWords;
    private Context context;
    private ArrayList<WordEntity> listwords;
    private WordEnjoyBUS wordEnjoyBus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_phrase_layout, container, false);
        context = this.getActivity().getApplicationContext();
        lvWords = (ListView)rootView.findViewById(R.id.phrase_lv);
        wordEnjoyBus = new WordEnjoyBUS(context);
        loadData();
        return rootView;
    }
    
    private void loadData(){
    	Bundle args = getArguments();
        int i = args.getInt(Constants.FRAGMENT_SECTION);
    	switch (Constants.WORD_CATEGORY) {
		case 3:
			listwords = wordEnjoyBus.getAllWordsByCategory("3");
			break;
		case 6:
			listwords = wordEnjoyBus.getAllWordsByCategory("6");
			break;	
		default:
			listwords = wordEnjoyBus.getAllWordsByCategory("1");
			break;
		}
    
    	if(listwords == null)
    	{
    		listwords =new ArrayList<WordEntity>();
    	}
    	PhraseAdapter adapter = new PhraseAdapter(context, listwords);
    	lvWords.setAdapter(adapter);
    }
   
}