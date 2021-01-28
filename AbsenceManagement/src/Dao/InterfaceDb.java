package Dao;

import java.util.ArrayList;

import Models.Apprenant;
import Models.Presence;
import Models.Promo;
import Models.User;

public interface InterfaceDb {
   User authentification(String email, String password);
   ArrayList<Promo> getPromotions();
   Promo getPromotionsByForrmateur(int idFormateur);
   ArrayList<Apprenant> getApprenant(int idPromo);
   int addAbsence(Presence presence);
   ArrayList<Presence> getListAbsence(int idApprenant);
}