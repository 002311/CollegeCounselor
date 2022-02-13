package CollegeCounselor;

import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.IWorkbookTableCollectionPage;
import com.microsoft.graph.models.extensions.DriveItem;
import com.microsoft.graph.models.extensions.User;
import com.microsoft.graph.models.extensions.WorkbookTable;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.graph.requests.extensions.IWorkbookTableRowCollectionPage;
import com.microsoft.graph.models.extensions.WorkbookTableRow;
import java.util.List;
import com.microsoft.graph.requests.extensions.IDriveItemSearchCollectionPage;
import com.microsoft.graph.requests.extensions.*;

/**
 *
 * @author aryangulati
 */
public class Graph {
    
    private static IGraphServiceClient graphClient = null;
    private static SimpleAuthProvider authProvider = null;
    
    private static void ensureGraphClient(String accessToken){
        
        if (graphClient == null) {
            // Create the auth provider
            authProvider = new SimpleAuthProvider(accessToken);

            // Create default logger to only log errors
            DefaultLogger logger = new DefaultLogger();
            logger.setLoggingLevel(LoggerLevel.ERROR);

            // Build a Graph client
            graphClient = GraphServiceClient.builder()
                .authenticationProvider(authProvider)
                .logger(logger)
                .buildClient();
        }
    }
    
    public static User getUser(String accessToken) {
        ensureGraphClient(accessToken);

        // GET /me to get authenticated user
        User me = graphClient
            .me()
            .buildRequest()
            .get();

        return me;
    }
    
    public static List<WorkbookTableRow> getTableData(String accessToken){
        ensureGraphClient(accessToken);
        
        
       
     
        IDriveItemSearchCollectionPage search = graphClient.me().drive().root()
            .search("Classof2021UniversityApplicationFormSorted")
            .buildRequest()
            .get();
    
        List<DriveItem> list = search.getCurrentPage();
        DriveItem driveItem = list.get(0);
        
     
        
        String driveItemid = driveItem.id; //gets the ID for the file so that it can be used in furhter Graph Queries
        
       IWorkbookTableCollectionPage tables = graphClient.me().drive().items(driveItemid).workbook().worksheets("Data").tables()
	.buildRequest()
	.get();  

       List<WorkbookTable> tableList =  tables.getCurrentPage(); //adds all tables in workbook to a list. This makes it accessible for later

       WorkbookTable table = tableList.get(0);
       String tableName = table.name;
       
       IWorkbookTableRowCollectionPage rows = graphClient.me().drive().items(driveItemid).workbook().tables(tableName).rows() //gets all rows in the current table
	.buildRequest()
	.get();
       
       List<WorkbookTableRow> rowData = rows.getCurrentPage(); //List of all data in the table as a workbook table row
       
       return rowData; 
       
    }
    
}
