package gymmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GymManagementApp {

    private static Scanner scanner = new Scanner(System.in);
    private static MemberDAO memberDAO = new MemberDAO();
    private static TrainerDAO trainerDAO = new TrainerDAO();
    private static MembershipPlanDAO membershipPlanDAO = new MembershipPlanDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Member Management");
            System.out.println("2. Trainer Management");
            System.out.println("3. Membership Plan Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    memberManagement();
                    break;
                case 2:
                    trainerManagement();
                    break;
                case 3:
                    membershipPlanManagement();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void memberManagement() {
        while (true) {
            System.out.println("1. Add Member");
            System.out.println("2. View Member");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. View All Members");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        viewMember();
                        break;
                    case 3:
                        updateMember();
                        break;
                    case 4:
                        deleteMember();
                        break;
                    case 5:
                        viewAllMembers();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addMember() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Member member = new Member(name, email, phoneNumber, address);
        memberDAO.addMember(member);
        System.out.println("Member added successfully.");
    }

    private static void viewMember() throws SQLException {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = memberDAO.getMember(memberId);
        if (member != null) {
            System.out.println("ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Address: " + member.getAddress());
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void updateMember() throws SQLException {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = memberDAO.getMember(memberId);
        if (member != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new address: ");
            String address = scanner.nextLine();

            member = new Member(memberId, name, email, phoneNumber, address);
            memberDAO.updateMember(member);
            System.out.println("Member updated successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void deleteMember() throws SQLException {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        memberDAO.deleteMember(memberId);
        System.out.println("Member deleted successfully.");
    }

    private static void viewAllMembers() throws SQLException {
        List<Member> members = memberDAO.getAllMembers();
        for (Member member : members) {
            System.out.println("ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Address: " + member.getAddress());
            System.out.println();
        }
    }

    private static void trainerManagement() {
        while (true) {
            System.out.println("1. Add Trainer");
            System.out.println("2. View Trainer");
            System.out.println("3. Update Trainer");
            System.out.println("4. Delete Trainer");
            System.out.println("5. View All Trainers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addTrainer();
                        break;
                    case 2:
                        viewTrainer();
                        break;
                    case 3:
                        updateTrainer();
                        break;
                    case 4:
                        deleteTrainer();
                        break;
                    case 5:
                        viewAllTrainers();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addTrainer() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter speciality: ");
        String speciality = scanner.nextLine();

        Trainer trainer = new Trainer(name, email, phoneNumber, speciality);
        trainerDAO.addTrainer(trainer);
        System.out.println("Trainer added successfully.");
    }

    private static void viewTrainer() throws SQLException {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine();
        Trainer trainer = trainerDAO.getTrainer(trainerId);
        if (trainer != null) {
            System.out.println("ID: " + trainer.getId());
            System.out.println("Name: " + trainer.getName());
            System.out.println("Email: " + trainer.getEmail());
            System.out.println("Phone Number: " + trainer.getPhoneNumber());
            System.out.println("Speciality: " + trainer.getSpeciality());
        } else {
            System.out.println("Trainer not found.");
        }
    }

    private static void updateTrainer() throws SQLException {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine();
        Trainer trainer = trainerDAO.getTrainer(trainerId);
        if (trainer != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new speciality: ");
            String speciality = scanner.nextLine();

            trainer = new Trainer(trainerId, name, email, phoneNumber, speciality);
            trainerDAO.updateTrainer(trainer);
            System.out.println("Trainer updated successfully.");
        } else {
            System.out.println("Trainer not found.");
        }
    }

    private static void deleteTrainer() throws SQLException {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine();
        trainerDAO.deleteTrainer(trainerId);
        System.out.println("Trainer deleted successfully.");
    }

    private static void viewAllTrainers() throws SQLException {
        List<Trainer> trainers = trainerDAO.getAllTrainers();
        for (Trainer trainer : trainers) {
            System.out.println("ID: " + trainer.getId());
            System.out.println("Name: " + trainer.getName());
            System.out.println("Email: " + trainer.getEmail());
            System.out.println("Phone Number: " + trainer.getPhoneNumber());
            System.out.println("Speciality: " + trainer.getSpeciality());
            System.out.println();
        }
    }

    private static void membershipPlanManagement() {
        while (true) {
            System.out.println("1. Add Membership Plan");
            System.out.println("2. View Membership Plan");
            System.out.println("3. Update Membership Plan");
            System.out.println("4. Delete Membership Plan");
            System.out.println("5. View All Membership Plans");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addMembershipPlan();
                        break;
                    case 2:
                        viewMembershipPlan();
                        break;
                    case 3:
                        updateMembershipPlan();
                        break;
                    case 4:
                        deleteMembershipPlan();
                        break;
                    case 5:
                        viewAllMembershipPlans();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addMembershipPlan() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter duration in months: ");
        int durationMonths = scanner.nextInt();
        System.out.print("Enter price per month: ");
        double pricePerMonth = scanner.nextDouble();
        scanner.nextLine();

        MembershipPlan plan = new MembershipPlan(name, durationMonths, pricePerMonth);
        membershipPlanDAO.addPlan(plan);
        System.out.println("Membership plan added successfully.");
    }

    private static void viewMembershipPlan() throws SQLException {
        System.out.print("Enter plan ID: ");
        int planId = scanner.nextInt();
        scanner.nextLine();
        MembershipPlan plan = membershipPlanDAO.getPlan(planId);
        if (plan != null) {
            System.out.println("ID: " + plan.getId());
            System.out.println("Name: " + plan.getName());
            System.out.println("Duration (Months): " + plan.getDurationMonths());
            System.out.println("Price per Month: " + plan.getPricePerMonth());
        } else {
            System.out.println("Plan not found.");
        }
    }

    private static void updateMembershipPlan() throws SQLException {
        System.out.print("Enter plan ID: ");
        int planId = scanner.nextInt();
        scanner.nextLine();
        MembershipPlan plan = membershipPlanDAO.getPlan(planId);
        if (plan != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new duration in months: ");
            int durationMonths = scanner.nextInt();
            System.out.print("Enter new price per month: ");
            double pricePerMonth = scanner.nextDouble();
            scanner.nextLine();

            plan = new MembershipPlan(planId, name, durationMonths, pricePerMonth);
            membershipPlanDAO.updatePlan(plan);
            System.out.println("Membership plan updated successfully.");
        } else {
            System.out.println("Plan not found.");
        }
    }

    private static void deleteMembershipPlan() throws SQLException {
        System.out.print("Enter plan ID: ");
        int planId = scanner.nextInt();
        scanner.nextLine();
        membershipPlanDAO.deletePlan(planId);
        System.out.println("Membership plan deleted successfully.");
    }

    private static void viewAllMembershipPlans() throws SQLException {
        List<MembershipPlan> plans = membershipPlanDAO.getAllPlans();
        for (MembershipPlan plan : plans) {
            System.out.println("ID: " + plan.getId());
            System.out.println("Name: " + plan.getName());
            System.out.println("Duration (Months): " + plan.getDurationMonths());
            System.out.println("Price per Month: " + plan.getPricePerMonth());
            System.out.println();
        }
    }
}

