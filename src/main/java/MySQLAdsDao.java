import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;
    //Zack used Connection connection = null;

    public MySQLAdsDao(Config config) {

        Driver driver;

        try {

            driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (Exception e) {
            e.printStackTrace();
            //Can also put "throw new RuntimeException" here.  Instead of e.printStackTrace().
        }
    }

    @Override
    public List<Ad> all() throws SQLException {

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from ads ");
        List<Ad> ads = new ArrayList<>();

        while (rs.next()) {
            ads.add(
                    new Ad(
                            rs.getLong("id"),
                            rs.getLong("user_id"),
                            rs.getString("title"),
                            rs.getString("description")
                    )
            );
        }
        return ads;

    }

    // insert a new ad and return the new ad's id
    @Override
    public Long insert(Ad ad) throws SQLException{
        String query = String.format("INSERT INTO ads(user_id, title, description) VALUES(%d, '%s', '%s')", ad.getUserId(), ad.getTitle(),ad.getDescription()
                );
        //Zack used String query = "INSERT INTO ads(user_id, title, description) VALUES("; query += "1, ";
        //query += "'" + ad.getTitle() + "',";
        //query += "'" +ad.getDescription() +"'";
        //query += ")";
        //SOUT("[DEBUG]: Running SQL..."+ query);


        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            return rs.getLong(1);
        }
        return null;
    }

//    @Override
//    public void all() throws SQLException{
//        Statement stmt = connection.createStatement();
//        List<Ad> all = new ArrayList<>();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM ads WHERE description = 'description'");
//
//    }
}