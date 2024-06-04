package cache;

import org.hibernate.Session;

import com.tut.mapping.ProjectMappingConfig;

public class firstLevelCache {
	public static void main(String[] args) {
		ProjectMappingConfig config = new ProjectMappingConfig();
		Session s = config.getConfiguration();
	}
}
