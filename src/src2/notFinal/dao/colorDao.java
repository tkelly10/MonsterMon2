package notFinal.dao;

import hibernate.entity.CardColor;

import java.util.List;

public interface colorDao {
    List<CardColor> getCardColors();

    CardColor getCardColors(int id);
 }
