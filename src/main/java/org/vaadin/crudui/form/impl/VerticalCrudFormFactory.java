package org.vaadin.crudui.form.impl;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.*;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.form.AbstractAutoGeneratedCrudFormFactory;

import java.util.List;

/**
 * @author Alejandro Duarte
 */
public class VerticalCrudFormFactory<T> extends AbstractAutoGeneratedCrudFormFactory<T> {

    public VerticalCrudFormFactory(Class<T> domainType) {
        super(domainType);
    }

    @Override
    public Component buildNewForm(CrudOperation operation, T domainObject, boolean readOnly, Button.ClickListener buttonClickListener) {
        FormLayout formLayout = new FormLayout();

        BeanFieldGroup fieldGroup = new BeanFieldGroup<>(domainObject.getClass());
        List<Field> fields = buildAndBind(operation, domainObject, readOnly, fieldGroup);
        fields.stream().forEach(field -> formLayout.addComponent(field));

        Button button = buildButton(operation, domainObject, fieldGroup, buttonClickListener);
        HorizontalLayout footerLayout = new HorizontalLayout(button);
        footerLayout.setSizeUndefined();

        VerticalLayout mainLayout = new VerticalLayout(formLayout, footerLayout);
        mainLayout.setComponentAlignment(footerLayout, Alignment.BOTTOM_RIGHT);
        mainLayout.setMargin(true);

        return mainLayout;
    }

}