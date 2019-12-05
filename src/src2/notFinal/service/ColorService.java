package notFinal.service;

import hibernate.entity.CardColor;

import java.util.List;

public interface ColorService {
    List<CardColor> getCardColors();

    CardColor getCardColor(int theId);
}
