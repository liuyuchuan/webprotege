package edu.stanford.bmir.protege.web.client.place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import edu.stanford.bmir.protege.web.client.lang.UserLanguageSettingsPresenter;
import edu.stanford.bmir.protege.web.shared.place.LanguageSettingsPlace;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17 Jul 2018
 */
public class LanguageSettingsActivity extends AbstractActivity {

    @Nonnull
    private final LanguageSettingsPlace place;

    @Nonnull
    private final UserLanguageSettingsPresenter presenter;

    public LanguageSettingsActivity(@Nonnull LanguageSettingsPlace place,
                                    @Nonnull UserLanguageSettingsPresenter presenter) {
        this.place = checkNotNull(place);
        this.presenter = checkNotNull(presenter);
    }

    @Nonnull
    public LanguageSettingsPlace getPlace() {
        return place;
    }

    @Nonnull
    public UserLanguageSettingsPresenter getPresenter() {
        return presenter;
    }

    public static LanguageSettingsActivity get(@Nonnull LanguageSettingsPlace place,
                                               @Nonnull UserLanguageSettingsPresenter presenter) {
        return new LanguageSettingsActivity(place, presenter);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        UserLanguageSettingsPresenter presenter = getPresenter();
        presenter.setNextPlace(getPlace().getNextPlace());
        presenter.start(panel);

    }

    @Override
    public int hashCode() {
        return place.getProjectId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LanguageSettingsActivity)) {
            return false;
        }
        LanguageSettingsActivity other = (LanguageSettingsActivity) obj;
        return this.place.getProjectId().equals(other.place.getProjectId());
    }
}
