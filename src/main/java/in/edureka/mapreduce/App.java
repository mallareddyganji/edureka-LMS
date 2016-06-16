package in.edureka.mapreduce;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("Hello World!");
		logger.info("{} info Hello World! from App");
		logger.debug("{} debug Hello World! from App");
		logger.warn("{} warn Hello World! from App");
		logger.error("{} error Hello World! from App");

		Properties props = System.getProperties();
		// System.out.println("props:" + props); //output in Single line
		// props.list(System.out);
		logger.debug("{} App : props:" + props);
		// logger.debug("{} App : props:" + props);
	}
}
