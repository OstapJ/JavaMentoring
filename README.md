# JavaMentoring
It is intended to collect all tasks in Java mentoring program

The parent-project pom file is a parent which aggregates the following sub modules:
- framework
- UILayer
- APILayer

It keeps the general settings which are aplicable to all chile modules, like compilation plugin, test plugin and so on.

framework module keeps the selenium dependency and it is injected to UILayer and APILayer modules as a dependency. It allows it to be used 
in inside them.

Module organization uses the flat project constuction, in other words all modules reside on the same hierarchy level.
parent-project
              ...pom.xml
framework
              ...pom.xml
UILayer
              ...pom.xml
APILayer
              ...pom.xml
