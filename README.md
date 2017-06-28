# Corvus Nest

From [Wikipedia][wikicorvus]:

> Corvus is a widely distributed genus of medium-sized to large birds in the family Corvidae. The genus includes species commonly known as crows, ravens, rooks and jackdaws;
> ...
> Recent research has found some crow species capable of not only tool use, but also tool construction. Crows are now considered to be among the world's most intelligent animals with an encephalization quotient equal to that of many non-human primates.

Corvus is a set of enhancements to the Eclipse IDE to aid security assessors when performing a manual security code review.

Corvus Nest is a confederacy of these enhancements.

[wikicorvus]: https://en.wikipedia.org/wiki/Corvus

## Model

Corvus uses [EMF models][EMF] for its model representation.

A model:

* Can have attributes, like integers and strings (think primitives)
* Can contain other models via a containment reference (think objects)
* Can reference other models via a non-containment reference (think pointer) 
* Can be contained in a resource, where a resource can be contained in a set of resources

Please refer to the [Vogella EMF tutorial][vogellaemf] for more information on
EMF.

[EMF]: https://eclipse.org/modeling/emf/
[vogellaemf]: http://www.vogella.com/tutorials/EclipseEMF/article.html

## Domain

Loosely defined, a domain is something outside of Corvus that can do the following:

* Domain to model (d2m): Provide models to Corvus, usually conveying domain semantics
* Model to model (m2m): Create additional models based upon events, for example when
 some domain adds a model
* Model to domain (m2v): View / edit models in Corvus using the domain's view technology

In this project, [Eclipse e4][vogellae4] and [Eclipse JFace][vogellajface] make
up the view domain. [Eclipse Resources API][eclipseresources] semantics are
loosely modeled to link editors (via [resource markers][resourcemarkers])
to the Corvus models.  
 
[vogellae4]: http://www.vogella.com/tutorials/EclipseRCP/article.html
[vogellajface]: http://www.vogella.com/tutorials/EclipseJFace/article.html
[eclipseresources]: https://help.eclipse.org/oxygen/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fcore%2Fresources%2Fpackage-summary.html
[resourcemarkers]: http://help.eclipse.org/oxygen/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Fguide%2FresAdv_markers.htm

## License

Unless otherwise specified, this code is licensed under the Eclipse Public License (https://www.eclipse.org/legal/epl-v10.html)
