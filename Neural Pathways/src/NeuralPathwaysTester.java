
public class NeuralPathwaysTester {

	public static void main(String[] args) {
		
		String tableName = "TestTable";
		String tableCreationString = "(column1 varchar(4000) not null PRIMARY KEY, column2 varchar(4000) not null, column3 varchar(4000) not null);";
		String insertionString = "";
		String column = "column1";
   	 	String rowToDelete = ("DELETE FROM " + tableName + " WHERE column1='" + column + "';");
		
		DatabaseOperations DBOps = new DatabaseOperations();
		DBOps.connectToDB();
		//DBOps.DeleteRowFromTable(tableName, rowToDelete);
		//DBOps.InsertIntoTable(tableName, insertionString);
		DBOps.RetrieveNumberOfRowsInTable(tableName);
	}
}
