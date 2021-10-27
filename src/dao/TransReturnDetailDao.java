package dao;

import dao.interfaces.TransDetailImp;
import dao.interfaces.TransReturnDetailImp;
import database.Database;
import models.TransactionDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.TransactionReturnDetail;

/**
 *
 * @author NESAS
 */
public class TransReturnDetailDao implements TransReturnDetailImp{

    Connection conn;
    
    private final String insert = "insert into transaction_return_details values (null,?,?,?)";
    
    public TransReturnDetailDao(){
        conn = Database.connection();
    }
    
    @Override
    public void insert(TransactionReturnDetail td) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            stat.setInt(1, td.getMedId());
            stat.setInt(2, td.getQty());
            stat.setInt(3, td.getTransactionId());
            stat.executeUpdate();
            
            ResultSet rs = stat.getGeneratedKeys();
            while(rs.next()){
                td.setId(rs.getInt(1));
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                stat.close();
            } catch (SQLException e){
                System.err.println(e);
            }
        }
    }

}
