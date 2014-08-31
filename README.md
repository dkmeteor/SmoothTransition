
# Demo
![Examples list](https://raw.githubusercontent.com/dkmeteor/SmoothTransition/master/gif/flip.gif)

![Examples list](https://raw.githubusercontent.com/dkmeteor/SmoothTransition/master/gif/horizon.gif)

![Examples list](https://raw.githubusercontent.com/dkmeteor/SmoothTransition/master/gif/rotate.gif)

![Examples list](https://raw.githubusercontent.com/dkmeteor/SmoothTransition/master/gif/scale.gif)

# How to use

You can get all these animations by just one line:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SwitchAnimationUtil().startAnimation(getWindow().getDecorView(), Constant.mType);
    }

If you want to use these aniamtions on ListView / GridView or other AdapterView:

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (mSwitchAnimationUtil == null) {
			mSwitchAnimationUtil = new SwitchAnimationUtil();
			mSwitchAnimationUtil.startAnimation(mList, Constant.mType);
		}
	}

If you want to use these aniamtions in Fragment
    
class DemoFragment extends Fragment {
    private View mConverView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle     savedInstanceState) {
        mConverView = LayoutInflater.from(getActivity()).inflate(R.layout.view_fragment, null);
        mConverView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                new SwitchAnimationUtil().startAnimation(mConverView, Constant.mType);
            }
        });

        return mConverView;
    }

}

You can check there code in demo project.

# TODO
1.Replace the urgly demo gif.

2.More effect.

# License
Copyright (c) 2014 [Dean Ding](http://dk-exp.com)

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)