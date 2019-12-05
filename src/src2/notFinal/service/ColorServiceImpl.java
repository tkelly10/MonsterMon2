package notFinal.service;

import hibernate.entity.CardColor;
import notFinal.dao.colorDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService{
    @Autowired
    private colorDao colorDao;


    @Override
    @Transactional
    public List<CardColor> getCardColors() {

    return colorDao.getCardColors();


    }

    @Override
    @Transactional
    public CardColor getCardColor(int theId) {
        return colorDao.getCardColors(theId);

    }
}
