package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Apprenant;
import Models.Formateur;
import Models.Presence;
import Models.Promo;
import Models.User;
import application.Main;

import java.sql.Statement;

public class DatabaseConnection implements InterfaceDb {

	@Override
	public User authentification(String email, String password) {
		User user = null;
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "select * from user where Email='" + email + "' and password='" + password + "'";
			Statement statement = cnx.createStatement();
			ResultSet res = statement.executeQuery(sql);
			if (res.next()) {
				if (res.getString("role").equals("apprenant")) {
					user = new Apprenant(res.getInt(1), res.getString(2), res.getString(3), res.getInt(6));
				} else if (res.getString("role").equals("formateur")) {
					user = new Formateur(res.getInt(1), res.getString(2), res.getString(3));
				
				} 
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Main.getAlert("Cannot connect to database", "error");
		}
		return user;
	}



	@Override
	public ArrayList<Promo> getPromotions() {
		ArrayList<Promo> promos = new ArrayList<Promo>();
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "SELECT * FROM `promo` " ;
			Statement statement = cnx.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				promos.add(new Promo(res.getInt(1), res.getString(2), res.getInt(6), res.getDate(3),
						res.getDate(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return promos;
	}

	@Override
	public Promo getPromotionsByForrmateur(int idFormateur) {
		Promo promo = null;
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "SELECT * FROM `promo` WHERE `Date_debut_scolaire`<CURRENT_DATE and `Date_Fin_scolaire`>CURRENT_DATE and id_user_formateur=" + idFormateur;
			Statement statement = cnx.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				promo = new Promo(res.getInt(1), res.getInt(5), res.getString(2), res.getInt(6), res.getDate(3),res.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return promo;
	}




	@Override
	public ArrayList<Apprenant> getApprenant(int idPromo) {
		ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "SELECT * FROM `user` WHERE Role='apprenant' and id_promo=" + idPromo;
			Statement statement = cnx.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				apprenants.add(new Apprenant(res.getInt(1), res.getString(2), res.getString(3), idPromo));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apprenants;
	}

	@Override
	public int addAbsence(Presence presence) {
		// TODO Auto-generated method stub
		int affectedRows = 0;
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "INSERT INTO `presence`(`id_apprenant`,`id_Formateur`,`absence`,`Date_absence`,`Duree`) VALUES (?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, presence.getIdApprenat());
			ps.setInt(2, presence.getIdFormateur());
			ps.setBoolean(3, presence.getAbsence());
			ps.setDate(4, presence.getDateAbsence());
			ps.setFloat(5, presence.getDureAbsence());
			affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("error creation");
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	@Override
	public ArrayList<Presence> getListAbsence(int idApprenant) {
		ArrayList<Presence> presences = new ArrayList<Presence>();
		try {
			Database con = new Database();
			Connection cnx = con.getConnection();
			String sql = "select * from presence WHERE justifier is NULL and absence=1 and id_apprenant=" + idApprenant;
			Statement statement = cnx.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				presences.add(new Presence(res.getInt(1), idApprenant, res.getInt(3), res.getBoolean(4), res.getDate(5), res.getFloat(6), res.getBoolean(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return presences;
	}



	

}