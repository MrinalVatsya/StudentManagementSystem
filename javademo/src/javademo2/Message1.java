/**
 * 
 */
package javademo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author mrinalvatsya
 *
 */
public class Message1 {

	public static void main(String[] args) {
			Properties prop = new Properties();
			OutputStream output = null;
			try {
				
			output = new FileOutputStream("message.properties");
			prop.setProperty("{0}", "name is duplicate");
			//prop.setProperty("{1}", "");
			prop.store(output,null);
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
			finally {
				if(output!=null)
				{
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			InputStream input = null;
			try {

				input = new FileInputStream("message.properties");

				// load a properties file
				prop.load(input);

				// get the property value and print it out
				System.out.println(prop.getProperty("{0}"));
				System.out.println(prop.getProperty("1"));
			

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
}
