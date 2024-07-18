package gymmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {

    public void addTrainer(Trainer trainer) throws SQLException {
        String query = "INSERT INTO trainer (name, email, phone_number, speciality) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getEmail());
            stmt.setString(3, trainer.getPhoneNumber());
            stmt.setString(4, trainer.getSpeciality());
            stmt.executeUpdate();
        }
    }

    public Trainer getTrainer(int trainerId) throws SQLException {
        String query = "SELECT * FROM trainer WHERE trainer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, trainerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Trainer(
                            rs.getInt("trainer_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("speciality")
                    );
                }
            }
        }
        return null;
    }

    public void updateTrainer(Trainer trainer) throws SQLException {
        String query = "UPDATE trainer SET name = ?, email = ?, phone_number = ?, speciality = ? WHERE trainer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getEmail());
            stmt.setString(3, trainer.getPhoneNumber());
            stmt.setString(4, trainer.getSpeciality());
            stmt.setInt(5, trainer.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTrainer(int trainerId) throws SQLException {
        String query = "DELETE FROM trainer WHERE trainer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, trainerId);
            stmt.executeUpdate();
        }
    }

    public List<Trainer> getAllTrainers() throws SQLException {
        List<Trainer> trainers = new ArrayList<>();
        String query = "SELECT * FROM trainer";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                trainers.add(new Trainer(
                        rs.getInt("trainer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("speciality")
                ));
            }
        }
        return trainers;
    }
}
