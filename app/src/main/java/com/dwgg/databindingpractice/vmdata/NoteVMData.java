package com.dwgg.databindingpractice.vmdata;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Andy on 16/3/9.
 */
public class NoteVMData extends BaseObservable {
    private String content;

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyChange();
    }
}
