import java.io.File;

public class StartingPoint {
	static Settings def;
	public static void main(String args[]){
		Operations op = new Operations();
		File set = new File("C:\\ProgramData\\VLCMod\\Data\\Settings.dat");
		if(set.exists()){
			def = op.deserial();
		}else{
			def = new Settings(2, 2, true);
		}
		new firstWindow(def);
	}
}
	
