package com.zhbandroid.weixin.util;

import java.util.List;

import com.zhbandroid.weixin.R;
import com.zhbandroid.weixin.bean.ParentBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public class ExpandAdapter extends BaseExpandableListAdapter {
	private List<ParentBean> list;
	private Context context;
	LayoutInflater inflater;
	
	public ExpandAdapter(Context context,List<ParentBean> list) {
		this.context=context;
		this.list=list;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return list.get(groupPosition).getList().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		ViewHolder holder=ViewHolder.getInstance(context, convertView, R.layout.child_item_list, childPosition, parent);
		holder.setText(R.id.child_text, list.get(groupPosition).getList().get(childPosition).getContent());
		holder.setText(R.id.child_text1, list.get(groupPosition).getList().get(childPosition).getContentTag());
		return holder.getmConvertView();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return list.get(groupPosition).getList().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return list.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		ViewHolder holder=ViewHolder.getInstance(context, convertView, R.layout.parent_item_list, groupPosition, parent);
		holder.setText(R.id.id_content_group, list.get(groupPosition).getTitleContent());
		if(isExpanded){
			holder.getView(R.id.tubiao).setBackgroundResource(R.drawable.btn_browser2);
		}else{
			holder.getView(R.id.tubiao).setBackgroundResource(R.drawable.btn_browser);
		}
		return holder.getmConvertView();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
