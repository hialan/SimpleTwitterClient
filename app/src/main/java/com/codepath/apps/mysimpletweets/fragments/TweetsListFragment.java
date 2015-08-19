package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.adapters.TweetsArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Tweet;

import java.util.ArrayList;
import java.util.List;

abstract public class TweetsListFragment extends Fragment{

    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    // creation lifecycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        tweets = new ArrayList<Tweet>();
        aTweets = new TweetsArrayAdapter(getActivity(), tweets);
        super.onCreate(savedInstanceState);
    }

    // inflation logic
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container, false);
        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        lvTweets.setAdapter(aTweets);
        return v;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void addAll(List<Tweet> tweets) {
        aTweets.addAll(tweets);
    }

    public void insert(Tweet tweet, int index) {
        aTweets.insert(tweet, index);
    }

    public void clear() {
        aTweets.clear();
    }

    public void scrollToTop() {
        lvTweets.setSelectionFromTop(0, 0);
    }

    protected void setOnScrollListener(AbsListView.OnScrollListener listener) {
        lvTweets.setOnScrollListener(listener);
    }

    abstract public void onRefresh();
}
