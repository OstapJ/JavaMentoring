package com.epam.mentoring.creationalpatterns.abstractfactory.fixed;

/**
 * Created by andrei_varabyeu on 1/13/16.
 */
//в данном примере этот интерфейс, конечно, избыточен. Добавил чтобы была понятна суть паттерна
public interface PersonDaoFactory {
    PersonDaoFactory getPersonDao();
}
