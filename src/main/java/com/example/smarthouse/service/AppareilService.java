package com.example.smarthouse.service;

import com.example.smarthouse.bean.Appareil;
import com.example.smarthouse.dao.AppareilDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppareilService {
    @Autowired
    private AppareilDao appareilDao;

    public int save(Appareil appareil) {
        if (appareil == null) {
            return -1;
        } else {
            appareilDao.save(appareil);
            return 1;
        }
    }
    //on fait pas impl , directement service et implmentation,faire le meme pour category , dto ignore , mappers ignore , jst do controller with prof
    //dans le mapper on fait que ce qu'on veut utilisateur a access too , donc par ex pour appareil dans le web on veut donner l'access que le nom pas son id , donc le dto on va definir que nom , et mapper, donc c pour le metier , le bean tout entier pas la peine d utiliser dans le metier , que DB

    public Optional<Appareil> findById(Long aLong) {
        return appareilDao.findById(aLong);
    }

    public void deleteById(Long aLong) {
        appareilDao.deleteById(aLong);
    }

    public List<Appareil> findAll(Sort sort) {
        return appareilDao.findAll(sort);
    }
    public int switchOntoOff(Long id) {
        Optional<Appareil> appareil = appareilDao.findById(id);
        if (appareil.isPresent()) {
            Appareil currentAppareil = appareil.get();
            if (currentAppareil.getState()) {
                currentAppareil.setState(false); // Switch off
                appareilDao.save(currentAppareil);
                return 1;
            }
        }
        return -1;
    }

    public int switchOfftoOn(Long id) {
        Optional<Appareil> appareil = appareilDao.findById(id);
        if (appareil.isPresent()) {
            Appareil currentAppareil = appareil.get();
            if (!currentAppareil.getState()) {
                currentAppareil.setState(true); // Switch on
                appareilDao.save(currentAppareil);
                return 1;
            }
        }
        return -1;
    }

    public int switchAllOn() {
        List<Appareil> appareils = appareilDao.findAll();
        if (!appareils.isEmpty()) {
            for (Appareil appareil : appareils) {
                if (!appareil.getState()) {
                    appareil.setState(true);
                    appareilDao.save(appareil);
                }
            }
            return 1;
        }
        return -1;
    }

    public int switchAllOff() {
        List<Appareil> appareils = appareilDao.findAll();
        if (!appareils.isEmpty()) {
            for (Appareil appareil : appareils) {
                if (appareil.getState()) {
                    appareil.setState(false);
                    appareilDao.save(appareil);
                }
            }
            return 1;
        }
        return -1;
    }

}

//entity once u define it it becomes bean , it became class/obj
//switch on to off , off to on , switchAllon , switchAlloff
//selectionner des apparaeils on d une category , ou off, after u do category bean