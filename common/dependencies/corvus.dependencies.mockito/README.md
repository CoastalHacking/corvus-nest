
Wherein the reason for this plug-in:

* Hit [bug 349164](https://bugs.eclipse.org/bugs/show_bug.cgi?id=349164).
* Performed work-around described in [this SO post](https://stackoverflow.com/questions/28579999/securityexception-when-running-plain-junit-mockito-in-eclipse-rcp-project).
* Used [another SO post](https://stackoverflow.com/questions/22311165/handling-non-osgi-dependencies-when-integrating-maven-tycho-and-eclipse)
  as a helper in getting things working.
* Used `mockito-all` instead of `mockito-core` because the JAR for the core seemed corrupt
