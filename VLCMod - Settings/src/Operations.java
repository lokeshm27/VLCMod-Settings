import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Operations {

	public Settings deserial() {
		Settings s;
		try{
			File data = new File("C:\\ProgramData\\VLCMod\\Data\\Settings.dat");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data));
			s = (Settings)ois.readObject();
			ois.close();
			return s;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}	
	
	public void serial(Settings s){
		try{
			File data = new File("C:\\ProgramData\\VLCMod\\Data\\Settings.dat");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data));
			oos.writeObject(s);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
