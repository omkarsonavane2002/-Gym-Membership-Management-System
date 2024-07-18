package gymmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipPlanDAO {

    public void addPlan(MembershipPlan plan) throws SQLException {
        String query = "INSERT INTO membership_plan (name, duration_months, price_per_month) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, plan.getName());
            stmt.setInt(2, plan.getDurationMonths());
            stmt.setDouble(3, plan.getPricePerMonth());
            stmt.executeUpdate();
        }
    }

    public MembershipPlan getPlan(int planId) throws SQLException {
        String query = "SELECT * FROM membership_plan WHERE plan_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, planId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MembershipPlan(
                            rs.getInt("plan_id"),
                            rs.getString("name"),
                            rs.getInt("duration_months"),
                            rs.getDouble("price_per_month")
                    );
                }
            }
        }
        return null;
    }

    public void updatePlan(MembershipPlan plan) throws SQLException {
        String query = "UPDATE membership_plan SET name = ?, duration_months = ?, price_per_month = ? WHERE plan_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, plan.getName());
            stmt.setInt(2, plan.getDurationMonths());
            stmt.setDouble(3, plan.getPricePerMonth());
            stmt.setInt(4, plan.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePlan(int planId) throws SQLException {
        String query = "DELETE FROM membership_plan WHERE plan_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, planId);
            stmt.executeUpdate();
        }
    }

    public List<MembershipPlan> getAllPlans() throws SQLException {
        List<MembershipPlan> plans = new ArrayList<>();
        String query = "SELECT * FROM membership_plan";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                plans.add(new MembershipPlan(
                        rs.getInt("plan_id"),
                        rs.getString("name"),
                        rs.getInt("duration_months"),
                        rs.getDouble("price_per_month")
                ));
            }
        }
        return plans;
    }
}
