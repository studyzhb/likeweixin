package com.zhbandroid.weixin;

import java.util.ArrayList;
import java.util.List;

import com.zhbandroid.weixin.fragment.ChatMainTabFragment;
import com.zhbandroid.weixin.fragment.ContantTabFragment;
import com.zhbandroid.weixin.fragment.FindTabFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;
	private ImageView mTabline;
	private int mScreen_1_3;
	private int mCurrentPageIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initDrawLine();
		
		initView();
	}

	private void initDrawLine() {
		mTabline=(ImageView) findViewById(R.id.line_bootom);
		Display display=getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics=new DisplayMetrics();
		display.getMetrics(outMetrics);
		mScreen_1_3=outMetrics.widthPixels/3;
		LayoutParams lp=mTabline.getLayoutParams();
		lp.width=mScreen_1_3;
		mTabline.setLayoutParams(lp);
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		
		
		viewPager=(ViewPager) findViewById(R.id.id_viewPager);
		mDatas=new ArrayList<Fragment>();
		ChatMainTabFragment tab01=new ChatMainTabFragment();
		FindTabFragment tab02=new FindTabFragment();
		ContantTabFragment tab03=new ContantTabFragment();
		mDatas.add(tab01);
		mDatas.add(tab02);
		mDatas.add(tab03);
		mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				
				return mDatas.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				
				return mDatas.get(arg0);
			}
		};
		viewPager.setAdapter(mAdapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				resetTextView();
				switch (arg0) {
				case 0:
//					setColor(Color.GREEN);
					break;

				default:
					break;
				}
				mCurrentPageIndex=arg0;
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int arg2) {
				LinearLayout.LayoutParams lp=(android.widget.LinearLayout.LayoutParams) mTabline.getLayoutParams();
				//0-->1
				if(mCurrentPageIndex==position){
					lp.leftMargin=(int) (positionOffset*mScreen_1_3+mCurrentPageIndex*mScreen_1_3);
					//
				}else if(mCurrentPageIndex>position){
					lp.leftMargin=(int) ((positionOffset-1)+mCurrentPageIndex*mScreen_1_3);
				}
				
				mTabline.setLayoutParams(lp);

			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
				
			}
		});
	}

	protected void resetTextView(){
		
	}
	
	
	
}
