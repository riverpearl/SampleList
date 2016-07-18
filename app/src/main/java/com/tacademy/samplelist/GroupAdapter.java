package com.tacademy.samplelist;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tacademy.samplelist.data.ChildItem;
import com.tacademy.samplelist.data.GroupItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-18.
 */
public class GroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<GroupItem> items = new ArrayList<>();

    public void put(String groupName, String childName, float textSize) {
        GroupItem group = null;
        for(GroupItem g : items) {
            if (g.groupName.equals(groupName)) {
                group = g;
                break;
            }
        }
        if (group == null) {
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }

        if (!TextUtils.isEmpty(childName)) {
            ChildItem child = new ChildItem();
            child.childName = childName;
            child.textSize = textSize;
            group.children.add(child);
        }

        notifyDataSetChanged();
    }

    public static final int VIEW_TYPE_HEADER = 100;
    public static final int VIEW_TYPE_GROUP = 200;
    public static final int VIEW_TYPE_CHILD = 10000;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return VIEW_TYPE_HEADER;
        position--;
        for (int i = 0; i < items.size(); i++) {
            if (position == 0) return VIEW_TYPE_GROUP;
            position--;
            if (position < items.get(i).children.size()) {
                return VIEW_TYPE_CHILD;
            }
            position -= items.get(i).children.size();
        }
        throw new IllegalArgumentException("invalid position");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER : {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_list_item, parent, false);
                StaggeredGridLayoutManager.LayoutParams params = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setFullSpan(true);
                view.setLayoutParams(params);
                HeaderViewHolder hvh = new HeaderViewHolder(view);
                return hvh;
            }
            case VIEW_TYPE_GROUP : {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                StaggeredGridLayoutManager.LayoutParams params = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setFullSpan(true);
                view.setLayoutParams(params);
                return new GroupViewHolder(view);
            }
            case VIEW_TYPE_CHILD : {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                return new ChildViewHolder(view);
            }
        }
        throw new IllegalArgumentException("invalid viewtype");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            HeaderViewHolder hvh = (HeaderViewHolder)holder;
            return;
        }
        position--;
        for (int i = 0; i < items.size(); i++) {
            if (position == 0) {
                if (holder.getItemViewType() != VIEW_TYPE_GROUP) {
                    throw new IllegalArgumentException("invalid view holder");
                }
                GroupViewHolder gvh = (GroupViewHolder)holder;
                gvh.setGroup(items.get(i));
                return;
            }
            position--;
            if (position < items.get(i).children.size()) {
                ChildViewHolder cvh = (ChildViewHolder)holder;
                cvh.setChild(items.get(i).children.get(position));
                return;
            }
            position -= items.get(i).children.size();
        }
        throw new IllegalArgumentException("invalid position");
    }

    @Override
    public int getItemCount() {
        int count = 0;
        count++;
        for (int i = 0; i < items.size(); i++) {
            count++;
            count += items.get(i).children.size();
        }
        return count;
    }
}
