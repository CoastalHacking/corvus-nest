package corvus.model.link.resource;

import corvus.model.link.LinkContainer;
import corvus.model.link.LinkFactory;
import corvus.model.link.LinkPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.resource.ResourceManager;

@SuppressWarnings("all")
public class LinkResourceManager extends ResourceManager {
  private LinkPackage package_ = LinkPackage.eINSTANCE;
  
  public LinkPackage getPackage() {
    return this.package_;
  }
  
  public void setPackage(final LinkPackage package_) {
    this.package_ = package_;
  }
  
  private LinkFactory factory = LinkFactory.eINSTANCE;
  
  public LinkFactory getFactory() {
    return this.factory;
  }
  
  public void setFactory(final LinkFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public void initialize(final Resource it) {
    LinkContainer linkContainer = this.factory.createLinkContainer();
    EList<EObject> _contents = it.getContents();
    _contents.add(linkContainer);
  }
}
