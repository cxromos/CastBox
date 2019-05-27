package com.cxromos.castbox.injection.component;

import com.cxromos.castbox.injection.qualifiers.ConfigPersistent;
import com.cxromos.castbox.injection.module.ActivityModule;
import com.cxromos.castbox.injection.module.FragmentModule;
import com.cxromos.castbox.ui.base.BaseActivity;
import com.cxromos.castbox.ui.base.BaseFragment;

import dagger.Component;

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't
 * be destroy during configuration changes. Check {@link BaseActivity} and {@link BaseFragment} to
 * see how this components survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}