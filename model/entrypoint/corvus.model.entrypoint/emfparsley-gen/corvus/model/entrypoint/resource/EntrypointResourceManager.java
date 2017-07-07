package corvus.model.entrypoint.resource;

import corvus.model.entrypoint.EntryPointFramework;
import corvus.model.entrypoint.EntrypointFactory;
import corvus.model.entrypoint.EntrypointPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.resource.ResourceManager;

@SuppressWarnings("all")
public class EntrypointResourceManager extends ResourceManager {
  private EntrypointPackage package_ = EntrypointPackage.eINSTANCE;
  
  public EntrypointPackage getPackage() {
    return this.package_;
  }
  
  public void setPackage(final EntrypointPackage package_) {
    this.package_ = package_;
  }
  
  private EntrypointFactory factory = EntrypointFactory.eINSTANCE;
  
  public EntrypointFactory getFactory() {
    return this.factory;
  }
  
  public void setFactory(final EntrypointFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public void initialize(final Resource it) {
    EntryPointFramework framework = this.factory.createEntryPointFramework();
    EList<EObject> _contents = it.getContents();
    _contents.add(framework);
  }
}
