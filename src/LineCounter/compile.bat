"C:\Program Files\Java\jdk1.6.0_19\bin\javac.exe" LineCounter.java
echo Main-Class: LineCounter>manifest.mf
"C:\Program Files\Java\jdk1.6.0_19\bin\jar.exe" mcf manifest.mf LineCounter.jar *.class
del *.class
del *.mf
pause