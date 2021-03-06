package com.davidcryer.uiwrapperlibraryexample.exampledialog;

import android.os.Parcel;
import android.os.Parcelable;

import com.davidc.uiwrapper.UiModel;

public class ExampleDialogUiModel implements UiModel<ExampleDialogUiModel.SavedState> {

    ExampleDialogUiModel() {}

    ExampleDialogUiModel(final SavedState savedState) {}

    @Override
    public SavedState getParcelable() {
        return new SavedState();
    }

    static class SavedState implements Parcelable {

        private SavedState() {}

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        private SavedState(Parcel in) {}

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
