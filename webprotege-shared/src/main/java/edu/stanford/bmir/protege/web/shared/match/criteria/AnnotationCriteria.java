package edu.stanford.bmir.protege.web.shared.match.criteria;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15 Jun 2018
 */
public interface AnnotationCriteria extends Criteria {

    @Nonnull
    <R> R accept(@Nonnull AnnotationCriteriaVisitor<R> visitor);
}
