package com.zhbandroid.weixin.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhbandroid.weixin.R;
import com.zhbandroid.weixin.bean.ChildBean;
import com.zhbandroid.weixin.bean.ParentBean;
import com.zhbandroid.weixin.util.ExpandAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class ContantTabFragment extends Fragment {
	private ExpandableListView expandListView;
	private View view;
	private ExpandAdapter adapter;
	private List<ParentBean> list=new ArrayList<ParentBean>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.tab3, container, false);
		initView();
		return view;
	}
	private void initView() {
		expandListView=(ExpandableListView) view.findViewById(R.id.expandableListView);
		List<ChildBean> listChildren=new ArrayList<ChildBean>();
		for(int i=1;i<5;i++){
			listChildren.add(new ChildBean("第"+i+"小组", "第"+i+"小组标签"));
		}
		for(int i=1;i<6;i++){
			list.add(new ParentBean("第"+i+"大组", listChildren));
		}
		adapter=new ExpandAdapter(getActivity(),list);
		expandListView.setAdapter(adapter);
		//设置展开图标
		expandListView.setGroupIndicator(null);
		expandListView.setDivider(null);
		expandListView.setOnGroupClickListener(new OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				
				return false;
			}
		});
		expandListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Toast.makeText(getActivity(), "dazu"+groupPosition+"xiaozu"+childPosition+""+id, Toast.LENGTH_SHORT).show();
				Log.d("listView", list.get(groupPosition).getList().get(childPosition).getContent());
				return false;
			}
		});
	}
}
