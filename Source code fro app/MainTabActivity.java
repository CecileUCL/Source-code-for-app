package com.exam2;

import java.util.Timer;
import java.util.TimerTask;

import com.exam2.R;
import com.exam2.adapter.MainTabPagerAdapter;
import com.exam2.controller.MainTabController;
import com.exam2.controller.TopicController;
import com.exam2.project.ProjectConfig;
import com.exam2.util.UiUtil;
import com.exam2.widget.IconPageIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainTabActivity extends FragmentActivity implements
		 ClassicsListFragment.Callbacks {

	private ViewPager main_tab_pager;// viewpager
	private IconPageIndicator main_tab_icon_indicator;
	private MainTabPagerAdapter mtpa;
	private MainTabController mtc;
	private TextView tv_title;

	// for exit
	private static Timer tExit;
	private static TimerTask task;
	private static Boolean isExit = false;
	private static Boolean hasTask = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_tab);

		mtc = new MainTabController(this);

		main_tab_pager = (ViewPager) findViewById(R.id.main_tab_pager);
		main_tab_icon_indicator = (IconPageIndicator) findViewById(R.id.main_tab_icon_indicator);

		mtpa = mtc.getPagerAdapter(getSupportFragmentManager());
		main_tab_pager.setAdapter(mtpa);
		main_tab_icon_indicator.setViewPager(main_tab_pager);

		int page = getIntent().getIntExtra("page", -1);
		if (page < 0) {
			switchPage(0);
		} else {
			switchPage(page);
		}

		// for exit
		tExit = new Timer();
		task = new TimerTask() {
			@Override
			public void run() {
				isExit = false;
				hasTask = true;
			}
		};

	}

	private void switchPage(int position) {
		tv_title = (TextView) findViewById(R.id.tv_title);
		main_tab_pager.setCurrentItem(position);
		tv_title.setText(mtpa.getTitles().get(position));
		main_tab_pager.setOnPageChangeListener(getOnPageChangeListener());
	}

	@Override
	public void onClassicsIdSelected(int classicsId) {
		Intent intent = new Intent(this, ClassicsActivity.class);
		intent.putExtra("questionId", classicsId);
		startActivity(intent);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// for exit
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isExit == false) {
				isExit = true;
				UiUtil.showToastShort(this, R.string.main_exit_prompt);
				if (!hasTask) {
					tExit.schedule(task, 2000);
				} else {
					finish();
					System.exit(0);
				}
			}
		}
		return false;
	}

	public void toSequence(View v) {
		Intent intent = new Intent(this, TopicActivity.class);
		intent.putExtra("mode", TopicController.MODE_SEQUENCE);
		startActivity(intent);
	}

	public void toRandom(View v) {
		Intent intent = new Intent(this, TopicActivity.class);
		intent.putExtra("mode", TopicController.MODE_RANDOM);
		startActivity(intent);
	}

	public void toPracticeTest(View v) {
		Intent intent = new Intent(this, TopicActivity.class);
		intent.putExtra("mode", TopicController.MODE_PRACTICE_TEST);
		startActivity(intent);
	}



	public void toStatistics(View v) {
		Intent intent = new Intent(this, StatisticsActivity.class);
		startActivity(intent);
	}





	private OnPageChangeListener getOnPageChangeListener() {
		return (new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				tv_title.setText(mtpa.getTitles().get(position));
				main_tab_icon_indicator.setCurrentItem(position);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
			}
		});
	}

	
}
