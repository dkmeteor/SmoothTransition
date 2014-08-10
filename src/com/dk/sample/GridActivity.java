package com.dk.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GridActivity extends Activity {
	private GridView mGrid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		mGrid = (GridView) findViewById(R.id.grid);
		mGrid.setAdapter(new GridAdapter());
	
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		SwitchAnimationUtil.startAnimation(getWindow().getDecorView());
	}
	

	private class GridAdapter extends BaseAdapter {
		private int[] res = new int[] { R.drawable.p1, R.drawable.p2,
				R.drawable.b1, R.drawable.b2 };

		@Override
		public int getCount() {
			return 99;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			if (convertView == null) {
				ImageView mImage = new ImageView(GridActivity.this);
				AbsListView.LayoutParams params = new AbsListView.LayoutParams(
						480 / 4, 480 / 4);
				mImage.setLayoutParams(params);
				mImage.setScaleType(ScaleType.CENTER_CROP);
				mImage.setPadding(5, 5, 5, 5);
				convertView=mImage;
				convertView.setAlpha(0);
			}

			((ImageView) convertView).setImageResource(res[position
					% res.length]);
			return convertView;
		}
	}
}
