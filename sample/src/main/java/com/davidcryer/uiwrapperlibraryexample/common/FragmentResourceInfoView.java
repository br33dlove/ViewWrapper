package com.davidcryer.uiwrapperlibraryexample.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.davidcryer.uiwrapperlibraryexample.R;

public class FragmentResourceInfoView extends ResourceInfoView {
    private final static String FORMAT_BUTTON_CLICK_COUNTER = "Button click count: %1$s";
    private final TextView buttonClickCounterTextView;

    public FragmentResourceInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        buttonClickCounterTextView = findViewById(R.id.buttonClickCounter);
    }

    @Override
    int getLayoutRes() {
        return R.layout.fragment_resource_info_view;
    }

    public void setButtonClickCounter(final int count) {
        buttonClickCounterTextView.setText(String.format(FORMAT_BUTTON_CLICK_COUNTER, count));
    }
}
