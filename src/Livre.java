import java.sql.*;
public class Livre {
    private int reference ;
    private String titre ;
    private String auteur ;

    public Livre(int reference, String titre, String auteur) 
    {
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
    }

  
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    /* public void insert(Livre L) throws SQLException {
        JDBC conn =JDBC.getInstance();
        String query="insert into livre values (?,?,?)";
        PreparedStatement stmt = conn.conn.prepareStatement(query);   //methode sans DAO
        stmt.setInt(1,L.getReference());
        stmt.setString(2,L.getTitre());
        stmt.setString(3,L.getAuteur());
        stmt.executeUpdate();
    }
    */
}
