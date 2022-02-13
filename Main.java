package CollegeCounselor;

import java.io.IOException;
import java.util.Properties;
import com.microsoft.graph.models.extensions.User;
import com.microsoft.graph.models.extensions.WorkbookTableRow;
import java.util.*;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author aryangulati
 */
public class Main {
    
    static String accessTokenTemp = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        final Properties oAuthProperties = new Properties();
        
        try {
            oAuthProperties.load(Main.class.getResourceAsStream("oAuth.properties"));
            System.out.println("oAuth Loaded");
        } catch (IOException e) {
            System.out.println("Unable to read OAuth configuration. Make sure you have a properly formatted oAuth.properties file. See README for details.");
            return;
        }

        final String appId = oAuthProperties.getProperty("app.id");
        final String[] appScopes = oAuthProperties.getProperty("app.scopes").split(",");
    
        Authentication.initialize(appId);
        final String accessToken = Authentication.getUserAccessToken(appScopes);
        accessTokenTemp = accessToken;
        
        // Greet the user
        User user = Graph.getUser(accessToken);
        String name = user.displayName;
       
       try{ 
           //Load the GUI
        formStart(name, loadData(accessToken));
        
       } catch (Exception e){
           
           AuthenticationUI.jLabel1.setText("File error.");
           
       }

    }
    
    //Read all data from the excel file into a List of Maps
    public static List<Map<String,String>>loadData(String accessToken){
        
        
         List<WorkbookTableRow> excelData =  Graph.getTableData(accessToken);
        List<Map<String,String>> students = new ArrayList<>();
        
        for (WorkbookTableRow rawData : excelData){
                        students.add(mapValues(rawData.values));

            
        }
        
        return students;
        
    }
    
    //Parse each Json element and store its data in a map
    private static Map<String,String> mapValues(JsonElement input){
        
        JsonArray inputAsArray = input.getAsJsonArray();
        JsonElement data = inputAsArray.get(0);
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> jsonAsList = new Gson().fromJson(data, listType);
        String[] mapLabels = new String[]{"submissionid", "formStartTime", "formSubmittedTime", "autoEmail", "autoName", "name", "id", "schoolEmail", "homeroom", "nationality", "citizenship", "dateOfBirth", "yearsInDIA", "previousSchools", "countryPreferences", "dreamUni", "chosenMajor", "ibSubjects", "extraCurriculars","leadership" , "referenceTeachers", "standardizedTestingStatus", "g1CA1", "g1MR", "g1CA2", "g2CA1", "g2MR", "g2CA2", "g3CA1", "g3MR", "g3CA2", "g4CA1", "g4MR", "g4CA2", "g5CA1", "g5MR", "g5CA2", "g6CA1", "g6MR", "g6CA2", "standardizedTestingScores"};
        
        Map<String,String> output = new HashMap<>();
        
        for (int i = 0; i < mapLabels.length; i++){
            
            output.put(mapLabels[i], jsonAsList.get(i));
        }
        
        
        
        
        return output;
    }
    
    public static void formStart(String name, List<Map<String,String>> data){
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CollegeCounselorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CollegeCounselorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CollegeCounselorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CollegeCounselorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CollegeCounselorGUI(name, data).setVisible(true);
            }
        });
        
        
    }
    
}
