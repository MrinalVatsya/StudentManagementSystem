/**
 * 
 */
package javademo2;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
/**
 * @author mrinalvatsya
 *
 */
public class CityInsertSQL {

	/**
	 * @param args
	 */
	static String fileName = "c://LegalOneDev//City.txt";
	
	public static void main(String[] args) {
		
		Path path = Paths.get("c://LegalOneDev//City1.txt");
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			Integer startRange = 46;
			Integer endRange = startRange + 1;
			AtomicInteger count = new AtomicInteger(0);
			//count.addAndGet(startRange*2000);
			
			try(BufferedWriter writer = Files.newBufferedWriter(path)) {
				stream.forEach(insertQuery ->{
					
					if(count.get() >= startRange * 2000 && count.get() <  endRange * 2000) {
						try {
							writer.write(insertQuery);
							writer.write('\n');
						} catch (IOException e) {
						}
						
					}
					
					count.getAndIncrement();
				});
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
