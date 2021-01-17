package org.addresses.services;

import org.addresses.models.ChangeType;
import org.addresses.models.Changes;
import org.addresses.models.Email;
import org.addresses.models.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsChangesSenderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendEmail(House house, ChangeType changeType){
        Email email = new Email();
        email.setAddress("ovchi98@mail.ru");
        String streetName = house.getStreet_id().getName();
        String houseNumber = String.format("%s%s к.%s", house.getNumber(), house.getLiter(), house.getKorpus());
        String body = String.format("Улица: %s\n" +
                "Номер дома: %s\n" +
                "Изменение: %s\n", streetName, houseNumber, changeType.name());
        email.setBody(body);
        jmsTemplate.convertAndSend("emailbox", email);
    }

    public <T> void sendChange(Class<T> entityClass, T entity, ChangeType changeType){
        Changes changes = new Changes();
        changes.setChangeType(changeType);
        changes.setChangingEntity(entity.toString());
        changes.setSubstanceOfChange(entityClass.getSimpleName());
        jmsTemplate.convertAndSend("changebox", changes);
    }

}
