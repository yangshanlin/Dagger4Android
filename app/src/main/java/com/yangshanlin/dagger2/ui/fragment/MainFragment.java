package com.yangshanlin.dagger2.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangshanlin.dagger2.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * 在目标 Fragment 的 onAttach() 方法中进行注入
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
public class MainFragment extends Fragment {

    private Unbinder mUnbinder;
    private static final String TAG = "MainFragment";

    public static MainFragment newInstance(String aString) {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        args.putString("keys", aString);
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    String mMainFragmentString;
    String mAString;
    @BindView(R.id.tv_main_fragment)
    TextView mTvMain;

    /**
     * 应在此处进行注入
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAString = getArguments().getString("keys");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        mUnbinder = ButterKnife.bind(this, inflate);
        String text = mAString + "\n" + mMainFragmentString;
        mTvMain.setText(text);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
