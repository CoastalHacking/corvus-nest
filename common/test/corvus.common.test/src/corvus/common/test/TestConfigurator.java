package corvus.common.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.config.Configurator;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class TestConfigurator extends Configurator {

	private URI result;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	public URI resourceURI(Object object) {
		if (result == null) {
			try {
				tempFolder.create();
				result = URI.createFileURI(tempFolder.newFile().getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
