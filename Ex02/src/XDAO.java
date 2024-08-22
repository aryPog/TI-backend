import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XDAO {
    private String url = "jdbc:postgresql://localhost:5432/X";
    private String user = "postgres";
    private String password = "root";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insert(X x) {
        String sql = "INSERT INTO x_table (name) VALUES (?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, x.getName());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    x.setId(generatedKeys.getInt(1));
                }
            }

            System.out.println("X object inserted successfully with ID: " + x.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<X> list() {
        List<X> xList = new ArrayList<>();
        String sql = "SELECT * FROM x_table";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                X x = new X(rs.getInt("id"), rs.getString("name"));
                xList.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xList;
    }

    public void update(int id, String newName) {
        String sql = "UPDATE x_table SET name = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("X object updated successfully!");
            } else {
                System.out.println("X object with the provided ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM x_table WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("X object deleted successfully!");
            } else {
                System.out.println("X object with the provided ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
