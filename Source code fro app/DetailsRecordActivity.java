package com.exam2;

import java.util.ArrayList;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.exam2.R;
import com.exam2.model.ExamResultEntry;
import com.exam2.model.ExamResultService;

public class DetailsRecordActivity extends BaseActivity {
	TextView tv_title;
	TextView detail_date;
	TextView detail_usetime;
	TextView detail_sum_answer_right;
	TextView detail_sum_anserquestion;
	TextView detail_sum_answer_error;
	TextView detail_accuracy;
	TextView detail_score;
	TextView recent_score_str;
	ExamResultEntry entry;
	ExamResultService examResultService;
	private MyApplication app;

	// delete button
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//
		examResultService = new ExamResultService();
		setContentView(R.layout.activity_detail_record);
		app = (MyApplication) getApplication();
		
		
		switch (this.getIntent().getExtras().getInt("MODE")) {
		case 1: {
			entry = examResultService.getThisTestScore(DetailsRecordActivity.this);
			break;
		}
		case 2: {
			entry = (ExamResultEntry) getIntent().getSerializableExtra(
					"examResult");
			break;
		}
		}
		tv_title = (TextView) findViewById(R.id.tv_title);
		detail_date = (TextView) findViewById(R.id.detail_date);
		//detail_usetime = (TextView) findViewById(R.id.detail_usetime);
		detail_sum_answer_right = (TextView) findViewById(R.id.detail_sum_answer_right);
		detail_sum_answer_error = (TextView) findViewById(R.id.detail_sum_answer_error);
		detail_sum_anserquestion = (TextView) findViewById(R.id.detail_sum_anserquestion);
		detail_accuracy = (TextView) findViewById(R.id.detail_accuracy);
		detail_score = (TextView) findViewById(R.id.detail_score);
		recent_score_str = (TextView) findViewById(R.id.recent_score_str);
		if (this.getIntent().getExtras().getInt("MODE") == 1) {
			tv_title.setText(getResources()
					.getString(R.string.detail_this_exam));
		} else {
			tv_title.setText(getResources().getString(
					R.string.detail_this_record));
		}
		detail_date.setText(entry.getDateTime());
		//detail_usetime.setText(entry.getUseTime());
		detail_sum_answer_right.setText(getResources().getString(
				R.string.detail_total)
				+ entry.getRightCount()
				+ getResources().getString(R.string.detail_answer));
		detail_sum_answer_error.setText(getResources().getString(
				R.string.detail_total)
				+ entry.getWrongCount()
				+ getResources().getString(R.string.detail_answer));
		detail_sum_anserquestion.setText(getResources().getString(
				R.string.detail_total)
				+ entry.getTotalCount()
				+ getResources().getString(R.string.detail_answer));
		detail_accuracy.setText(""
				+ (int) (100 * (float) entry.getRightCount() / (float) entry
						.getTotalCount())
				+ getResources().getString(R.string.detail_qw));
		detail_score.setText(entry.getTotalScore()
				+ getResources().getString(R.string.detail_point));
		
		StringBuilder recentScoreStr = new StringBuilder();
		ExamResultService examResultService = new ExamResultService();
		final ArrayList<Map<String, Object>> getEntryList = examResultService.getRecordEntryList(this, " username = '" + app.getUsername() + "' ", "dateTime desc", String.valueOf(3));
		for (Map<String, Object> entry : getEntryList) {
			recentScoreStr.append(entry.get("totalScore") + "(" + entry.get("dateTime") + ")" + "\r\n");
		}
		
		recent_score_str.setText(recentScoreStr);
	}

	public void deleteRecord(View view) {
		Intent intent = null;
		examResultService
		.delete(DetailsRecordActivity.this, entry.get_id());
		switch (this.getIntent().getExtras().getInt("MODE")) {
		case 1: {
			intent = new Intent(DetailsRecordActivity.this,
					MainTabActivity.class);
			break;
		}
		case 2: {
			intent = new Intent(DetailsRecordActivity.this,
					RecordActivity.class);
			break;
		}
		default:
			break;
		}
		startActivity(intent);
		finish();
	}
}
