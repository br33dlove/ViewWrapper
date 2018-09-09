package com.davidcryer.uiwrapperlibraryexample.example;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.davidc.uiwrapper.UiWrapper;
import com.davidcryer.uiwrapperlibraryexample.common.Resource;

public class ExampleUiWrapper extends UiWrapper<ExampleUi, ExampleUi.Listener, ExampleUiModel> {
    private final Resource resource;

    private ExampleUiWrapper(Resource resource, ExampleUiModel uiModel) {
        super(uiModel);
        this.resource = resource;
    }

    public static ExampleUiWrapper newInstance(final Resource resource, final ExampleUiModelFactory uiModelFactory) {
        return new ExampleUiWrapper(resource, uiModelFactory.create());
    }

    public static ExampleUiWrapper savedElseNewInstance(
            final Resource resource,
            final ExampleUiModelFactory uiModelFactory,
            final Bundle savedState
    ) {
        final ExampleUiModel uiModel = savedUiModel(savedState);
        return uiModel == null ? newInstance(resource, uiModelFactory) : new ExampleUiWrapper(resource, uiModel);
    }

    private final Resource.Listener resourceListener = count -> uiModel().showResourceListenersCount(ui(), count);

    @Override
    protected void registerResources() {
        super.registerResources();
        resource.register(resourceListener);
    }

    @Override
    protected void setUp(@NonNull ExampleUi ui) {
        final ExampleUiModel model = uiModel();
        ui.showResourceListenersCount(model.getResourceListenersCount());
        ui.showTimeOfLastStateRecovery(model.getTimeOfLastStateRecovery());
        ui.showButtonClickCount(model.getButtonClickCount());
    }

    @NonNull
    @Override
    protected ExampleUi.Listener uiListener() {
        return new ExampleUi.Listener() {
            @Override
            public void onClickShowExampleDialog(ExampleUi ui) {
                ui.showExampleDialog();
            }

            @Override
            public void onClickNewExampleActivity(ExampleUi ui) {
                ui.showNewExampleActivity();
                uiModel().incrementButtonClickCounter(ui);
            }

            @Override
            public void onClickNewExampleFragment(ExampleUi ui) {
                ui.showNewExampleFragment();
                uiModel().incrementButtonClickCounter(ui);
            }
        };
    }

    @Override
    protected void unregisterResources() {
        super.unregisterResources();
        resource.unregister(resourceListener);
    }
}