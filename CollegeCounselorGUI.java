/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollegeCounselor;

import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author aryangulati
 */
public class CollegeCounselorGUI extends javax.swing.JFrame {

    
    static String name = "";
    static List<Map<String,String>> students;
    /**
     * Creates new form CollegeCounselorGUI
     */
    
    /**
     * 
     * @param name Display name of logged in Microsoft user
     * @param students list of maps containing all excel file data
     */
    public CollegeCounselorGUI(String name, List<Map<String,String>> students) {
        initComponents();
        CollegeCounselorGUI.name = name;
        CollegeCounselorGUI.students = students;
        initialize();
        
    }
    
    private void initialize(){
        
        jLabel3.setText("Hello, " + name);
        errorField.setText("");
        Frame[] frames = AuthenticationUI.getFrames();
        Frame frame = frames[0];
        frame.setVisible(false);
        jTabbedPane1.remove(jTabbedPane2);
        jTabbedPane1.remove(jTabbedPane3);
        jTabbedPane1.remove(jTabbedPane4);
        jTabbedPane1.remove(jTabbedPane5);
        
       

    }
    
    private static String formatDate(String date) {
        
        int numberOfDays = Integer.parseInt(date);
        numberOfDays -= 2;
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1900);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DATE, numberOfDays);
        
        Date output = c.getTime();
        String formattedOutput = output.toString();
        String sectionOne = formattedOutput.substring(0, 10);
        String sectionTwo = formattedOutput.substring(23);
        formattedOutput = sectionOne+sectionTwo;
        
        
        return formattedOutput;

    }
    
    private void populateViews(int index){
        
        if (index == -1)
            errorField.setText("Student not found. Search Again.");
        
        else
            errorField.setText("Match found. If wrong student is found, try entering full name or searching by id or email");
        
        Map<String,String> studentDetails = students.get(index);
        enterName.setText(studentDetails.get("name"));
        enterEmail.setText(studentDetails.get("autoEmail"));
        enterCitizenship.setText(studentDetails.get("citizenship"));
        enterNationality.setText(studentDetails.get("nationality"));
        enterHomeroom.setText(studentDetails.get("homeroom"));
        enterDateOfBirth.setText(formatDate(studentDetails.get("dateOfBirth")));
        
        
        enterCountryPreferences.setText(studentDetails.get("countryPreferences"));
        enterDreamUni.setText(studentDetails.get("dreamUni"));
        enterMajors.setText(studentDetails.get("chosenMajor"));
        extracurriculars.setText("<html>" + studentDetails.get("extraCurriculars") + "</html>");
        yearsInDIA.setText(studentDetails.get("yearsInDIA"));
        previousSchools.setText("<html>" + studentDetails.get("previousSchools") + "</html>");
        standardizedTests.setText("<html>" + studentDetails.get("standardizedTestingStatus") + "</html>");
        resultsSAT.setText("<html>" + studentDetails.get("standardizedTestingScores") + "</html>");
        ibSubjects.setText("<html>" + studentDetails.get("ibSubjects") + "</html>");
        leadershipRoles.setText(studentDetails.get("leadership"));
        
        g1CA1.setText(studentDetails.get("g1CA1"));
        g2CA1.setText(studentDetails.get("g2CA1"));
        g3CA1.setText(studentDetails.get("g3CA1"));
        g4CA1.setText(studentDetails.get("g4CA1"));
        g5CA1.setText(studentDetails.get("g5CA1"));
        g6CA1.setText(studentDetails.get("g6CA1"));
        
        g1MR.setText(studentDetails.get("g1MR"));
        g2MR.setText(studentDetails.get("g2MR"));
        g3MR.setText(studentDetails.get("g3MR"));
        g4MR.setText(studentDetails.get("g4MR"));
        g5MR.setText(studentDetails.get("g5MR"));
        g6MR.setText(studentDetails.get("g6MR"));
        
        g1CA2.setText(studentDetails.get("g1CA2"));
        g2CA2.setText(studentDetails.get("g2CA2"));
        g3CA2.setText(studentDetails.get("g3CA2"));
        g4CA2.setText(studentDetails.get("g4CA2"));
        g5CA2.setText(studentDetails.get("g5CA2"));
        g6CA2.setText(studentDetails.get("g6CA2"));
        
        
        int ca1 = 0;
        try {
            
            ca1 += Integer.parseInt(studentDetails.get("g1CA1"));
            ca1 += Integer.parseInt(studentDetails.get("g2CA1"));
            ca1 += Integer.parseInt(studentDetails.get("g3CA1"));
            ca1 += Integer.parseInt(studentDetails.get("g4CA1"));
            ca1 += Integer.parseInt(studentDetails.get("g5CA1"));
            ca1 += Integer.parseInt(studentDetails.get("g6CA1"));
            
            ca1Total.setText(String.valueOf(ca1));
            
            
        }catch(Exception e){
            
            //TODO: Error handling
            ca1Total.setText("N/A");

            
        }
        
        int mr = 0;
        
          try {
            
            mr += Integer.parseInt(studentDetails.get("g1MR"));
            mr += Integer.parseInt(studentDetails.get("g2MR"));
            mr += Integer.parseInt(studentDetails.get("g3MR"));
            mr += Integer.parseInt(studentDetails.get("g4MR"));
            mr += Integer.parseInt(studentDetails.get("g5MR"));
            mr += Integer.parseInt(studentDetails.get("g6MR"));
            
            mrTotal.setText(String.valueOf(mr));
            
            
        }catch(Exception e){
            
            //TODO: Error handling
            mrTotal.setText("N/A");
            
        }
          
          int ca2 = 0;
        
          try {
            
            ca2 += Integer.parseInt(studentDetails.get("g1CA2"));
            ca2 += Integer.parseInt(studentDetails.get("g2CA2"));
            ca2 += Integer.parseInt(studentDetails.get("g3CA2"));
            ca2 += Integer.parseInt(studentDetails.get("g4CA2"));
            ca2 += Integer.parseInt(studentDetails.get("g5CA2"));
            ca2 += Integer.parseInt(studentDetails.get("g6CA2"));
            
            ca2Total.setText(String.valueOf(ca2));
            
            
        }catch(Exception e){
            
            //TODO: Error handling
            
            ca2Total.setText("N/A");
            
        }
     
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        enterName = new javax.swing.JLabel();
        enterEmail = new javax.swing.JLabel();
        enterHomeroom = new javax.swing.JLabel();
        enterNationality = new javax.swing.JLabel();
        enterCitizenship = new javax.swing.JLabel();
        enterDateOfBirth = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        enterCountryPreferences = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enterDreamUni = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        enterMajors = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        extracurriculars = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        leadershipRoles = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        yearsInDIA = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        previousSchools = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        standardizedTests = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        resultsSAT = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        ibSubjects = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        ca1Total = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        mrTotal = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        ca2Total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        g1CA1 = new javax.swing.JLabel();
        g2CA1 = new javax.swing.JLabel();
        g3CA1 = new javax.swing.JLabel();
        g4CA1 = new javax.swing.JLabel();
        g5CA1 = new javax.swing.JLabel();
        g6CA1 = new javax.swing.JLabel();
        g1MR = new javax.swing.JLabel();
        g2MR = new javax.swing.JLabel();
        g3MR = new javax.swing.JLabel();
        g4MR = new javax.swing.JLabel();
        g5MR = new javax.swing.JLabel();
        g6MR = new javax.swing.JLabel();
        g1CA2 = new javax.swing.JLabel();
        g2CA2 = new javax.swing.JLabel();
        g3CA2 = new javax.swing.JLabel();
        g4CA2 = new javax.swing.JLabel();
        g5CA2 = new javax.swing.JLabel();
        g6CA2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        errorField = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel5.setText("Email:");

        jLabel6.setText("Homeroom:");

        jLabel7.setText("Nationality:");

        jLabel8.setText("Citizenship:");

        jLabel9.setText("Date of birth:");

        enterName.setText("FirstName LastName");

        enterEmail.setText("dia17253@diaestudents.com");

        enterHomeroom.setText("12 C");

        enterNationality.setText("Country name here");

        enterCitizenship.setText("Country name here");

        enterDateOfBirth.setText("Date of birth will go here");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(enterName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addComponent(enterHomeroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterCitizenship, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(enterDateOfBirth))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(enterName, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(enterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(enterHomeroom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(enterNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(enterCitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(enterDateOfBirth))
                .addGap(120, 120, 120))
        );

        jTabbedPane1.addTab("Personal Details", jPanel1);
        jTabbedPane1.addTab("dlt", jTabbedPane3);
        jTabbedPane1.addTab("dlt", jTabbedPane4);
        jTabbedPane1.addTab("dlt", jTabbedPane5);
        jTabbedPane1.addTab("dlt", jTabbedPane2);

        jLabel4.setText("Preferred Countries:");

        enterCountryPreferences.setText("jLabel10");

        jLabel10.setText("Dream Universities:");

        enterDreamUni.setText("jLabel11");

        jLabel11.setText("Planned Majors:");

        enterMajors.setText("jLabel12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enterCountryPreferences, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addComponent(enterDreamUni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enterMajors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(enterCountryPreferences, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(enterDreamUni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(enterMajors, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("University Information", jPanel2);

        extracurriculars.setText("jLabel12");

        jLabel13.setText("Extracurricular Information (direct from form):");

        jLabel28.setText("Leadership:");

        leadershipRoles.setText("jLabel29");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel28)
                    .addComponent(extracurriculars, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leadershipRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 1182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(44, 44, 44)
                .addComponent(extracurriculars, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(37, 37, 37)
                .addComponent(leadershipRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Extracurriculars", jPanel3);

        jLabel12.setText("Years in DIA:");

        yearsInDIA.setText("jLabel14");

        jLabel15.setText("Previous Schools:");

        previousSchools.setText("jLabel16");

        jLabel17.setText("Standardized Tests:");

        standardizedTests.setText("jLabel18");

        jLabel19.setText("Results From Tests:");

        resultsSAT.setText("jLabel20");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yearsInDIA, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousSchools, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(standardizedTests, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultsSAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(yearsInDIA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(previousSchools, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(standardizedTests, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(resultsSAT, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("School and Standarized Testing", jPanel4);

        jLabel27.setText("Subject Information (Direct from form):");

        ibSubjects.setText("jLabel28");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(ibSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(ibSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("IB Subjects", jPanel9);

        jLabel14.setText("DP Point Totals:");

        ca1Total.setText("jLabel16");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(ca1Total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ca1Total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("CA 1", jPanel6);

        mrTotal.setText("jLabel16");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(mrTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(mrTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("MR", jPanel7);

        ca2Total.setText("jLabel16");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(ca2Total)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ca2Total)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("CA 2", jPanel8);

        jLabel16.setText("Group 1 - Language A");

        jLabel18.setText("Group 2 - Language B");

        jLabel20.setText("Group 3 - Humanities");

        jLabel21.setText("Group 4 - Science");

        jLabel22.setText("Group 5 - Mathematics");

        jLabel23.setText("Group 6 -Arts/Additional Subject");

        jLabel24.setText("CA 1");

        jLabel25.setText("MR");

        jLabel26.setText("CA 2");

        g1CA1.setText("jLabel28");

        g2CA1.setText("jLabel29");

        g3CA1.setText("jLabel30");

        g4CA1.setText("jLabel31");

        g5CA1.setText("jLabel32");

        g6CA1.setText("jLabel33");

        g1MR.setText("jLabel34");

        g2MR.setText("jLabel35");

        g3MR.setText("jLabel36");

        g4MR.setText("jLabel37");

        g5MR.setText("jLabel38");

        g6MR.setText("jLabel39");

        g1CA2.setText("jLabel40");

        g2CA2.setText("jLabel41");

        g3CA2.setText("jLabel42");

        g4CA2.setText("jLabel43");

        g5CA2.setText("jLabel44");

        g6CA2.setText("jLabel45");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g5CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                                .addComponent(g5MR))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g6CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g6MR))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g1CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g1MR))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g4CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g4MR))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g3CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g3MR))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(g2CA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g2MR)))))
                .addGap(318, 318, 318)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(g6CA2)
                    .addComponent(g5CA2)
                    .addComponent(g4CA2)
                    .addComponent(g3CA2)
                    .addComponent(g2CA2)
                    .addComponent(g1CA2))
                .addGap(117, 117, 117))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(g1CA1)
                    .addComponent(g1MR)
                    .addComponent(g1CA2))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(g2CA1)
                    .addComponent(g2MR)
                    .addComponent(g2CA2))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(g3CA1)
                    .addComponent(g3MR)
                    .addComponent(g3CA2))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(g4CA1)
                    .addComponent(g4MR)
                    .addComponent(g4CA2))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(g5CA1)
                    .addComponent(g5MR)
                    .addComponent(g5CA2))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(g6CA1)
                    .addComponent(g6MR)
                    .addComponent(g6CA2))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(122, 122, 122))))
        );

        jTabbedPane1.addTab("School Grades", jPanel5);

        jLabel3.setText("Hello, Aryan Gulati Name Name Name");

        jTextField1.setText("Search by student ID or Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        errorField.setText("Error Text: Try this or that or this or that and it should work");

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jTextField1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1))
                .addGap(1, 1, 1)
                .addComponent(errorField, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String searchString = jTextField1.getText().toLowerCase();
        int index = -1;
        for (int i = 0; i < students.size(); i++){
            
            if (students.get(i).get("id").toLowerCase().contains(searchString) || students.get(i).get("autoEmail").toLowerCase().contains(searchString) || students.get(i).get("autoName").toLowerCase().contains(searchString) || students.get(i).get("name").toLowerCase().contains(searchString)) {
                index = i;
            }
        }
        populateViews(index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        students = Main.loadData(Main.accessTokenTemp);
        errorField.setText("Refreshed");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ca1Total;
    private javax.swing.JLabel ca2Total;
    private javax.swing.JLabel enterCitizenship;
    private javax.swing.JLabel enterCountryPreferences;
    private javax.swing.JLabel enterDateOfBirth;
    private javax.swing.JLabel enterDreamUni;
    private javax.swing.JLabel enterEmail;
    private javax.swing.JLabel enterHomeroom;
    private javax.swing.JLabel enterMajors;
    private javax.swing.JLabel enterName;
    private javax.swing.JLabel enterNationality;
    private javax.swing.JLabel errorField;
    private javax.swing.JLabel extracurriculars;
    private javax.swing.JLabel g1CA1;
    private javax.swing.JLabel g1CA2;
    private javax.swing.JLabel g1MR;
    private javax.swing.JLabel g2CA1;
    private javax.swing.JLabel g2CA2;
    private javax.swing.JLabel g2MR;
    private javax.swing.JLabel g3CA1;
    private javax.swing.JLabel g3CA2;
    private javax.swing.JLabel g3MR;
    private javax.swing.JLabel g4CA1;
    private javax.swing.JLabel g4CA2;
    private javax.swing.JLabel g4MR;
    private javax.swing.JLabel g5CA1;
    private javax.swing.JLabel g5CA2;
    private javax.swing.JLabel g5MR;
    private javax.swing.JLabel g6CA1;
    private javax.swing.JLabel g6CA2;
    private javax.swing.JLabel g6MR;
    private javax.swing.JLabel ibSubjects;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel leadershipRoles;
    private javax.swing.JLabel mrTotal;
    private javax.swing.JLabel previousSchools;
    private javax.swing.JLabel resultsSAT;
    private javax.swing.JLabel standardizedTests;
    private javax.swing.JLabel yearsInDIA;
    // End of variables declaration//GEN-END:variables
}
