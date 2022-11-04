package menu;

import entity.*;
import exception.CapacityException;
import exception.NotFoundClassException;
import util.AppContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);

    public void patientRegistration() {
        try {
            System.out.println("enter your first name: ");
            String firstname = input.next();
            System.out.println("enter your last name: ");
            String lastname = input.next();
            System.out.println("enter your national code: ");
            String nationalCode = input.next();
            System.out.println("enter your username: ");
            String username = input.next();
            System.out.println("enter your password: ");
            String password = input.next();

            AppContext.getPatientService().saveByInfo(
                    firstname, lastname, nationalCode, username, password
            );
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }


    public void viewPatientInfo() {
        try {
            System.out.println("enter the national code: ");
            String nationalCode = input.nextLine();
            System.out.println("enter the username: ");
            String username = input.nextLine();

            Patient patient = AppContext.getPatientService().loadPatient(nationalCode, username);
            System.out.println(patient);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void doctorRegistration() {
        try {
            System.out.println("enter your first name: ");
            String firstname = input.next();
            System.out.println("enter your last name: ");
            String lastname = input.next();
            System.out.println("enter your national code: ");
            String nationalCode = input.next();
            System.out.println("enter your username: ");
            String username = input.next();
            System.out.println("enter your password: ");
            String password = input.next();

            Doctor doctor = new Doctor(firstname, lastname, nationalCode, username, password);
            AppContext.getDoctorService().saveOrUpdate(doctor);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void viewDoctorInfo() {
        try {
            System.out.println("enter the firstname:");
            String fName = input.nextLine();
            System.out.println("enter the lastname:");
            String lName = input.nextLine();
            System.out.println("enter the username:");
            String uName = input.nextLine();
            Doctor doctor = AppContext.getDoctorService().loadByFullNameAndUser(fName, lName, uName);

            System.out.println(doctor);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addAdmin() {
        try {
            System.out.println("enter your first name: ");
            String firstname = input.next();
            System.out.println("enter your last name: ");
            String lastname = input.next();
            System.out.println("enter your national code: ");
            String nationalCode = input.next();
            System.out.println("enter your username: ");
            String username = input.next();
            System.out.println("enter your password: ");
            String password = input.next();

            Admin admin = new Admin(firstname, lastname, nationalCode, username, password);
            AppContext.getAdminService().saveOrUpdate(admin);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addClinic() {
        try {
            System.out.println("enter the name of the clinic:");
            String clinicName = input.next();
            System.out.println("    << admin information >>");
            System.out.println("enter the firstname:");
            String fName = input.next();
            System.out.println("enter the lastname:");
            String lName = input.next();
            System.out.println("enter the username:");
            String uName = input.next();

            Admin admin = AppContext.getAdminService().loadByFullNameAndUser(fName, lName, uName);
            Clinic clinic = new Clinic(clinicName, admin);
            AppContext.getClinicService().saveOrUpdate(clinic);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void viewAllClinicsAndDoctors() {
        try {
            List<Clinic> clinics = AppContext.getClinicService().loadAll();
            System.out.println(clinics);

            System.out.println("enter the name of the clinic: ");
            String clinicName = input.next();
            Clinic clinic = AppContext.getClinicService().loadByName(clinicName);

            List<DoctorDTO> doctorDTOS = new ArrayList<>();

            List<Doctor> doctors = AppContext.getDoctorService().loadByClinicId(clinic.getId());
            doctors.forEach(doctor -> {
                DoctorDTO doctorDTO = new DoctorDTO(doctor.getFirstname(), doctor.getLastname());
                doctorDTOS.add(doctorDTO);
            });

            System.out.println(doctorDTOS);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }

    }

    public void addPrescription() {
        try {
            System.out.println("enter the national code: ");
            String nationalCode = input.nextLine();
            Patient patient = AppContext.getPatientService().loadPatient(nationalCode);

            System.out.println("    << doctor information >>");
            System.out.println("enter the firstname:");
            String fName = input.nextLine();
            System.out.println("enter the lastname:");
            String lName = input.nextLine();
            System.out.println("enter the username:");
            String uName = input.nextLine();
            Doctor doctor = AppContext.getDoctorService().loadByFullNameAndUser(fName, lName, uName);

            System.out.println("enter the description: ");
            String description = input.nextLine();

            Prescription prescription = new Prescription(description, patient, doctor);
            AppContext.getPrescriptionService().saveOrUpdate(prescription);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void viewPrescription() {
        try {
            System.out.println("enter the national code: ");
            String nationalCode = input.nextLine();
            Patient patient = AppContext.getPatientService().loadPatient(nationalCode);

            List<Prescription> prescriptions = AppContext.getPrescriptionService().loadByPatientId(patient.getId());
            System.out.println(prescriptions);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void queuingSystem() {
        try {
            System.out.println("    << doctor information >>");
            System.out.println("enter the firstname:");
            String fName = input.nextLine();
            System.out.println("enter the lastname:");
            String lName = input.nextLine();
            System.out.println("enter the username:");
            String uName = input.nextLine();
            Doctor doctor = AppContext.getDoctorService().loadByFullNameAndUser(fName, lName, uName);

            System.out.println("enter the date: (yyyy-mm-dd)");
            String stringDate = input.next();
            LocalDate date = LocalDate.parse(stringDate);

            System.out.println("enter the start time: (hh:mm:ss)");
            String stringTime1 = input.next();
            LocalTime startTime = LocalTime.parse(stringTime1);

            System.out.println("enter the end time: (hh:mm:ss)");
            String stringTime2 = input.next();
            LocalTime endTime = LocalTime.parse(stringTime2);

            System.out.println("enter the capacity: ");
            int capacity = input.nextInt();

            for (int i = 0; i < capacity; i++) {
                Queuing queuing = new Queuing(date, startTime, endTime, doctor);
                if (queuing.getEndTime().compareTo(queuing.getVisitTime()) <= 0) {
                    throw new CapacityException("the visit time is greater than end time!");
                }
                queuing.setVisitTime(startTime.plusMinutes(30L * i));
                AppContext.getQueuingService().saveOrUpdate(queuing);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void viewAllQueuing() {
        try {
            List<Queuing> queuing = AppContext.getQueuingService().loadAll();
            System.out.println(queuing);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void viewAllQueuingByDoctorId() {
        try {
            System.out.println("    << doctor information >>");
            System.out.println("enter the firstname:");
            String fName = input.nextLine();
            System.out.println("enter the lastname:");
            String lName = input.nextLine();
            System.out.println("enter the username:");
            String uName = input.nextLine();
            Doctor doctor = AppContext.getDoctorService().loadByFullNameAndUser(fName, lName, uName);

            List<QueuingDTO> queuingDTOS = new ArrayList<>();

            List<Queuing> queuing = AppContext.getQueuingService().loadByDoctorId(doctor.getId());
            queuing.forEach(queuing1 -> {
                QueuingDTO queuingDTO= new QueuingDTO(
                        queuing1.getDate(), queuing1.getVisitTime(), new DoctorDTO(fName, lName)
                );
                queuingDTOS.add(queuingDTO);
            });
            System.out.println(queuingDTOS);
        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public void reserveTime() {
        try {
            System.out.println("enter the national code: ");
            String nationalCode = input.nextLine();
            Patient patient = AppContext.getPatientService().loadPatient(nationalCode);

            System.out.println("enter the queuing id:");
            long queuingId = input.nextLong();
            Queuing queuing = AppContext.getQueuingService().loadById(queuingId);
            queuing.setPatient(patient);
            AppContext.getQueuingService().saveOrUpdate(queuing);

        } catch (NotFoundClassException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();

            //menu.patientRegistration();
            //menu.viewPatientInfo();
            //menu.doctorRegistration();
            //menu.addAdmin();
            //menu.addClinic();
            //menu.viewAllClinicsAndDoctors();
            //menu.addPrescription();
            //menu.viewPrescription();
            //menu.queuingSystem();
            //menu.viewAllQueuingByDoctorId();
            //menu.reserveTime();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
