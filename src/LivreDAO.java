import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivreDAO extends DAO<Livre> {

    public LivreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Livre L) {
        try {
            JDBC conn = JDBC.getInstance();
            String query = "insert into livre values (?,?,?)";
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setInt(1, L.getReference());
            stmt.setString(2, L.getTitre());
            stmt.setString(3, L.getAuteur());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Livre L) {
        try {
            JDBC conn = JDBC.getInstance();
            String query = "delete FROM livre WHERE reference=? ";
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setInt(1, L.getReference());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Livre l) {
        JDBC conn = JDBC.getInstance();
        String query = "update livre set titre = ?, auteur = ? where reference = ?";
        try {
            PreparedStatement PS = conn.conn.prepareStatement(query);
            PS.setString(1, l.getTitre());
            PS.setString(2, l.getAuteur());
            PS.setInt(3, l.getReference());
            PS.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String find(Livre L) {
        JDBC conn = JDBC.getInstance();
        try {
            Statement s = conn.conn.createStatement();
            String query = "SELECT * FROM livre WHERE reference = " + L.getReference();
            ResultSet res = s.executeQuery(query);
            String data = "Not Found";
            while (res.next()) {
                data = "Titre: " + res.getString(2) + "\nAuteur: " + res.getString(3);
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(LivreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "No";
        }
    }
}
