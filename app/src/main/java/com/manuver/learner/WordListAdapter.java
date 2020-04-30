package com.manuver.learner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LinkedList<String> mList;
    private LayoutInflater mLayoutInflater;

    WordListAdapter(Context context, LinkedList<String> linkedList) {
        this.mList = linkedList;
        this.mLayoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String word = mList.get(position);
        holder.mTextViewItem.setText(word);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public WordListAdapter mAdapter;
        public TextView mTextViewItem;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;
            this.mTextViewItem = itemView.findViewById(R.id.word);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String text = mList.get(pos);
            this.mTextViewItem.setText("Clicked " + text);
        }
    }
}
